package com.api.tests;

import api.Booking;
import io.qameta.allure.Link;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.MockUtils;

import java.io.IOException;

import static org.apache.http.HttpStatus.SC_CREATED;
import static org.apache.http.HttpStatus.SC_OK;
import static utils.ApiUtils.getStatusCode;
import static utils.ApiUtils.setUpAllure;

public class AirlineTests {
    private Booking booking;
    private SoftAssert softAssert;
    private MockUtils mockUtils;
    Response allBookingResponse;
    Response createBookingResponse;
    Response mockResponse;

    @BeforeSuite
    public void setUp() {
        booking = new Booking();
        softAssert = new SoftAssert();
        mockUtils = new MockUtils();
        setUpAllure();
    }

    @Test
    @Link(name = "allure", type = "mylink")
    void verifyGetBookingStatusCode() throws IOException {
        allBookingResponse = booking.getAllBookings();
        softAssert.assertEquals(getStatusCode(allBookingResponse), SC_OK);
        softAssert.assertAll();
    }

    @Test
    @Step
    void verifyCreateBookingStatusCode() throws IOException {
        createBookingResponse = booking.createBooking();
        softAssert.assertEquals(getStatusCode(createBookingResponse), SC_OK);
        softAssert.assertAll();
    }

    @Test
//    @Ignore
    void testMock() {
        mockUtils.startMockServer();
        mockUtils.setWireMockServer();
        mockResponse = booking.getMockResponse();
        mockUtils.stopMockServer();
    }
}
