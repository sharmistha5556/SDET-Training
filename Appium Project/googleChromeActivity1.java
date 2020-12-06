package appium_Project;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class googleChromeActivity1 {
	WebDriverWait wait;
	AppiumDriver<MobileElement> driver = null;
  @Test
  public void addtasks() {
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
      driver.get("https://www.training-support.net/selenium");
      
      //wait for the landing page
      wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("//android.widget.Button[@text='Get Started!']")));
      
      // Scroll element into view and click it
      //driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector()).scrollable(true).getChildByText(UiSelector().className(\"android.view.View\"), \"To-Do List\")")).click();
      driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector()).scrollable(true).scrollTextIntoView( \"To-Do List\")")).click();
  }
  @BeforeClass	  
  public void setup() throws MalformedURLException {
		
        // Set the Desired Capabilities
	
	  DesiredCapabilities caps = new DesiredCapabilities();
      caps.setCapability("deviceName", "LatestPhoneAVD");	
      caps.setCapability("platformName", "android");
	  caps.setCapability("appPackage", "com.android.chrome");
	  caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
	  caps.setCapability("noReset", true);
		
        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);
        wait = new WebDriverWait(driver, 10);   	        		
    }

  @AfterClass
  public void tearDown() {
		
      //driver.quit();
	
  }

}
