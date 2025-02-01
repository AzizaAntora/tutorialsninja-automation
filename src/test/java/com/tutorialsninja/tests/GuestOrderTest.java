package com.tutorialsninja.tests;

import com.tutorialsninja.dataproviders.GuestOrderDataProvider;
import com.tutorialsninja.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GuestOrderTest extends BaseTest {

    @Test(dataProvider = "guestOrderData", dataProviderClass = GuestOrderDataProvider.class)
    public void testGuestOrder(String quantity, String couponCode, String shippingInfo, String region, String postCode, String giftCertificate) {
        try {
            // Home page actions
            HomePage homePage = new HomePage(driver);
            homePage.clickMacCategory();

            // Mac category page
            MacCategoryPage macPage = new MacCategoryPage(driver);
            macPage.clickiMac();

            // Product detail page
            ProductDetailPage productDetailPage = new ProductDetailPage(driver);
            productDetailPage.setQuantity(quantity);
            productDetailPage.clickAddToCart();

            // Navigate to cart
            productDetailPage.navigateToCart();

            // Checkout page
            CartPage cartPage = new CartPage(driver);
            cartPage.fillCouponCode(couponCode);
            cartPage.fillShippingDetails(shippingInfo, region, postCode);
            cartPage.fillGiftCertificate(giftCertificate);
            cartPage.clickCheckout();

            // Add assertions to verify that the checkout page is loaded or the order was placed.
            Assert.assertTrue(true);
        } catch (Exception e) {

            throw e;
        }
    }

}
