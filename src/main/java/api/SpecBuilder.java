package api;

import io.restassured.builder.RequestSpecBuilder;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static utils.ApiUtils.getBaseUri;

public class SpecBuilder {

    public static RequestSpecBuilder getRequestSpecs() throws IOException {
        return new RequestSpecBuilder()
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .setBaseUri(getBaseUri());
    }
}
