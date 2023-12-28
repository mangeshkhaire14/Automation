package com.mkautomation.util;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelUtility {

    public static void readDataFromExcelFile(String filePath, String fileName, String sheetName) throws IOException {

        File file = new File(filePath + "//" + fileName);
        FileInputStream inputStream = new FileInputStream(file);
        Workbook workbook = null;

        String fileExtension = fileName.substring(fileName.indexOf("."));
        XSSFWorkbook xssfWorkbook = null;
        if (fileExtension.equals(".xlsx")) {
            //create object of XSSFWorkbook class if file extension is xlsx
            xssfWorkbook = new XSSFWorkbook(inputStream);
        } else if (fileExtension.equals(".xls")) {
            //create object of HSSFWorkbook class if file extension is xls
            workbook = new HSSFWorkbook(inputStream);
        }


        Sheet workbookSheet = xssfWorkbook.getSheet(sheetName);
        int rowCount = workbookSheet.getLastRowNum() - workbookSheet.getFirstRowNum();
        for (int i = 0; i < rowCount + 1; i++) {
            Row row = workbookSheet.getRow(i);
            //Below code will print cell values in a row
            for (int j = 0; j < row.getLastCellNum(); j++) {
                System.out.print(row.getCell(j).getStringCellValue() + "|| ");
            }
            System.out.println();
        }
        xssfWorkbook.close();
        inputStream.close();
    }

    public static Object[][] getData(String filePath, String sheetName) throws IOException {

        FileInputStream fileInputStream = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(fileInputStream);
        Sheet sheet = workbook.getSheet(sheetName);

        Iterator<Row> rowIterator = sheet.iterator();
        List<Object[]> testdata = new ArrayList<>();
        while (rowIterator.hasNext()) {
            Row currentRow = rowIterator.next();
            Iterator<Cell> cellIterator = currentRow.iterator();

            List<Object> rowData = new ArrayList<>();
            while (cellIterator.hasNext()) {
                Cell currentCell = cellIterator.next();
                rowData.add(currentCell.getStringCellValue());

               /* switch (currentCell.getCellType()) {
                    case STRING:
                        rowData.add(currentCell.getStringCellValue());
                   /* case NUMERIC:
                        rowData.add(currentCell.getNumericCellValue());
                    case BOOLEAN:
                        rowData.add(currentCell.getBooleanCellValue());

                    default:
                        rowData.add(null);
                }*/

            }
            testdata.add(rowData.toArray());
        }
        workbook.close();
        fileInputStream.close();
        return testdata.toArray(new Object[0][]);
    }

    public static void main(String args[]) throws IOException {

        ExcelUtility util = new ExcelUtility();
        String filePath = "src//test//resources//testdata";
        String fileName = "saucedemo.xlsx";
        String sheetName = "Sheet1";
        readDataFromExcelFile(filePath, fileName, sheetName);

        Object[][] testdataArray= getData(filePath + "//" + fileName, sheetName);
        List<Object[]> testdata=List.of(testdataArray);

        System.out.println("Using getData()");
        for(Object[] data:testdata){
            System.out.println(String.valueOf(data[0]));
            System.out.println(String.valueOf(data[1]));
        }
    }
}