package api;

import io.restassured.response.ValidatableResponse;
import pojo.BookingDetails;
import utils.ApiUtils;

import java.io.IOException;

public class Booking extends ApiUtils {

    public ValidatableResponse getAllBookings() throws IOException {
        return getRequestSpecs()
                .log()
                .all()
                .when()
                .get(getBasePathGET())
                .then()
                .log()
                .all();
    }

    public ValidatableResponse createBooking() throws IOException {
        return getRequestSpecs()
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
