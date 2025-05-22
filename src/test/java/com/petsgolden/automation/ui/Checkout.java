package com.petsgolden.automation.ui;

import static org.junit.Assert.assertEquals;
import org.openqa.selenium.By;

import static com.petsgolden.automation.ui.BaseTest.driver;
import static com.petsgolden.automation.ui.BaseTest.initializeDriver;
import static com.petsgolden.automation.ui.BaseTest.waitForElementVisible;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Checkout {

    @Given("I am logged in and have an item in the cart")
    public void i_am_logged_in_and_have_an_item_in_the_cart() {
        if (driver == null) {
            initializeDriver();
        }
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        waitForElementVisible(By.className("inventory_item"));
        driver.findElement(By.cssSelector(".inventory_item button")).click(); // add first item
        driver.findElement(By.className("shopping_cart_link")).click();
    }

    @When("I proceed to checkout and fill in my information")
    public void i_proceed_to_checkout_and_fill_in_my_information() {
        waitForElementVisible(By.id("checkout"));
        driver.findElement(By.id("checkout")).click();

        waitForElementVisible(By.id("first-name"));
        driver.findElement(By.id("first-name")).sendKeys("Jon");
        driver.findElement(By.id("last-name")).sendKeys("Test");
        driver.findElement(By.id("postal-code")).sendKeys("12345");
        driver.findElement(By.id("continue")).click();
    }

    @When("I finish the checkout")
    public void i_finish_the_checkout() {
        waitForElementVisible(By.id("finish"));
        driver.findElement(By.id("finish")).click();
    }

    @Then("I should see the confirmation page")
    public void i_should_see_the_confirmation_page() {
        waitForElementVisible(By.className("complete-header"));
        String confirmationText = driver.findElement(By.className("complete-header")).getText();
        assertEquals("Thank you for your order!", confirmationText);
    }
}
