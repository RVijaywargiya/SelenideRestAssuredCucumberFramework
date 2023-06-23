package api;

import io.restassured.response.ValidatableResponse;
import pojo.BookingDetails;

import static io.restassured.RestAssured.given;

public class Booking {

    public ValidatableResponse getBooking() {
        return given()
                .baseUri("https://restful-booker.herokuapp.com/booking")
                .basePath("/54")
                .log()
                .all()
                .when()
                .get()
                .then()
                .log()
                .all();
    }

    public BookingDetails getBookingAsClass() {
        return getBooking().extract().as(BookingDetails.class);
    }
}
