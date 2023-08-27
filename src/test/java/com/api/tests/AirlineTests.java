package com.api.tests;

import api.Booking;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.MockUtils;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.apache.http.HttpStatus.SC_OK;
import static utils.ApiUtils.getStatusCode;

public class AirlineTests {
    Booking booking;

    SoftAssert softAssert = new SoftAssert();

    MockUtils mockUtils = new MockUtils();
    ValidatableResponse allBookingResponse;
    ValidatableResponse createBookingResponse;

    public AirlineTests() throws IOException {
        booking = new Booking();
        allBookingResponse = booking.getAllBookings();
        createBookingResponse = booking.createBooking();
    }

    @Test(enabled = false)
    public void verifyGetBookingStatusCode() throws IOException {
        softAssert.assertEquals(SC_OK, getStatusCode(allBookingResponse));
        booking.getBookingAsClass();
        System.out.println(booking.getBookingAsClass().toString());
    }

    @Test
    public void verifyCreateBookingStatusCode() throws IOException {
        softAssert.assertEquals(SC_CREATED, getStatusCode(createBookingResponse));
    }

    @Test(enabled = false)
    public void testMock() {
        mockUtils.startMockServer();
        mockUtils.setWireMockServer();
        ValidatableResponse response = given()
                .baseUri("http://localhost:8080")
                .log()
                .everything()
                .get("/test")
                .then()
                .log()
                .all();
        mockUtils.stopMockServer();
    }
}
