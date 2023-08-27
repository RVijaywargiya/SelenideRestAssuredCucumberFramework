package api;

import groovyjarjarantlr4.v4.misc.OrderedHashMap;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestExcelDemo {

    public static List<OrderedHashMap<String, String>> getExcelData() throws IOException {

        // Load the Excel file
        FileInputStream excelFile = new FileInputStream("src/test/resources/CreateBooking.xlsx");
        Workbook workbook = new XSSFWorkbook(excelFile);
        Sheet sheet = workbook.getSheetAt(0); // Assuming data is on the first sheet

        Row firstRow = sheet.getRow(0);
        List<OrderedHashMap<String, String>> data = new ArrayList<>();
        OrderedHashMap<String, String> mapData;
        
        for (int currentRow = 1; currentRow <= sheet.getLastRowNum(); currentRow++) {
            mapData = new OrderedHashMap<>();
            for (int currentCell = 0; currentCell < firstRow.getLastCellNum(); currentCell++) {
                mapData.put(getCellValue(firstRow.getCell(currentCell)), getCellValue(sheet.getRow(currentRow).getCell(currentCell)));
            }
            data.add(mapData);
        }
        return data;
    }

    private static String getCellValue(Cell cell) {
        Object cellValue = null;
        switch (cell.getCellType()) {
            case NUMERIC, BLANK -> {
                cellValue = cell.getNumericCellValue();
            }
            case STRING -> {
                cellValue = cell.getStringCellValue();
            }
            case BOOLEAN -> {
                cellValue = cell.getBooleanCellValue();
            }
        }
        return String.valueOf(cellValue);
    }

    public static void main(String[] args) throws IOException {
        System.out.println(TestExcelDemo.getExcelData());
    }
}
