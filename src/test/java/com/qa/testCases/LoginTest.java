package com.qa.testCases;

import com.aventstack.extentreports.Status;
import com.qa.base.AppFactory;
import com.qa.pages.LoginPage;
import com.qa.pages.ProductPage;
import com.qa.reports.ExtentReport;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Objects;

public class LoginTest extends AppFactory {

    LoginPage loginPage;
    ProductPage productPage;

    InputStream inputStream;

    JSONObject loginUser;


    @BeforeMethod
    public void setup(Method method) {
        loginPage = new LoginPage();
        utilities.log().info("\n\n********** " + method.getName() + " **********\n\n");
    }

    @BeforeClass
    public void setupDataStream() throws IOException {
        try {
            String dataFileName = "data/loginUser.json";
            inputStream = getClass().getClassLoader().getResourceAsStream(dataFileName);
            JSONTokener jsonTokener = new JSONTokener(Objects.requireNonNull(inputStream));
            loginUser = new JSONObject(jsonTokener);

        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    @Test(priority=1)
    public void verifyInvalidUsername() {
        utilities.log().info("This test is used to login with invalid Username and valid Password");
        loginPage.enterUserName(loginUser.getJSONObject("invalidUser").getString("userName"));
        loginPage.enterPassword(loginUser.getJSONObject("invalidUser").getString("password"));
        loginPage.clickLoginBtn();

        String expectedErrorMessage = stringHashMap.get("error_invalid_username_and_password");
        String actualErrorMessage = loginPage.getErrorMessage();
        utilities.log().info("Actual Error Message is " + actualErrorMessage + "\nExpected Error Message is " + expectedErrorMessage);
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
    }

    @Test(priority = 2)
    public void verifyInvalidPassword() {
        utilities.log().info("This test is used to login with valid Username and invalid Password");
        loginPage.enterUserName(loginUser.getJSONObject("invalidPassword").getString("userName"));
        loginPage.enterPassword(loginUser.getJSONObject("invalidPassword").getString("password"));
        loginPage.clickLoginBtn();

        String expectedErrorMessage = stringHashMap.get("error_invalid_username_and_password");
        String actualErrorMessage = loginPage.getErrorMessage();

        utilities.log().info("Actual Error Message is " + actualErrorMessage + "\nExpected Error Message is " + expectedErrorMessage);
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);

    }

    @Test(priority = 3)
    public void verifyValidLogin() {
        utilities.log().info("This test is used to login with valid Username and valid Password");
        loginPage.enterUserName(loginUser.getJSONObject("validUserAndPassword").getString("userName"));
        loginPage.enterPassword(loginUser.getJSONObject("validUserAndPassword").getString("password"));
        productPage = loginPage.clickLoginBtn();

        String expectedTitle = stringHashMap.get("product_title");
        String actualTitle = productPage.getTitle();

        utilities.log().info("Actual Product Title is " + actualTitle + "\nExpected Product Title is " + expectedTitle);
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test(priority = 4)
    public void verifyLogout(){
        utilities.log().info("This test is used to logout from the app");
        productPage.clickSideNavigationBar();
        productPage.clickLogout();
        Assert.assertTrue(loginPage.IsFieldDisplayed(), "Logout Failed, login page username field not displayed");
    }

    @AfterTest
    public void tearDown() {
        AppFactory.quitDriver();
    }

}