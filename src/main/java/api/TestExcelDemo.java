package api;

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

    public static List<Map<String, String>> getExcelData() throws IOException {

        // Load the Excel file
        FileInputStream excelFile = new FileInputStream("src/test/resources/CreateBooking.xlsx");
        Workbook workbook = new XSSFWorkbook(excelFile);
        Sheet sheet = workbook.getSheetAt(0); // Assuming data is on the first sheet
        Map<String, String> mapData = new HashMap<>();

        Row firstRow = sheet.getRow(0);
        List<Map<String, String>> data = new ArrayList<>();


        for (int currentRow = 1; currentRow <= sheet.getLastRowNum(); currentRow++) {
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
