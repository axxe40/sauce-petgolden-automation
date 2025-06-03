package com.petsgolden.automation.ui;

import static org.junit.Assert.assertEquals;
import org.openqa.selenium.By;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class Cart extends BaseTest {

    /* ---------- ACTIONS ---------- */
    @And("I add the first product to the cart")
    public void addFirstProductToCart() {
        // tombol “Add to cart” pertama di daftar produk
        waitForElementClickable(By.xpath("(//button[contains(text(),'Add to cart')])[1]"));
        driver.findElement(By.xpath("(//button[contains(text(),'Add to cart')])[1]")).click();
    }

    @And("I remove the product from the cart")
    public void removeProductFromCart() {
        // tombol "Remove" akan muncul setelah Add ditekan
        waitForElementClickable(By.xpath("(//button[contains(text(),'Remove')])[1]"));
        driver.findElement(By.xpath("(//button[contains(text(),'Remove')])[1]")).click();
    }


    /* ---------- ASSERTIONS ---------- */
    @Then("I should see the cart icon showing {int} item")
    public void verifyCartItemCount(int expectedCount) {
        if (expectedCount == 0) {
            // kalau 0 item, badge tidak ada
            boolean badgePresent = !driver.findElements(By.className("shopping_cart_badge")).isEmpty();
            assertEquals("Cart badge should be absent", false, badgePresent);
        } else {
            waitForElementVisible(By.className("shopping_cart_badge"));
            String badgeText = driver.findElement(By.className("shopping_cart_badge")).getText();
            assertEquals(String.valueOf(expectedCount), badgeText);
        }
    }
}
