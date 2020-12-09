package appium_session1;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class activity3_1 {
    AppiumDriver<MobileElement> driver = null;	
    WebDriverWait wait;
  @Test
  public void smsTest() {
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
      // Locate the button to write a new message and click it	
      driver.findElement(MobileBy.AndroidUIAutomator("description(\"Start new conversation\")")).click();
      // Enter the number to send message to
	
     String contactBoxLocator = "resourceId(\"com.google.android.apps.messaging:id/recipient_text_view\")";
	
      // Enter your own phone number
	
     driver.findElement(MobileBy.AndroidUIAutomator(contactBoxLocator)).sendKeys("9049161929");
     
     // Focus on the message text box	
     String messageBoxLocator = "resourceId(\"com.google.android.apps.messaging:id/contact_picker_create_group\")";
     driver.findElement(MobileBy.AndroidUIAutomator(messageBoxLocator)).click();
     
     driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.apps.messaging:id/action_confirm_participants\")")).click();
     
     // Type in a message
 	
     messageBoxLocator = "resourceId(\"com.google.android.apps.messaging:id/compose_message_text\")";
	
     MobileElement composeMessageInput = driver.findElement(MobileBy.AndroidUIAutomator(messageBoxLocator));
	
     composeMessageInput.sendKeys("Hello from Appium");
	
     // Send the message
     messageBoxLocator = "resourceId(\"com.google.android.apps.messaging:id/send_message_button_icon\")";
     driver.findElement(MobileBy.AndroidUIAutomator(messageBoxLocator)).click();
     
     // Wait for message to show	
     wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("message_text")));
     
     // Assertion
 	
     String messageLocator = "resourceId(\"com.google.android.apps.messaging:id/message_text\")";	
     String sentMessageText = driver.findElement(MobileBy.AndroidUIAutomator(messageLocator)).getText();	
     Assert.assertEquals(sentMessageText, "Hello from Appium");
	  
  }
  @BeforeClass
  public void beforeClass() throws MalformedURLException {		
      // Set the Desired Capabilities	
      DesiredCapabilities caps = new DesiredCapabilities();	
      caps.setCapability("deviceName", "<device name>");	
      caps.setCapability("platformName", "Android");	
      caps.setCapability("noReset", true);	
      // Use your own device's messaging app	
      caps.setCapability("appPackage", "com.google.android.apps.messaging");	
      caps.setCapability("appActivity", ".ui.ConversationListActivity");
      
      // Instantiate Appium Driver	
      URL appServer = new URL("http://0.0.0.0:4723/wd/hub");	
      driver = new AndroidDriver<MobileElement>(appServer, caps);	
      wait = new WebDriverWait(driver, 5);
	
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
