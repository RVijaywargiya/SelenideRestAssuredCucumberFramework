package api;

import io.restassured.response.ValidatableResponse;
import pojo.BookingDetails;
import utils.ApiUtils;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class Booking extends ApiUtils {

    public ValidatableResponse getAllBookings() throws IOException {
        return getRequestSpecs()
                .log()
                .all()
                .get(getBasePathGET())
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
        return getAllBookings().extract().as(BookingDetails.class);
    }
}
