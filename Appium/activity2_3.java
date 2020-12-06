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
import java.util.Random;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class activity2_3 {
	 // Instantiate Appium Driver
		AppiumDriver<MobileElement> driver = null;
		WebDriverWait wait;
  @Test
  public void AddingContacts() {
      // Click on add new contact floating button
		
      driver.findElementByAccessibilityId("Create new contact").click();      
	
      // Find the first name, last name, and phone number fields
	
      MobileElement firstName = driver.findElementByXPath("//android.widget.EditText[@text='First name']");
	
      MobileElement lastName = driver.findElementByXPath("//android.widget.EditText[@text='Last name']");
      
      driver.findElementByXPath("//android.widget.ImageView[@content-desc=\"Show more name fields\"]").click();
      
      wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("//android.widget.EditText[@text='Phone']")));
	
      MobileElement phoneNumber = driver.findElementByXPath("//android.widget.EditText[@text='Phone']");
		
      Random rand = new Random();
 	  
      // Enter the text in the fields
      int int1 = rand.nextInt(1000);
	  int int2 = rand.nextInt(100000);
	
      firstName.sendKeys("Aaditya"+int1);
	
      lastName.sendKeys("Varma");
	
      phoneNumber.sendKeys("9012"+int2);
		
      // Save the contact
	
      driver.findElementById("editor_menu_save_button").click();	
      // Wait for contact card to appear
	
      wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("toolbar_parent")));	
      // Assertion
	
      MobileElement mobileCard = driver.findElementById("toolbar_parent");	
      Assert.assertTrue(mobileCard.isDisplayed());	
      String contactName = driver.findElementById("large_title").getText();
	
      Assert.assertEquals(contactName, "Aaditya"+int1+" Varma");
  }
  @BeforeClass
  public void setup() throws MalformedURLException{
	  DesiredCapabilities caps = new DesiredCapabilities();
	  caps.setCapability("deviceName", "<device name>");
	  caps.setCapability("platformName", "Android");
	  caps.setCapability("appPackage", "com.android.contacts");
	  caps.setCapability("appActivity", ".activities.PeopleActivity");
	  caps.setCapability("noReset", true);

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
