package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelUtils {

    static String jsonPayload;

    public static List<Map<String, String>> getExcelData() throws IOException {

        // Load the Excel file
        FileInputStream excelFile = new FileInputStream("src/test/resources/CreateBooking.xlsx");
        Workbook workbook = new XSSFWorkbook(excelFile);
        Sheet sheet = workbook.getSheetAt(0); // Assuming data is on the first sheet
        Map<String, String> mapData = new HashMap<>();

        Row firstRow = sheet.getRow(0);
        List<Map<String, String>> data = new ArrayList<>();

        for (int currentRow = 1; currentRow < sheet.getLastRowNum(); currentRow++) {
            for (int currentCol = 0; currentCol < firstRow.getLastCellNum(); currentCol++) {
                mapData.put(firstRow.getCell(currentCol).getStringCellValue(), sheet.getRow(currentRow).getCell(currentCol).getStringCellValue());
            }
            data.add(mapData);
        }
        return data;
    }
}
