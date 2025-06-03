package com.petsgolden.automation.ui;

import org.openqa.selenium.By;

import static com.petsgolden.automation.ui.BaseTest.driver;

import io.cucumber.java.en.And;

public class InvalidCheckout extends BaseTest {

    @And("I add a product to the cart")
    public void i_add_a_product_to_the_cart() {
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.className("shopping_cart_link")).click();
    }

    @And("I proceed to checkout")
    public void i_proceed_to_checkout() {
        waitForElementClickable(By.id("checkout"));
        driver.findElement(By.id("checkout")).click();
    }

    @And("I leave the first name field empty")
    public void i_leave_the_first_name_field_empty() {
        driver.findElement(By.id("first-name")).clear();
    }

    @And("I fill in the last name with {string} and postal code with {string}")
    public void i_fill_in_last_name_and_postal_code(String lastName, String postalCode) {
        driver.findElement(By.id("last-name")).sendKeys(lastName);
        driver.findElement(By.id("postal-code")).sendKeys(postalCode);
    }

    @And("I click continue on the checkout page")
    public void i_click_continue_on_the_checkout_page() {
        driver.findElement(By.id("continue")).click();
    }

}
