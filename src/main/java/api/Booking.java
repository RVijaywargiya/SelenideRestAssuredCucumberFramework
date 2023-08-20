package api;

import io.restassured.response.ValidatableResponse;
import pojo.BookingDetails;
import utils.ApiUtils;

import java.io.IOException;

import static api.SpecBuilder.getRequestSpecs;
import static io.restassured.RestAssured.given;

public class Booking extends ApiUtils {

    public ValidatableResponse getAllBookings() throws IOException {
        return given()
                .spec(getRequestSpecs().build())
                .log()
                .all()
                .when()
                .get(getBasePathGET())
                .then()
                .log()
                .all();
    }

    public ValidatableResponse createBooking() throws IOException {
        return given()
                .spec(getRequestSpecs().build())
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
