import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class ConnectionString {
    AppiumDriver driver;
    @BeforeTest
    public void initializer() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium:platformName", "Android");
        capabilities.setCapability("appium:deviceName", "emulator-5554");
        capabilities.setCapability("appium:automationName", "uiautomator2");
        capabilities.setCapability("appium:app",System.getProperty("user.dir")+ "/app/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");
        capabilities.setCapability("appium:appPackage", "com.swaglabsmobileapp");
        capabilities.setCapability("appium:appActivity", "com.swaglabsmobileapp.SplashActivity");
        capabilities.setCapability("appium:noReset", false);
        capabilities.setCapability("appium:newCommandTimeout", 5000);
//        capabilities.setCapability("appium:avd","Pixel_3a");
//        capabilities.setCapability("appium:avdLaunchTimeout","5000000");

        driver = new AndroidDriver(new URL("http://localhost:4723"), capabilities);
        System.out.println("Starting Appium Server");
    }

    @Test
    public void sampleTest(){
        System.out.println("This is my first sample test");
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
//        String cmdString = "adb -s emulator-5554 emu kill";
//        if(driver!= null){
//            try{
//                Runtime.getRuntime().exec("CMD /C " + cmdString);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }

    }
}