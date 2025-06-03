package com.petsgolden.automation.api;

import io.cucumber.java.en.*;
import static io.restassured.RestAssured.given;
import io.restassured.response.Response;

import static org.junit.Assert.*;

public class UpdateUser {

    @When("I send PUT request to {string} with updated email {string} and password {string}")
    public void sendPutRequest(String endpoint, String email, String password) {
        String requestBody = String.format("""
            {
                "email": "%s",
                "password": "%s"
            }
            """, email, password);

        Response response = given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .put(endpoint);

        ResponseContext.setResponse(response);
    }

  
}
