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
    Booking booking = new Booking();
    SoftAssert softAssert = new SoftAssert();
    MockUtils mockUtils = new MockUtils();
    Response allBookingResponse;
    Response createBookingResponse;
    Response mockResponse;

    @BeforeSuite
    public void setAllureReporting() {
        setUpAllure();
    }

    @Test
    @Link(name = "allure", type = "mylink")
    public void verifyGetBookingStatusCode() throws IOException {
        allBookingResponse = booking.getAllBookings();
        softAssert.assertEquals(SC_OK, getStatusCode(allBookingResponse));
    }

    @Test
    @Step
    public void verifyCreateBookingStatusCode() throws IOException {
        createBookingResponse = booking.createBooking();
        softAssert.assertEquals(SC_CREATED, getStatusCode(createBookingResponse));
    }

    @Test
//    @Ignore
    public void testMock() {
        mockUtils.startMockServer();
        mockUtils.setWireMockServer();
        mockResponse = booking.getMockResponse();
        mockUtils.stopMockServer();
    }
}
