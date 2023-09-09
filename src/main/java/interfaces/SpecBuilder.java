package interfaces;

import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.io.IOException;

public interface SpecBuilder {

    RequestSpecification getRequestSpecs() throws IOException;

    ResponseSpecification getResponseSpecs();
}
