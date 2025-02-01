package com.tutorialsninja.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MacCategoryPage {

    private WebDriver driver;

    // Locator for "iMac" option in the category list.
    private By iMacLink = By.linkText("iMac");

    public MacCategoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickiMac() {
        driver.findElement(iMacLink).click();
    }
}
