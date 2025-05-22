package com.petsgolden.automation.ui;

import static org.junit.Assert.assertTrue;
import org.openqa.selenium.By;

import static com.petsgolden.automation.ui.BaseTest.driver;

import io.cucumber.java.en.Then;

public class ErrorMessage extends BaseTest {

     @Then("I should see an error message {string}")
    public void i_should_see_an_error_message(String expectedMessage) {
        String actualMessage = driver.findElement(By.cssSelector("h3[data-test='error']")).getText();
        assertTrue("Error message should be displayed", actualMessage.contains(expectedMessage));
    }
}
