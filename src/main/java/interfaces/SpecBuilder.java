package interfaces;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.io.IOException;

public interface SpecBuilder {

    RequestSpecBuilder getRequestSpecs() throws IOException;

    ResponseSpecBuilder getResponseSpecs();
}
