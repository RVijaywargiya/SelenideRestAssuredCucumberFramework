package api;

import io.restassured.response.ValidatableResponse;
import pojo.BookingDetails;
import utils.ApiUtils;
import utils.ExcelUtils;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class Booking extends ApiUtils {

    public ValidatableResponse getBooking() throws IOException {
        return getRequestSpecs()
                .get()
                .then()
                .log()
                .all();
    }

    public ValidatableResponse createBooking() throws IOException {
        return given()
                .baseUri(getBaseUri())
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .body(getJsonAsString())
                .log()
                .all()
                .when()
                .post(getBasePathPOST())
                .then()
                .log()
                .all();
    }

    public BookingDetails getBookingAsClass() throws IOException {
        return getBooking().extract().as(BookingDetails.class);
    }
}
