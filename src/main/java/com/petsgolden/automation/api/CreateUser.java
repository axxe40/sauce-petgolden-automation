package com.petsgolden.automation.api;

import io.cucumber.java.en.*;
import static io.restassured.RestAssured.given;
import io.restassured.response.Response;

import static org.junit.Assert.*;

public class CreateUser {

    private Response response;
    private String createdUsername;

    @When("I send POST request to {string} with username {string}, email {string}, and password {string}")
    public void sendPostRequest(String endpoint, String username, String email, String password) {
        String requestBody = String.format("""
            {
                "username": "%s",
                "email": "%s",
                "password": "%s"
            }
            """, username, email, password);

        response = given()
            .header("Content-Type", "application/json")
            .body(requestBody)
          .when()
            .post(endpoint);

         ResponseContext.setResponse(response);

        createdUsername = username;
    }

  

@And("The response body for create user should contain user ID")
public void verifyUserIdIsNumeric() {
    String actualMessage = response.jsonPath().getString("message");
    try {
        Long.parseLong(actualMessage);
    } catch (NumberFormatException e) {
        fail("Response message is not a valid user ID: " + actualMessage);
    }
}

}
