package com.qa.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private final Properties properties;

    public ConfigReader(){
        BufferedReader reader;
        String propertyFilePath= "configuration/config.properties";
        try{
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try{
                properties.load(reader);
                reader.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
            throw new RuntimeException("Configuration file not found at "+ propertyFilePath);
        }
    }

    public String getAppPackage(){
        String appPackage = properties.getProperty("androidAppPackage");
        if(appPackage != null ) return appPackage;
        else throw new RuntimeException("appPackage not specified in property file");
    }

    public String getAppActivity(){
        String appActivity = properties.getProperty("androidAppActivity");
        if(appActivity != null ) return appActivity;
        else throw new RuntimeException("appActivity not specified in property file");
    }

    public String getAutomationName(){
        String automationName = properties.getProperty("androidAutomationName");
        if(automationName != null ) return automationName;
        else throw new RuntimeException("automationName not specified in property file");
    }

    public String getCommandTimeoutValue(){
        String commandTimeoutValue = properties.getProperty("androidCommandTimeoutValue");
        if(commandTimeoutValue != null ) return commandTimeoutValue;
        else throw new RuntimeException("commandTimeoutValue not specified in property file");
    }

    public String getApkPath(){
        String apkPath = properties.getProperty("androidApkPath");
        if(apkPath != null ) return apkPath;
        else throw new RuntimeException("apkPath not specified in property file");
    }

    public String getNoReset(){
        String noReset = properties.getProperty("androidNoReset");
        if(noReset != null ) return noReset;
        else throw new RuntimeException("noReset not specified in property file");
    }

    public String getAppiumServerEndpointURL(){
        String appiumServerEndpointURL = properties.getProperty("androidAppiumServerEndpointURL");
        if(appiumServerEndpointURL != null ) return appiumServerEndpointURL;
        else throw new RuntimeException("appiumServerEndpointURL not specified in property file");
    }
}