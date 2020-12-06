package appium_session1;

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

public class activity2_1 {
	WebDriverWait wait;
	AppiumDriver<MobileElement> driver = null;
  @Test
  public void testSearchAppium() {
		
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
      driver.get("https://www.training-support.net/");
     
      String pageTitle = driver.findElementByXPath("//android.view.View[@text='Training Support']").getText();	
      System.out.println("Title on Homepage: " + pageTitle);
      Assert.assertEquals(pageTitle, "Training Support");
      
      wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("//android.view.View[@text='About Us']")));
      MobileElement aboutButton = driver.findElementByXPath("//android.view.View[@text='About Us']");
      if (aboutButton.isEnabled()){
    	  aboutButton.click();
      }
      else {
    	  System.out.println("The About Button is not clickable");
      }
      	
      wait.until(ExpectedConditions.textToBePresentInElementLocated(MobileBy.xpath("//android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]"), "About Us"));
      String newPageTitle = driver
	
              .findElementByXPath("//android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]")
	
              .getText();
		
      System.out.println("Title on new page: " + newPageTitle);	
      // Assertions		
      Assert.assertEquals(newPageTitle, "About Us");
	
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
		
      driver.quit();
	
  }

}
