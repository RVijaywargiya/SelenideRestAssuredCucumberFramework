package utils;

import groovyjarjarantlr4.v4.misc.OrderedHashMap;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;

public class ExcelUtils {

    public static LinkedHashMap<String, Object> getExcelData() throws IOException {

        // Load the Excel file
        FileInputStream excelFile = new FileInputStream("src/test/resources/CreateBooking.xlsx");
        Workbook workbook = new XSSFWorkbook(excelFile);
        Sheet sheet = workbook.getSheetAt(0); // Assuming data is on the first sheet

        Row firstRow = sheet.getRow(0);
        OrderedHashMap<String, Object> mapData = null;
        OrderedHashMap<String, Object> bookingDates;

        for (int currentRow = 1; currentRow < sheet.getLastRowNum(); currentRow++) {
            mapData = new OrderedHashMap<>();
            bookingDates = new OrderedHashMap<>();
            for (int currentCol = 0; currentCol < firstRow.getLastCellNum(); currentCol++) {
                if (getCellValue(firstRow.getCell(currentCol)).equals("checkin")) {
                    bookingDates.put("checkin", getCellValue(sheet.getRow(currentRow).getCell(currentCol)));
                    mapData.put("bookingdates", bookingDates);
                } else if (getCellValue(firstRow.getCell(currentCol)).equals("checkout")) {
                    bookingDates.put("checkout", getCellValue(sheet.getRow(currentRow).getCell(currentCol)));
                    mapData.put("bookingdates", bookingDates);
                }
                else {
                    mapData.put((String) getCellValue(firstRow.getCell(currentCol)), getCellValue(sheet.getRow(currentRow).getCell(currentCol)));
                }
            }
        }
        return mapData;
    }

    private static Object getCellValue(Cell cell) {
        Object cellValue = null;
        switch (cell.getCellType()) {
            case NUMERIC -> {
                cellValue = (int) cell.getNumericCellValue();
            }

            case STRING -> {
                cellValue = cell.getStringCellValue();
            }

            case BOOLEAN -> {
                cellValue = cell.getBooleanCellValue();
            }

        }
        return cellValue;
    }
}
