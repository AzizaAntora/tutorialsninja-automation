package com.tutorialsninja.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailPage {

    private WebDriver driver;

    // Locators for product quantity and Add To Cart button.
    private By quantityField = By.id("input-quantity");
    private By addToCartButton = By.id("button-cart");
    private By shoppingCartButton = By.xpath("//a[.//span[normalize-space()='Shopping Cart']]");


    public ProductDetailPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setQuantity(String quantity) {
        driver.findElement(quantityField).clear();
        driver.findElement(quantityField).sendKeys(quantity);
    }

    public void clickAddToCart() {
        driver.findElement(addToCartButton).click();
    }

    public void navigateToCart() {
        driver.findElement(shoppingCartButton).click();
    }
}
