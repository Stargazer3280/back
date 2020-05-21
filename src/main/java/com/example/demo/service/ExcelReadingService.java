package com.example.demo.service;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

public class ExcelReadingService {

    @Test
    public void poiTestMethod() throws Exception {

//        ClassPathResource classPathResource = new ClassPathResource("static/excel.xlsx");
//        //1.读取Excel文档对象
//        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(classPathResource.getInputStream());
//        SXSSFWorkbook sxssfWorkbook =new SXSSFWorkbook(xssfWorkbook);
//        //2.获取要解析的表格（第一个表格）
//
//        Sheet sheet = sxssfWorkbook.getSheetAt(0);
//        //获得最后一行的行号
//        long lastRowNum = sheet.getLastRowNum();
//        for (int i = 0; i <= lastRowNum; i++) {//遍历每一行
//            //3.获得要解析的行
//            Row row = sheet.getRow(i);
//            //4.获得每个单元格中的内容（String）
//            if (row.getCell(0) != null) {
//                row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
//                row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
//                String stringCellValue0 = row.getCell(0).getStringCellValue();
//                String stringCellValue1 = row.getCell(1).getStringCellValue();
//                System.out.println(stringCellValue0 + "\t" + stringCellValue1 + "\t");
//            }
//        }
    }
}