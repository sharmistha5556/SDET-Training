package appium_session1;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class activity3_1 {
    AppiumDriver<MobileElement> driver = null;	
    WebDriverWait wait;
  @Test
  public void f() {
  }
  @BeforeClass
  public void beforeClass() throws MalformedURLException {		
      // Set the Desired Capabilities	
      DesiredCapabilities caps = new DesiredCapabilities();	
      caps.setCapability("deviceName", "<device name>");	
      caps.setCapability("platformName", "Android");	
      caps.setCapability("noReset", true);	
      // Use your own device's messaging app	
      caps.setCapability("appPackage", "com.android.messaging");	
      caps.setCapability("appActivity", ".ui.conversationlist.ConversationListActivity");	
      // Instantiate Appium Driver	
      URL appServer = new URL("http://0.0.0.0:4723/wd/hub");	
      driver = new AndroidDriver<MobileElement>(appServer, caps);	
      wait = new WebDriverWait(driver, 5);
	
  }

  @AfterClass
  public void afterClass() {
  }

}
