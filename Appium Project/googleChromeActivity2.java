package appium_Project;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class googleChromeActivity2 {
	WebDriverWait wait;
	AppiumDriver<MobileElement> driver = null;
	
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
	 
  
  @Test(dataProvider = "authorization")
  public void LoginForm(String username, String password) {
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
      driver.get("https://www.training-support.net/selenium");
      
      //wait for the landing page
      wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.Button[@text='Get Started!']")));
      
      // Scroll element into view and click it
      driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).flingForward().scrollIntoView(textContains(\"Login Form\"))")).click();
      
      //Wait for the taskinput page to appear
      wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("//android.webkit.WebView/android.view.View/android.view.View[2]")));
           
      //Get the username and password fields
      driver.findElement(MobileBy.AndroidUIAutomator( "resourceId(\"username\")")).sendKeys(username);
      driver.findElement(MobileBy.AndroidUIAutomator( "resourceId(\"password\")")).sendKeys(password); 
      driver.findElement(MobileBy.AndroidUIAutomator( "textContains(\"Log in\")")).click();
      
      String loginMessage = driver.findElement(MobileBy.AndroidUIAutomator( "resourceId(\"action-confirmation\")")).getText();
      
      if (username=="admin" && password=="password") {
    	  Assert.assertEquals(loginMessage, "Welcome Back, admin");
	} else {
		Assert.assertEquals(loginMessage, "Invalid Credentials");
	}
     
      
  }
  
@DataProvider(name="authorization")
  
  public static Object[][] credentials() {
  	
      return new Object[][] { { "admin", "password" },{"user1","pwd"}};
}


  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
