package com.bsworld.springboot.start.uniq_id;

import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.dao.DuplicateKeyException;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * program: Final
 * author: bsworld.xie
 * create: 2019-10-25 14:08
 * description:
 */
public abstract class IpNumber {


    private static String ipCode;

    private static List<String> combineList = new ArrayList<>();


    protected abstract List<IPCodeInfo> getAllIPCodeInfo();


    protected abstract void upsert(IPCodeInfo ipCodeInfo);


    public void manage() {
        List<IPCodeInfo> ipCodeInfos = getAllIPCodeInfo();
        String localHost = getLocalHost();
        boolean init = false;
        for (IPCodeInfo ipCodeInfo : ipCodeInfos) {
            String code = ipCodeInfo.getCode();
            if (localHost.equals(ipCodeInfo.getIpAddress())) {
                initIpCode(code);
                break;
            }
        }

        String nonCode = null;
        if (!init) {
            List<String> haveUseCodes = ipCodeInfos.stream().map(IPCodeInfo::getCode).collect(Collectors.toList());
            List<String> noneUseCodes = combineList.stream().filter(m -> haveUseCodes.stream().noneMatch(n -> m.equals(n))).filter(m -> m != null && m.trim().length() > 0).collect(Collectors.toList());
            if (CollectionUtils.isEmpty(noneUseCodes)) {
                throw new IllegalStateException("have none use ip code");
            }
            int retryTimes = getRetryTimes();
            if (retryTimes < 0) {
                throw new IllegalStateException("retry times must greater or equals 0");
            }
            //重试次数是正常次数加1
            for (int i = 0; i < retryTimes + 1; i++) {
                try {
                    nonCode = noneUseCodes.get(i);
                    IPCodeInfo info = new IPCodeInfo();
                    info.setCode(nonCode);
                    info.setIpAddress(localHost);
                    info.setCreateTime(new Date());
                    info.setUpdateTime(new Date());
                    info.setIdleTime(new Date());
                    upsert(info);
                    break;
                } catch (DuplicateKeyException t) {
                    System.out.println("插入失败，重试");
                    noneUseCodes.remove(nonCode);
                    if (i == retryTimes) {
                        throw new IllegalStateException("重试失败,localHost:" + localHost + " ");
                    }
                }
            }
        }
        registerIdle(localHost, nonCode);
    }


    protected void registerIdle(String localHost,String ipCode) {

    }


    //清理长久不使用的ipCode，防止ipCode资源耗尽
    protected void clear() {

    }


    protected int getRetryTimes() {

        return 10;
    }


    /**
     * 可以由下层去继承来获取新的IpCode
     */
    protected List<String> getIPCode() {
        List<String> numberL = Lists.newArrayList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9");
        List<String> lowL = Lists.newArrayList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z");
        List<String> upL = Lists.newArrayList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z");
        ArrayList<List<String>> lists = Lists.newArrayList(numberL, lowL, upL);
        for (int i = 0; i < lists.size(); i++) {
            for (int j = 0; j < lists.size(); j++) {
                List<String> combine = combine(lists.get(i), lists.get(j));
                combineList.addAll(combine);
            }
        }
        return combineList;
    }


    private List<String> combine(List<String> cL1, List<String> cL2) {
        ArrayList<String> list = Lists.newArrayList();
        for (String c1 : cL1) {
            for (String c2 : cL2) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(c1);
                stringBuilder.append(c2);
                list.add(stringBuilder.toString());
            }
        }
        return list;
    }


    private static void initIpCode(String ipCodeInit) {
        ipCode = ipCodeInit;
    }

    public static String releaseIpCode() {

        return "00";
    }

    public String getLocalHost() {
        String localHost = null;
        try {
            localHost = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            ;
            e.printStackTrace();
            throw new IllegalStateException(e.getMessage(), e);
        }
        return localHost;
    }


    public static void main(String[] args) throws UnknownHostException {
        String localHost = InetAddress.getLocalHost().getHostAddress();

        System.out.println(localHost);
    }

}
