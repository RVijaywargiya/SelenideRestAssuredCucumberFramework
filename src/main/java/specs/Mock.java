package specs;

import interfaces.SpecBuilder;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.io.IOException;

public class Mock implements SpecBuilder {

    public RequestSpecBuilder getRequestSpecs() {
        return new RequestSpecBuilder()
                .setBaseUri("http://localhost:8080")
                .log(LogDetail.ALL);
    }

    public ResponseSpecBuilder getResponseSpecs() {
        return new ResponseSpecBuilder()
                .log(LogDetail.ALL);
    }

    public static Mock getInstance() {
        return new Mock();
    }
}
