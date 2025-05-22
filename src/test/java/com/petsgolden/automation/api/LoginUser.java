package com.petsgolden.automation.api;

import io.cucumber.java.en.*;
import static io.restassured.RestAssured.given;
import io.restassured.response.Response;
import static org.junit.Assert.*;

public class LoginUser {

    private Response response;

   @When("I send GET request to {string} with username {string} and password {string}")
public void sendGetRequestForLogin(String endpoint, String username, String password) {
    response = given()
                 .header("Content-Type", "application/json")
                 .queryParam("username", username)
                 .queryParam("password", password)
               .when()
                 .get(endpoint);

    ResponseContext.setResponse(response); // Jangan lupa simpan response-nya
}

}
