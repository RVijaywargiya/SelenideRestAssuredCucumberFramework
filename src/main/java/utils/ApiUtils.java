package utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class ApiUtils {

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
                .baseUri(getBaseUri())
                .basePath(getBasePathGET())
                .log()
                .all();
    }
}
