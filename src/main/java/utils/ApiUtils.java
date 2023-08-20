package utils;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import net.minidev.json.JSONObject;

import java.io.*;

import static io.restassured.RestAssured.given;

public class ApiUtils extends ExcelUtils{

    protected static String getBaseUri() throws IOException {
        return new PropertyUtils().getProperty("src/main/resources/config/api-config.properties", "baseUri");
    }
    protected static String getBasePathGET() throws IOException {
        return new PropertyUtils().getProperty("src/main/resources/config/api-config.properties", "basePathGET");
    }
    protected static String getBasePathPOST() throws IOException {
        return new PropertyUtils().getProperty("src/main/resources/config/api-config.properties", "basePathPOST");
    }

    public RequestSpecification getRequestSpecs() throws IOException {
        return given()
                .baseUri(getBaseUri());
    }

    public String getJsonAsString() throws IOException {
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
