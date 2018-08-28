package com.bsworld.springboot.start.download;
/*
*author: xieziyang
*date: 2018/8/1
*time: 19:34
*description:
*/

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class ExcelDown {
    public static void main(String[] args) {
        HSSFWorkbook workbook = new HSSFWorkbook();
        //创建一个电子表格，对应excel表中的sheet
        HSSFSheet spreadsheet = workbook.createSheet("kitty information");
        //设置单元格格式
        HSSFCellStyle cellStyle = workbook.createCellStyle();
        HSSFFont font = workbook.createFont();
        font.setFontName("宋体");
        font.setFontHeightInPoints((short) 20);
        cellStyle.setFont(font);
        //数据
        Map<String, Object[]> info = new TreeMap<>();
        info.put("1", new Object[]{"日期", "地址", "爱好"});
        info.put("2", new Object[]{"20170629", "广州市", "游泳"});
        info.put("3", new Object[]{"20170630", "上海市", "打羽毛球"});
        info.put("4", new Object[]{"20170701", "北京市", "吃驴肉火烧"});
        Set<String> keyid = info.keySet();
        int rowid = 0;
        for (String key : keyid) {
            HSSFRow row = spreadsheet.createRow(rowid++);
            int cellid = 0;
            for (Object obj : info.get(key)) {
                Cell cell = row.createCell(cellid++);
                cell.setCellValue((String) obj);
                if (rowid == 0) {
                    cell.setCellStyle(cellStyle);
                }
            }
        }
        //输出到excel表
        FileOutputStream outStream;
        try {
            outStream = new FileOutputStream(new File("D://writeSheet.xls"));
            workbook.write(outStream);
            outStream.close();
            System.out.println("写表成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void run2() {
        HSSFWorkbook workbook = new HSSFWorkbook();
        workbook.getBytes();
    }
    @Test
    public void run3() {
        System.out.println("HHE\njj");
    }
}
