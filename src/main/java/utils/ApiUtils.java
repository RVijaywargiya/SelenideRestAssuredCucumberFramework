package utils;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import java.io.IOException;

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

    public String getListOfMapsAsJsonArray() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(ExcelUtils.getExcelData());
    }

//    public void writeJsonToFile(ValidatableResponse response, String outputFile) {
//        String responseBody = response.extract().asString();
//        try (FileWriter fileWriter = new FileWriter(outputFile)) {
//            fileWriter.write(responseBody); // Use an indentation of 4 for pretty printing
//            System.out.println("Response saved to response.json");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    public static int getStatusCode(Response response) {
        return response.statusCode();
    }

    public static void setUpAllure() {
        Configuration.reportsFolder = "allure-reports";
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
    }
}
