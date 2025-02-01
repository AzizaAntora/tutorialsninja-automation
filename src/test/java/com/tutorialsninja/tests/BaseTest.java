package com.tutorialsninja.tests;

import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.utils.BrowserUtils;
import com.tutorialsninja.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;


public class BaseTest {
	public WebDriver driver;
    
    @BeforeMethod
    public void setup() {
        driver = BrowserUtils.initializeDriver();
        driver.manage().window().maximize();
        new HomePage(driver).openHomePage(ConfigReader.getHomeUrl());
    }
    
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
    
    @AfterSuite
    public void afterSuite() {
    }

}
