package com.tutorialsninja.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	 	private WebDriver driver;
	    
	    @FindBy(xpath = "//a[@title='My Account']")
	    private WebElement myAccountDropdown;
	    
	    @FindBy(linkText = "Register")
	    private WebElement registerLink;

		@FindBy(xpath = "//a[text()='Desktops']")
		private WebElement desktopsCategoryLink;
		@FindBy(xpath = "//div[@class='dropdown-inner']//a[contains(text(),'Mac')]")
		private WebElement macCategoryLink;
	    
	    public HomePage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }
	    
	    public void navigateToRegistrationPage() {
	        myAccountDropdown.click();
	        registerLink.click();
	    }
	    
	    public void openHomePage(String url) {
	        driver.get(url);
	    }

		public void clickMacCategory() {
			desktopsCategoryLink.click();
			macCategoryLink.click();
		}
}
