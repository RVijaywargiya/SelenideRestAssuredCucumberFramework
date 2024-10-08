package api;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import specs.ApiSpecBuilder;
import specs.Mock;
import utils.ApiUtils;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class Booking extends ApiUtils {

    @Step
    public Response getAllBookings() throws IOException {
        return given()
                .spec(ApiSpecBuilder.getInstance().getRequestSpecs().build())
                .when()
                .get(getBasePathGET())
                .then()
                .spec(ApiSpecBuilder.getInstance().getResponseSpecs().build())
                .extract()
                .response();
    }

    public Response createBooking() throws IOException {
        return given()
                .spec(ApiSpecBuilder.getInstance().getRequestSpecs().build())
                .body(getListOfMapsAsJsonArray())
                .when()
                .post(getBasePathPOST())
                .then()
                .spec(ApiSpecBuilder.getInstance().getResponseSpecs().build())
                .extract()
                .response();
    }

    public Response getMockResponse() {
        return given()
                .spec(Mock.getInstance().getRequestSpecs().build())
                .when()
                .get("/test")
                .then()
                .spec(Mock.getInstance().getResponseSpecs().build())
                .extract()
                .response();
    }
}
