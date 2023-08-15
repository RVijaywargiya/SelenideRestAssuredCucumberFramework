package api;

import io.restassured.response.ValidatableResponse;
import pojo.BookingDetails;
import utils.ApiUtils;

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
                .body("{\n" +
                        "    \"firstname\" : \"Jim\",\n" +
                        "    \"lastname\" : \"Brown\",\n" +
                        "    \"totalprice\" : 111,\n" +
                        "    \"depositpaid\" : true,\n" +
                        "    \"bookingdates\" : {\n" +
                        "        \"checkin\" : \"2018-01-01\",\n" +
                        "        \"checkout\" : \"2019-01-01\"\n" +
                        "    },\n" +
                        "    \"additionalneeds\" : \"Breakfast\"\n" +
                        "}")
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
