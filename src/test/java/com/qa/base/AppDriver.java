package com.qa.base;

import org.openqa.selenium.WebDriver;

public class AppDriver {
    public static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    protected static ThreadLocal<String> platform = new ThreadLocal<>();

    protected static ThreadLocal<String> deviceName = new ThreadLocal<>();


    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void setDriver(WebDriver Driver) {
        driver.set(Driver);
        System.out.println("Driver is set");
    }

    public static String getPlatformName() {
        return platform.get();
    }

    public static String getDeviceName() {
        return deviceName.get();
    }

    public static void setPlatformName(String platformName){
        platform.set(platformName);
    }

    public static void setDeviceName(String device){
        deviceName.set(device);
    }

}