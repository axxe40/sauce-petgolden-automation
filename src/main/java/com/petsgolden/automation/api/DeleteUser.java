package com.petsgolden.automation.api;

import io.cucumber.java.en.*;
import static io.restassured.RestAssured.given;
import io.restassured.response.Response;

import static org.junit.Assert.*;

public class DeleteUser {

    @When("I send DELETE request to {string}")
    public void sendDeleteRequest(String endpoint) {
        Response response = given()
                .when()
                .delete(endpoint);

        ResponseContext.setResponse(response);
    }

 
}
