package com.petsgolden.automation.api;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;

public class BaseAPI {

    @Given("I set the base API URL")
    public void setBaseUrl() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
    }
}
