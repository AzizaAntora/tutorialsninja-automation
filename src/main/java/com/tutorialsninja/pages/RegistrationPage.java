package com.tutorialsninja.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
private WebDriver driver;
    
    @FindBy(id = "input-firstname") private WebElement firstNameField;
    @FindBy(id = "input-lastname") private WebElement lastNameField;
    @FindBy(id = "input-email") private WebElement emailField;
    @FindBy(id = "input-telephone") private WebElement telephoneField;
    @FindBy(id = "input-password") private WebElement passwordField;
    @FindBy(id = "input-confirm") private WebElement confirmPasswordField;
    @FindBy(xpath = "//input[@name='newsletter'][@value='1']") private WebElement newsletterYes;
    @FindBy(xpath = "//input[@name='newsletter'][@value='0']") private WebElement newsletterNo;
    @FindBy(name = "agree") private WebElement privacyPolicy;
    @FindBy(xpath = "//input[@value='Continue']") private WebElement continueButton;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillRegistrationForm(String firstName, String lastName, String email, 
                                    String telephone, String password, String confirmPassword, 
                                    String newsletter) {
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        emailField.sendKeys(email);
        telephoneField.sendKeys(telephone);
        passwordField.sendKeys(password);
        confirmPasswordField.sendKeys(confirmPassword);
        
        if(newsletter.equalsIgnoreCase("Yes")) {
            newsletterYes.click();
        } else {
            newsletterNo.click();
        }
        
        privacyPolicy.click();
        continueButton.click();
    }

	public void fillRegistrationForm2(String firstName, String lastName, String uniqueEmail, String replace,
			String replace2, String replace3, String newsletter) {
		// TODO Auto-generated method stub
		
	}

}
