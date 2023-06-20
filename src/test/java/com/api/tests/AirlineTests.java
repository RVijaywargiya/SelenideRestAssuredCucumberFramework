package com.api.tests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class AirlineTests {

    @Test
    public void getAPost() {
        given()
                .baseUri("https://jsonplaceholder.typicode.com")
                .basePath("/posts/1")
                .log()
                .all()
        .when()
                .get()
        .then()
                .log()
                .all();
    }

    @Test
    public void createPost() {
        given()
                .baseUri("https://jsonplaceholder.typicode.com")
                .header("Content-type","application/json; charset=UTF-8")
                .body("{\n" +
                        "    title: 'foo',\n" +
                        "    body: 'bar',\n" +
                        "    userId: 1,\n" +
                        "  }")
                .log()
                .all()
        .when()
                .post("/posts")
        .then()
                .log()
                .all();
    }
}
