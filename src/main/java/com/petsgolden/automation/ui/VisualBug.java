package com.petsgolden.automation.ui;

import static org.junit.Assert.assertTrue;
import org.openqa.selenium.By;

import static com.petsgolden.automation.ui.BaseTest.driver;

import io.cucumber.java.en.And;

public class VisualBug extends BaseTest {

    @And("I should see the 'cart' icon should be asymmetrical")
    public void i_should_see_the_cart_icon_is_not_distorted() {
        boolean isCartIconDisplayed = driver.findElement(By.className("shopping_cart_link")).isDisplayed();
        int height = driver.findElement(By.className("shopping_cart_link")).getSize().getHeight();
        int width = driver.findElement(By.className("shopping_cart_link")).getSize().getWidth();

        assertTrue("Cart icon should be visible", isCartIconDisplayed);
        assertTrue("Cart icon should have reasonable height", height > 10);
        assertTrue("Cart icon should have reasonable width", width > 10);
    }

    @And("I should see the 'menu' icon should be asymmetrical")
    public void i_should_see_the_menu_icon_is_not_distorted() {
        boolean isMenuDisplayed = driver.findElement(By.id("react-burger-menu-btn")).isDisplayed();
        assertTrue("Menu button should be visible", isMenuDisplayed);
    }
}
