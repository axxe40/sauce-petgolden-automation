package com.petsgolden.automation.api;

import io.cucumber.java.en.*;
import static io.restassured.RestAssured.given;
import io.restassured.response.Response;

import static org.junit.Assert.*;

public class GetUser {

    private Response response;

    @When("I send GET request to {string}")
public void sendGetRequestTo(String endpoint) {
    response = given()
                .when()
                .get(endpoint);
                
                ResponseContext.setResponse(response);
}


    @When("I send GET request to {string} with username {string}")
    public void sendGetRequestWithUsername(String endpoint, String username) {
        response = given()
                .when()
                .get(endpoint + "/" + username);
    }

    @Then("The response status code should be {int}")
    public void verifyStatusCode(int expectedStatusCode) {
        assertEquals(expectedStatusCode, response.getStatusCode());
    }

    @And("The response body should contain username {string}")
    public void verifyUsername(String expectedUsername) {
        String actualUsername = response.jsonPath().getString("username");
        assertEquals(expectedUsername, actualUsername);
    }
}
