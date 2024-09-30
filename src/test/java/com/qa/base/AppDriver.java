package com.qa.base;

import org.openqa.selenium.WebDriver;

public class AppDriver {
    public static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver(){
        return driver.get();
    }

    public static void setDriver(WebDriver Driver){
        driver.set(Driver);
        System.out.println("Driver is set");
    }
}
