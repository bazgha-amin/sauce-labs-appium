package com.qa.pages;

import com.qa.base.AppDriver;
import com.qa.base.AppFactory;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends AppFactory {

    public ProductPage() {
        PageFactory.initElements(new AppiumFieldDecorator(AppDriver.getDriver()), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"PRODUCTS\"]")
    public WebElement productHeader;

    public String getTitle(){
        return getAttribute(productHeader, "text");
    }

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Menu\"]/android.view.ViewGroup/android.widget.ImageView")
    public WebElement sideNavigationBar;

    public void clickSideNavigationBar(){
        clickElement(sideNavigationBar, "Clicking SideNavigation Button");
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"LOGOUT\"]")
    public WebElement logoutBtn;

    public void clickLogout(){
        clickElement(logoutBtn, "Clicking Logout Button");
    }

    @AndroidFindBy(xpath="//android.widget.TextView[@content-desc=\"test-Item title\" and @text=\"Sauce Labs Backpack\"]")
    public WebElement productImage;

    public void clickProductImage(){
        clickElement(productImage, "Clicking product Image");
    }

    @AndroidFindBy(accessibility = "test-BACK TO PRODUCTS")
    public  WebElement backToProductsBtn;

    public boolean isBackToProductsBtnDisplayed(){
        return backToProductsBtn.isDisplayed();
    }
}