package com.tutorialsninja.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {

    private WebDriver driver;

    // Locators for coupon, shipping, gift certificate, and checkout button.
    private By couponCodePanel = By.xpath("//a[contains(text(), 'Use Coupon Code')]");
    private By couponCodeField = By.id("input-coupon");
    private By shippingPanel = By.xpath("//a[contains(text(), 'Estimate Shipping & Taxes')]");
    private By shippingCountryField = By.id("input-country");
    private By shippingRegionField = By.id("input-zone");
    private By shippingPostCodeField = By.id("input-postcode");

    private By giftCertificatePanel = By.xpath("//a[contains(text(), 'Use Gift Certificate')]");
    private By giftCertificateField = By.id("input-voucher");
    private By checkoutButton = By.linkText("Checkout");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillCouponCode(String coupon) {
        driver.findElement(couponCodePanel).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(couponCodeField));

        driver.findElement(couponCodeField).sendKeys(coupon);
    }

    public void fillShippingDetails(String country, String region, String postCode) {
        driver.findElement(shippingPanel).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(shippingCountryField));

        // Select Country
        driver.findElement(shippingCountryField).click();
        WebElement countryDropdown = driver.findElement(By.xpath("//select[@id='input-country']/option[contains(text(), '"+country+"')]"));
        countryDropdown.click();

        // Select Region
        driver.findElement(shippingRegionField).click();
        WebElement regionDropdown = driver.findElement(By.xpath("//select[@id='input-zone']/option[contains(text(), '"+region+"')]"));
        regionDropdown.click();

        // set postcode
        driver.findElement(shippingPostCodeField).sendKeys(postCode);
    }

    public void fillGiftCertificate(String giftCertificate) {
        driver.findElement(giftCertificatePanel).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(giftCertificateField));

        driver.findElement(giftCertificateField).sendKeys(giftCertificate);
    }

    public void clickCheckout() {
        driver.findElement(checkoutButton).click();
    }
}
