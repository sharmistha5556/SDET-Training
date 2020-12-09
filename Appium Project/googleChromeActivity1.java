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
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class googleChromeActivity1 {
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
	 
  @Test
  public void addtasks() {
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
      driver.get("https://www.training-support.net/selenium");
      
      //wait for the landing page
      wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.Button[@text='Get Started!']")));
      
      // Scroll element into view and click it
      driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).flingForward().scrollIntoView(textContains(\"To-Do List\"))")).click();
      //driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).flingToEnd(1).scrollIntoView(textContains(\"To-Do List\"))")).click();
     // driver.findElement(MobileBy.AndroidUIAutoator("UiScrollable(UiSelector().scrollable(true)).scrollforward(8).scrollIntoView(textContains(\\\"To-Do List\\\"))")).click();
      
      //driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).getChildByText(UiSelector().className(\"android.view.View\"), \"To-Do List\")")).click();
      //driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).scrollTextIntoView( \"To-Do List\")")).click();
     
      //Wait for the taskinput page to appear
      wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("//android.widget.Button[@text='Add Task']")));
      
      //Create a list to add to the tasks
      List<String> tasksToAdd = new ArrayList<String>();
      tasksToAdd.add("Task1");
      tasksToAdd.add("Task2");
      tasksToAdd.add("Task3");
      String EditTaskLocator = "resourceId(\"taskInput\")"; 
      
      //Add the tasks to the list
      for (String task : tasksToAdd) {  	  		
          driver.findElement(MobileBy.AndroidUIAutomator(EditTaskLocator)).sendKeys(task);
          driver.findElement(MobileBy.AndroidUIAutomator(EditTaskLocator)).click();         
          driver.findElement(MobileBy.AndroidUIAutomator("textContains(\"Add Task\")")).click();
    	  driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    	  
	}
      
     //get the takss added
      List<MobileElement> tasksAdded=driver.findElementsByXPath("//android.view.View[@resource-id='tasksList']/android.view.View");
      int items=tasksAdded.size();
      
      //Validate all the tasks have been added
      for (int i = 2; i <= items; i++) {
    	  String path="//android.view.View[@resource-id='tasksList']/android.view.View["+i+"]/android.view.View";
    	  String Task=driver.findElementByXPath(path).getText();
    	  Assert.assertTrue(tasksToAdd.contains(Task));
    	  driver.findElementByXPath(path).click();
    	  
	}
      //Clear the list created
      driver.findElement(MobileBy.AndroidUIAutomator("textContains(\"To-Do List\")")).click();
      driver.findElement(MobileBy.AndroidUIAutomator("textContains(\"Clear List\")")).click();
     
     //Validate that all elements are cleared
      tasksAdded=driver.findElementsByXPath("//android.view.View[@resource-id='tasksList']/android.view.View");
     Assert.assertEquals(0, tasksAdded.size()); 
      
  }

  @AfterClass
  public void tearDown() {
		
      driver.quit();
	
  }

}
