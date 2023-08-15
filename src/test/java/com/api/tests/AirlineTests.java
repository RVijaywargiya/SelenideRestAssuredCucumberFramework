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
    public void verifyCreateBookingStatusCode() throws IOException {
        ValidatableResponse bookingResponse = booking.createBooking();
        bookingResponse.statusCode(201);
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
