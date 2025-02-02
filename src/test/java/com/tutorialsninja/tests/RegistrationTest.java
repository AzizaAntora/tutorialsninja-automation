package com.tutorialsninja.tests;

import com.tutorialsninja.dataproviders.RegistrationDataProvider;
import com.tutorialsninja.pages.AccountSuccessPage;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest {
	
	 @Test(dataProvider = "registrationData", dataProviderClass = RegistrationDataProvider.class)
	    public void testUserRegistration(String firstName, String lastName, String email, 
	                                    String telephone, String password, String confirmPassword,
	                                    String newsletter) {
	        
	        // ExtentTest test = ExtentReporter.createTest("User Registration Test - " + firstName, "");
	        
	        try {
	            HomePage homePage = new HomePage(driver);
	            homePage.navigateToRegistrationPage();
	            
	            RegistrationPage registrationPage = new RegistrationPage(driver);
	            String timestamp = String.valueOf(System.currentTimeMillis());
	            
	            registrationPage.fillRegistrationForm(
	                firstName,
	                lastName,
						timestamp + "_" + email,
	                telephone,
	                password,
	                confirmPassword,
	                newsletter
	            );
	            
	            AccountSuccessPage successPage = new AccountSuccessPage(driver);
	            Assert.assertTrue(successPage.isSuccessMessageDisplayed());
	        } catch (Exception e) {
	            throw e;
	        }
	    }

}
