package com.api.tests;

import api.Booking;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.MockUtils;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class AirlineTests {
    Booking booking = new Booking();

    SoftAssert softAssert = new SoftAssert();

    MockUtils mockUtils = new MockUtils();

    @Test
    public void verifyGetBookingStatusCode() throws IOException {
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

    @Test
    public void testMock() {
        mockUtils.startMockServer();
        mockUtils.setWireMockServer();
        ValidatableResponse response = given()
                .baseUri("http://localhost:8080")
                .log()
                .all()
                .get("/test")
                .then()
                .log()
                .all();
        mockUtils.stopMockServer();
    }
}
