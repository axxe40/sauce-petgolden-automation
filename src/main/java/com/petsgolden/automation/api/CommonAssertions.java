package com.petsgolden.automation.api;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;

import static org.junit.Assert.*;

public class CommonAssertions {

    @Then("The response status code for {word} user should be {int}")
    public void verifyStatusCode(String action, int expectedStatusCode) {
        Response response = ResponseContext.getResponse();  // Ambil di dalam method
        assertEquals("Status code mismatch for " + action + " user",
                expectedStatusCode, response.getStatusCode());
    }

    @Then("The response status code for {word} user should not be {int}")
    public void verifyNegativeStatusCode(String action, int notExpectedStatusCode) {
        Response response = ResponseContext.getResponse();
        assertNotEquals("Status code should not be " + notExpectedStatusCode + " for " + action + " user",
                notExpectedStatusCode, response.getStatusCode());
    }

    @And("The response body should contain success message")
    public void verifySuccessMessage() {
        Response response = ResponseContext.getResponse();
        String message = response.jsonPath().getString("message");
        assertNotNull("Expected success message, but was null", message);
        assertFalse("Expected non-empty success message", message.trim().isEmpty());
        System.out.println("Success message: " + message);
    }

@And("The response body should contain error message")
public void verifyErrorMessage() {
    Response response = ResponseContext.getResponse();
    String responseBody = response.getBody().asString();

    // System.out.println("Response body: " + responseBody);
    String contentType = response.getHeader("Content-Type");
    // System.out.println("Content-Type: " + contentType);

    if (responseBody == null || responseBody.trim().isEmpty()) {
        fail("Expected error message but response body is empty");
    }

    if (contentType != null && contentType.contains("application/json")) {
        try {
            String message = response.jsonPath().getString("message");
            assertNotNull("Expected error message, but was null", message);
            assertFalse("Expected non-empty error message", message.trim().isEmpty());
            System.out.println("Error message: " + message);
        } catch (Exception e) {
            fail("Failed to parse 'message' from JSON. Raw body: " + responseBody);
        }
    } else if (contentType != null && contentType.contains("application/xml")) {
        // Sederhana: cek string mengandung kata 'unknown' atau format error lainnya
        assertTrue("Expected error info in XML response", responseBody.contains("<type>unknown</type>"));
    } else {
        fail("Unsupported content type or unknown response format.\nRaw body: " + responseBody);
    }
}




    @And("The response body should be empty")
public void verifyEmptyBody() {
    Response response = ResponseContext.getResponse();
    String body = response.getBody().asString();
    assertTrue("Expected empty response body", body == null || body.trim().isEmpty());
}

}
