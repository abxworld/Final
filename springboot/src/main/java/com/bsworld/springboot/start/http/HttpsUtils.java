package com.bsworld.springboot.start.http;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HttpsUtils {

    private static int connectionTimeout = 10000;// 连接超时时间,毫秒
    private static int soTimeout = 30000;// 读取数据超时时间，毫秒
    /** HttpClient对象 */
    private static CloseableHttpClient httpclient = HttpClients.
            custom().disableAutomaticRetries().build();
    /*** 超时设置 ****/
    private static RequestConfig requestConfig = RequestConfig.custom()
            .setSocketTimeout(soTimeout)
            .setConnectTimeout(connectionTimeout)
            .build();//设置请求和传输超时时间



    /**
     * 不验证证书的https请求
     * @param url
     * @return
     */
    public static String httpsGetClient(String url){
        StringBuilder result = new StringBuilder();
        try{
            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(SSLContexts.createDefault(),SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            CloseableHttpClient httpclient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
            try {
                HttpGet httpGet = new HttpGet(url);
                httpGet.addHeader(new BasicHeader("Content-Type", ContentType.APPLICATION_FORM_URLENCODED.getMimeType()));
                httpGet.addHeader(new BasicHeader("Content-Encoding", "UTF-8"));
                CloseableHttpResponse response = httpclient.execute(httpGet);
                try {
                    HttpEntity entity = response.getEntity();
                    if (entity != null) {
                        InputStream content = entity.getContent();
                        if (content != null) {
                            InputStreamReader isr = null;
                            BufferedReader bufferedReader = null;
                            try{
                                isr = new InputStreamReader(content);
                                bufferedReader = new BufferedReader(isr);
                                String text;
                                while ((text = bufferedReader.readLine()) != null) {
                                    result.append(text);
                                }
                            }finally {
                                if (isr != null)
                                    isr.close();
                                if (bufferedReader != null)
                                    bufferedReader.close();
                            }
                        }
                    }
                    EntityUtils.consume(entity);
                } finally {
                    response.close();
                }
            } finally {
                httpclient.close();
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return result.toString();
    }


    /**
     * 根据给定的URL地址和参数字符串，以Get方法调用，如果成功返回true，如果失败返回false
     *
     * @param strURL
     *            String url地址，不含参数
     * @param param
     *            Map<String, Object> 参数字表单
     * @return boolean true－成功，false失败，如果返回成功可以getStrGetResponseBody()
     *         获取返回内容字符串，如果失败，则可访问getErrorInfo()获取错误提示。
     */
    public static String executePostMethod(String strURL, Map<String, String> param) {
        String strResult = "";
        HttpPost post = new HttpPost(strURL);
        post.setConfig(requestConfig);
        List<BasicNameValuePair> paraList = new ArrayList<BasicNameValuePair>(param.size());
        for (Map.Entry<String, String> pEntry : param.entrySet()) {
            if(null != pEntry.getValue()){
                BasicNameValuePair nv = new BasicNameValuePair(pEntry.getKey(), pEntry.getValue());
                paraList.add(nv);
            }
        }
        //使用UTF-8
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paraList,Charset.forName("utf-8"));
        post.setEntity(entity);
        CloseableHttpResponse response=null;
        try {
            response = httpclient.execute(post);
            int iGetResultCode = response.getStatusLine().getStatusCode();
            if (HttpStatus.SC_OK == iGetResultCode) {
                HttpEntity responseEntity = response.getEntity();
                strResult = EntityUtils.toString(responseEntity);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if(response!=null){
                    response.close();
                }
            } catch (IOException e) {
            }
        }
        return strResult;
    }

    /**
     * 不验证证书的https请求 返回InputStream
     * @param url
     * @param requestText
     * @return
     */
    public static byte[] httpsClientReturnIS(String url,String requestText){
        byte[] result = null;
        try{
            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(SSLContexts.createDefault(),SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            CloseableHttpClient httpclient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
            try {
                HttpPost httpPost = new HttpPost(url);
                StringEntity se = new StringEntity(requestText, "UTF-8");
                se.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
                se.setContentEncoding("UTF-8");
                httpPost.setEntity(se);
                CloseableHttpResponse response = httpclient.execute(httpPost);
                try {
                    HttpEntity entity = response.getEntity();
                    if (entity != null) {
                        InputStream inputStream = null;
                        try{
                            inputStream = entity.getContent();
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1000);
                            byte[] bytes = new byte[1000];
                            int n;
                            while ((n=inputStream.read(bytes))!=-1){
                                byteArrayOutputStream.write(bytes,0,n);
                            }
                            byteArrayOutputStream.close();
                            result = byteArrayOutputStream.toByteArray();
                            //String res = new String(result,"UTF-8");
                            //System.out.println(res);
                        } finally {
                            if (inputStream != null)
                                inputStream.close();
                        }
                    }
                    EntityUtils.consume(entity);
                } finally {
                    response.close();
                }
            } finally {
                httpclient.close();
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(HttpsUtils.httpsGetClient("http://idgenerator.dev.imdada.cn/seq"));
    }
}
