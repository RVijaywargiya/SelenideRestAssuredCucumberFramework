package api;

import io.restassured.response.ValidatableResponse;
import pojo.BookingDetails;
import utils.ApiUtils;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class Booking extends ApiUtils {

    public ValidatableResponse getBooking() throws IOException {
        return given()
                .baseUri(getBaseUri())
                .basePath(getBasePath())
                .log()
                .all()
                .when()
                .get()
                .then()
                .log()
                .all();
    }

    public BookingDetails getBookingAsClass() throws IOException {
        return getBooking().extract().as(BookingDetails.class);
    }
}
