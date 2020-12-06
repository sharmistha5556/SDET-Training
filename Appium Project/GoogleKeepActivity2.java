package appium_Project;

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

public class GoogleKeepActivity2 {
	 AppiumDriver<MobileElement> driver = null;	
	    WebDriverWait wait;
  @Test
  public void addTaskToGoogleKeep() {
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Click on add new task floating button	
		  MobileElement addbutton=driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"New text note\"]");
		  addbutton.click();  
		  
		//Wait for the New Task label to appear
	      wait.until(ExpectedConditions.textToBePresentInElementLocated(MobileBy.id("com.google.android.keep:id/editable_title"), "Title"));
	      
	      //Set the title and notes
	      driver.findElementById("editable_title").sendKeys("To Do");
	      driver.findElementById("com.google.android.keep:id/edit_note_text").click();
	      
	      driver.findElementById("com.google.android.keep:id/edit_note_text").sendKeys("What To Do?");
	      driver.findElementById("com.google.android.keep:id/edit_note_text").click();
	      
	      //Navigate Back
	      driver.findElementByAccessibilityId("Open navigation drawer").click();
	      
	      //wait till the note is added
	      wait.until(ExpectedConditions.textToBePresentInElementLocated(MobileBy.id("index_note_title"), "To Do"));
	      
	      String Title=driver.findElementById("index_note_title").getText();
	      String Note=driver.findElementById("index_note_text_description").getText();
	      
	      //Validate that the title and notes have been added
	      Assert.assertEquals(Title, "To Do");
	      Assert.assertEquals(Note, "What To Do?");
	     
  }
  
  @BeforeClass
  public void beforeClass() throws MalformedURLException {		
      // Set the Desired Capabilities	
      DesiredCapabilities caps = new DesiredCapabilities();	
      caps.setCapability("deviceName", "<device name>");	
      caps.setCapability("platformName", "Android");	
      caps.setCapability("noReset", true);	
      // Use your own device's messaging app	
      caps.setCapability("appPackage", "com.google.android.keep");	
      caps.setCapability("appActivity", ".activities.BrowseActivity");	
      // Instantiate Appium Driver	
      URL appServer = new URL("http://0.0.0.0:4723/wd/hub");	
      driver = new AndroidDriver<MobileElement>(appServer, caps);	
      wait = new WebDriverWait(driver, 10);
	
  }

  @AfterClass
  public void afterClass() {
	  //click on the note
      driver.findElementById("index_note_title").click();
      
      //wait for the note to open up
      wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("bs_action_button")));
      
      //click on the button
      driver.findElementById("bs_action_button").click();
      
      //wait for the Delete button 
      wait.until(ExpectedConditions.textToBePresentInElementLocated(MobileBy.id("com.google.android.keep:id/menu_text"),"Delete"));
      
      driver.findElementById("menu_text").click();
      
      //wait for the note to open up
      wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("new_note_button")));
	  driver.quit();
  }
  

}
