package com.bsworld.springboot.start.download;
/*
*author: xieziyang
*date: 2018/8/3
*time: 17:25
*description:
*/

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.*;
import java.util.concurrent.atomic.AtomicInteger;

public class World {
    static AtomicInteger atomicInteger = new AtomicInteger(0);
    static AtomicInteger line = new AtomicInteger(0);

    public static void main(String[] args) throws Exception {
         File file0 = new File("D:\\GitCode\\hello");
        File[] files = file0.listFiles();
        StringBuilder sb = new StringBuilder();
        for (File file : files) {
            int andIncrement = atomicInteger.getAndIncrement();
            if (andIncrement < 20) {
                getContent(file, sb);
            }
        }
        getData(sb.toString());
    }


    public static StringBuilder getContent(File file, StringBuilder sb) {
        //添加文本
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            InputStreamReader reader = new InputStreamReader(fis, "utf-8");
            BufferedReader br = new BufferedReader(reader);
            String readLine = br.readLine();
            while (readLine != null) {
                if (readLine.contains("package") || readLine.contains("import") || (readLine.contains("public") && readLine.contains("class")) || readLine.contains("\\\\")
                        || readLine.trim().equals("") || readLine.contains("*")
                        ) {
                    readLine = br.readLine();
                    continue;
                } else {
                    if (readLine.length() > 133) {
                        String substring0 = readLine.substring(0, 133);
                        String substring1 = readLine.substring(133);
                        sb.append(line.incrementAndGet() + "." + substring0 + "\n\r");
                        sb.append(line.incrementAndGet() + "." + substring1 + "\n\r");
                    } else {
                        sb.append(line.incrementAndGet() + "." + readLine + "\n\r");
                    }
                }
                // sb.append(line.incrementAndGet() + ".  " + readLine + "\n\r");
                readLine = br.readLine();
            }
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb;
    }


    public static void getData(String sb) throws Exception {
        XWPFDocument doc = new XWPFDocument();
        XWPFParagraph para;
        para = doc.createParagraph();
        para.setAlignment(ParagraphAlignment.LEFT);//设置左对齐
        String[] split = sb.split("\n");
        for (String s : split) {
            XWPFRun run1;
            run1 = para.createRun();
            run1.setText(s);
            run1.addCarriageReturn();
            run1.setFontFamily("仿宋");
            run1.setFontSize(13);
        }
        doc.createParagraph();
        String path = "D:\\hello.docx";
        OutputStream os = new FileOutputStream(path);
        doc.write(os);
        if (os != null) {
            try {
                os.close();
                System.out.println("文件已输出！");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}