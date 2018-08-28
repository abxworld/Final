/*
package com.bsworld.springboot.start.web;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

*/
/*
*author: xieziyang
*date: 2018/8/1
*time: 20:22
*description:
*//*

@RequestMapping("/excel")
@Controller
public class ExcelController {
    @PostMapping(name = "down")
    public HttpServletResponse down(HttpServletResponse response) {
        try {
            XSSFWorkbook book = getBook();
           */
/* String fileName = new String("箱号信息模板.xls".getBytes("UTF-8"), "iso-8859-1");
            byte[] templateBytes = containerNumService.exportExcelTemplate();*//*

            response.setContentType("application/x-msdownload");
            response.setContentLength(templateBytes.length);
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName);//设置下载的文件名
            response.getOutputStream().write(templateBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    public XSSFWorkbook getBook() {
        XSSFWorkbook workbook = new XSSFWorkbook();
        //创建一个电子表格，对应excel表中的sheet
        XSSFSheet spreadsheet = workbook.createSheet("kitty information");
        //设置单元格格式
        XSSFCellStyle cellStyle = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
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
            XSSFRow row = spreadsheet.createRow(rowid++);
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
            outStream = new FileOutputStream(new File("D://writeSheet.xlsx"));
            workbook.write(outStream);
            outStream.close();
            System.out.println("写表成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
*/
