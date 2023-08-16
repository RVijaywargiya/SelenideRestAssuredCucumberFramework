package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
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

    public static String getExcelData() throws IOException {

        // Load the Excel file
        FileInputStream excelFile = new FileInputStream(new File("src/test/resources/CreateBooking.xlsx"));
        Workbook workbook = new XSSFWorkbook(excelFile);
        Sheet sheet = workbook.getSheetAt(0); // Assuming data is on the first sheet

        List<Map<String, Object>> excelDataList = new ArrayList<>();

        // Iterate through rows and columns to create a list of maps
        for (Row row : sheet) {
            Map<String, Object> rowData = new HashMap<>();
            for (Cell cell : row) {
                rowData.put(sheet.getRow(0).getCell(cell.getColumnIndex()).getStringCellValue(), cell.getStringCellValue());
            }
            excelDataList.add(rowData);
        }

        ObjectMapper objectMapper = new ObjectMapper();
        jsonPayload = objectMapper.writeValueAsString(excelDataList);
        workbook.close();
        return jsonPayload;
    }


}
