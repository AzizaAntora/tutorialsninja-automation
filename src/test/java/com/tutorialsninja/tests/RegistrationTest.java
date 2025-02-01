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
	            String uniqueEmail = email.replace("any", "test" + timestamp + "@example.com");
	            
	            registrationPage.fillRegistrationForm(
	                firstName,
	                lastName,
	                uniqueEmail,
	                telephone.replace("any", "1234567890"),
	                password.replace("any", "Password123"),
	                confirmPassword.replace("any", "Password123"),
	                newsletter
	            );
	            
	            AccountSuccessPage successPage = new AccountSuccessPage(driver);
	            Assert.assertTrue(successPage.isSuccessMessageDisplayed());
				// test.log(LogStatus.PASS, "Registration successful for user: " + firstName);
	        } catch (Exception e) {
	            // test.fail("Test failed: " + e.getMessage());
				// test.log(LogStatus.FAIL, "Test failed: " + e.getMessage());
	            throw e;
	        }
	    }

}
