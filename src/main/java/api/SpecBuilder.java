package api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static utils.ApiUtils.getBaseUri;

public class SpecBuilder {

    public static RequestSpecification getRequestSpecs() throws IOException {
        return new RequestSpecBuilder()
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .setBaseUri(getBaseUri())
                .log(LogDetail.ALL)
                .build();
    }

    public static ResponseSpecification getResponseSpec() {
        return new ResponseSpecBuilder().
                log(LogDetail.ALL).
                build();
    }
}
