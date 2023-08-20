package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
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

    public static String getExcelData() throws IOException {

        // Load the Excel file
        FileInputStream excelFile = new FileInputStream("src/test/resources/CreateBooking.xlsx");
        Workbook workbook = new XSSFWorkbook(excelFile);
        Sheet sheet = workbook.getSheetAt(0); // Assuming data is on the first sheet

        List<Map<String, Object>> excelDataList = new ArrayList<>();

        // Iterate through rows and columns to create a list of maps
        for (Row row : sheet) {
            Map<String, Object> rowData = new HashMap<>();
            for (Cell cell : row) {
                CellType cellType = cell.getCellType();
                if (cellType == CellType.STRING) {
                    System.out.print(cell.getStringCellValue() + "\t");
                } else if (cellType == CellType.NUMERIC) {
                    System.out.print(cell.getNumericCellValue() + "\t");
                } else if (cellType == CellType.BLANK) {
                    System.out.print("BLANK\t");
                }
                rowData.put(sheet.getRow(0).getCell(cell.getColumnIndex()).getStringCellValue(), sheet.getRow(1).getCell(cell.getColumnIndex()).getStringCellValue());
            }
            excelDataList.add(rowData);
        }

        ObjectMapper objectMapper = new ObjectMapper();
        jsonPayload = objectMapper.writeValueAsString(excelDataList);
        workbook.close();
        return jsonPayload;
    }


}
