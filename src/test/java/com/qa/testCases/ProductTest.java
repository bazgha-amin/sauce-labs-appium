package com.qa.testCases;

import com.qa.base.AppFactory;
import com.qa.pages.LoginPage;
import com.qa.pages.ProductPage;
import dev.failsafe.internal.util.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductTest extends AppFactory  {

    private LoginPage loginPage;
    private ProductPage productPage;

    @BeforeMethod
    public void setup(){
        loginPage = new LoginPage();
        productPage = new ProductPage();
    }

    @Test
    public void verifyProductDetail(){
        utilities.log().info("This test is used to verify product detail page after clicking product image");
        loginPage.login("standard_user","secret_sauce");
        productPage.clickProductImage();
        Assert.isTrue(productPage.isBackToProductsBtnDisplayed(), "Product Detail page not opened");
    }
}
