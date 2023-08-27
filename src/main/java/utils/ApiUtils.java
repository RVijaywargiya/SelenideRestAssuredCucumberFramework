package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.ValidatableResponse;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ApiUtils extends ExcelUtils {

    public static String getBaseUri() throws IOException {
        return new PropertyUtils().getProperty("src/main/resources/config/api-config.properties", "baseUri");
    }
    protected static String getBasePathGET() throws IOException {
        return new PropertyUtils().getProperty("src/main/resources/config/api-config.properties", "basePathGET");
    }
    protected static String getBasePathPOST() throws IOException {
        return new PropertyUtils().getProperty("src/main/resources/config/api-config.properties", "basePathPOST");
    }

    public List<Map<String, String>> getJsonAsListOfMap() throws IOException {
//        JSONObject jsonObject = new JSONObject();
//        ObjectMapper objectMapper = new ObjectMapper();
//        JSONArray jsonArray = new JSONArray();

        return ExcelUtils.getExcelData();
    }

    public void writeJsonToFile(ValidatableResponse response, String outputFile) throws IOException {
        String responseBody = response.extract().asString();
        try (FileWriter fileWriter = new FileWriter(outputFile)) {
            fileWriter.write(responseBody); // Use an indentation of 4 for pretty printing
            System.out.println("Response saved to response.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int getStatusCode(ValidatableResponse response) {
        return response.extract().statusCode();
    }
}
