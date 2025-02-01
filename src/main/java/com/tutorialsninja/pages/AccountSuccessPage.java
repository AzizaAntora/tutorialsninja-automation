package com.tutorialsninja.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSuccessPage {
	
	private WebDriver driver;
    
    @FindBy(xpath = "//div[@id='content']/h1")
    private WebElement successMessage;
    
    public AccountSuccessPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public boolean isSuccessMessageDisplayed() {
        return successMessage.isDisplayed() && 
               successMessage.getText().equals("Your Account Has Been Created!");
    }


}
