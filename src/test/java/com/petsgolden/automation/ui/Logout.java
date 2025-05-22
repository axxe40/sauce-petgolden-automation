package com.petsgolden.automation.ui;

import static org.junit.Assert.assertTrue;
import org.openqa.selenium.By;

import static com.petsgolden.automation.ui.BaseTest.driver;
import static com.petsgolden.automation.ui.BaseTest.initializeDriver;
import static com.petsgolden.automation.ui.BaseTest.waitForElementClickable;
import static com.petsgolden.automation.ui.BaseTest.waitForElementVisible;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Logout extends BaseTest {

    @Given("I am logged in to the application")
    public void i_am_logged_in_to_the_application() {
        if (driver == null) {
            initializeDriver();
        }
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        waitForElementVisible(By.id("inventory_container"));
    }

    @When("I click the logout button")
    public void i_click_the_logout_button() {
        driver.findElement(By.id("react-burger-menu-btn")).click();
        waitForElementClickable(By.id("logout_sidebar_link"));
        driver.findElement(By.id("logout_sidebar_link")).click();
    }

    @Then("I should be redirected to the login page")
    public void i_should_be_redirected_to_the_login_page() {
        waitForElementVisible(By.id("login-button"));
        String currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.contains("saucedemo.com"));
    }
}
