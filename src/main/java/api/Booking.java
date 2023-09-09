package api;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.ResponseSpecification;
import pojo.BookingDetails;
import utils.ApiUtils;

import java.io.IOException;

import static api.SpecBuilder.getRequestSpecs;
import static api.SpecBuilder.getResponseSpec;
import static io.restassured.RestAssured.given;

public class Booking extends ApiUtils {

    @Step
    public Response getAllBookings() throws IOException {
        return given()
                .spec(getRequestSpecs())
                .when()
                .get(getBasePathGET())
                .then()
                .spec(getResponseSpec())
                .extract()
                .response();
    }

    public Response createBooking() throws IOException {
        return given()
                .spec(getRequestSpecs())
                .body(getListOfMapsAsJsonArray())
                .when()
                .post(getBasePathPOST())
                .then()
                .spec(getResponseSpec())
                .extract()
                .response();
    }
}
