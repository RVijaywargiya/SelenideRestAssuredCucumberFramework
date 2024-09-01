package specs;

import interfaces.SpecBuilder;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.io.IOException;

import static utils.ApiUtils.getBaseUri;

public class ActualApi implements SpecBuilder {

    public RequestSpecBuilder getRequestSpecs() throws IOException {
        return new RequestSpecBuilder()
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .setBaseUri(getBaseUri())
                .log(LogDetail.ALL);
    }

    public ResponseSpecBuilder getResponseSpecs() {
        return new ResponseSpecBuilder()
                .log(LogDetail.ALL);
    }

    public static ActualApi getInstance() {
        return new ActualApi();
    }
}
