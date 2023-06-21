package com.api.tests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class AirlineTests {

    @Test
    public void getABooking() {
        given()
                .baseUri("https://restful-booker.herokuapp.com/booking")
                .basePath("/4")
                .log()
                .all()
        .when()
                .get()
        .then()
                .log()
                .all()
                .statusCode(200);
    }

    @Test
    public void createBooking() {
        given()
                .baseUri("https://restful-booker.herokuapp.com")
                .header("Content-Type","application/json")
                .header("Accept","application/json")
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
                .all()
                .statusCode(200);
    }
}
