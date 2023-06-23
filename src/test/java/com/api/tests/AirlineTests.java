package com.api.tests;

import api.Booking;
import io.restassured.response.ValidatableResponse;
import org.apache.http.protocol.HTTP;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class AirlineTests {
    Booking booking = new Booking();

    SoftAssert softAssert = new SoftAssert();

    @Test
    public void verifyGetBookingStatusCode() {
        ValidatableResponse bookingResponse = booking.getBooking();
        bookingResponse.statusCode(200);
    }



    @Test
    public ValidatableResponse createBooking() {
        return given()
                .baseUri("https://restful-booker.herokuapp.com")
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
                .post("/booking")
                .then()
                .log()
                .all();
    }
}
