package com.petsgolden.automation.ui;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login extends BaseTest {

    @Before
    public void setup() {
        initializeDriver();
    }

    @After
    public void teardown() {
        quitDriver();
    }

    @Given("I open the login page")
    public void i_open_the_login_page() {
        driver.get("https://www.saucedemo.com/");
    }

    @When("I enter valid username and password")
    public void i_enter_valid_username_and_password() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }

        @When("I enter username {string} and password {string}")
    public void i_enter_username_and_password(String username, String password) {
        driver.findElement(By.id("user-name")).clear();
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
    }

    @Then("I should see the inventory page")
    public void i_should_see_the_inventory_page() {
        try {
            waitForElementVisible(By.id("inventory_container"));
            String currentUrl = driver.getCurrentUrl();
            System.out.println("Current URL: " + currentUrl); // debug

            assertTrue(currentUrl.contains("inventory.html"));
        } catch (TimeoutException e) {
            System.out.println("Page source for debug:\n" + driver.getPageSource()); // debug
            fail("Login gagal atau halaman inventory tidak muncul.");
        }
    }

}
