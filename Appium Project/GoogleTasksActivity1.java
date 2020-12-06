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

public class GoogleTasksActivity1 {
	 AppiumDriver<MobileElement> driver = null;	
	    WebDriverWait wait;
  @Test
  public void addGoogleTask() {
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	// Click on add new task floating button	
	  MobileElement addbutton=driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"Create new task\"]");
	  addbutton.click();  
      
     //Wait for the New Task label to appear
      wait.until(ExpectedConditions.textToBePresentInElementLocated(MobileBy.id("com.google.android.apps.tasks:id/add_task_title"), "New task"));
      
      //add first task
      driver.findElementById("add_task_title").sendKeys("Complete Activity with Google Tasks");  
      driver.findElementById("add_task_title").click();
      //Hit the save button
      driver.findElementById("add_task_done").click();
      
      //wait for add button to appear'
      wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("//android.widget.FrameLayout[@content-desc=\"Complete Activity with Google Tasks\"]")));
    //get the task that has been added
      String firsttask=driver.findElementById("com.google.android.apps.tasks:id/task_name").getText();
      System.out.println("task 1:"+firsttask);
      
      //add second task
      addbutton.click();
    //Wait for the New Task label to appear
      wait.until(ExpectedConditions.textToBePresentInElementLocated(MobileBy.id("com.google.android.apps.tasks:id/add_task_title"), "New task"));
      
      driver.findElementById("add_task_title").sendKeys("Complete Activity with Google Keep");
      driver.findElementById("add_task_title").click();
      //Hit the save button
      driver.findElementById("add_task_done").click();
      
      
    //wait for add button to appear'
      wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("//android.widget.FrameLayout[@content-desc=\"Complete Activity with Google Keep\"]")));
      //get the task that has been added
      String secondtask=driver.findElementById("com.google.android.apps.tasks:id/task_name").getText();
      System.out.println("task 2:"+secondtask);
      
      //add third task
      addbutton.click();
    //Wait for the New Task label to appear
      wait.until(ExpectedConditions.textToBePresentInElementLocated(MobileBy.id("com.google.android.apps.tasks:id/add_task_title"), "New task"));
      
      driver.findElementById("add_task_title").sendKeys("Complete the second Activity Google Keep");
      driver.findElementById("add_task_title").click();
      //Hit the save button
      driver.findElementById("add_task_done").click();
      
      //wait for add button to appear'
      wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("//android.widget.FrameLayout[@content-desc=\"Complete the second Activity Google Keep\"]")));
      //get the task that has been added
      String thirdtask=driver.findElementById("com.google.android.apps.tasks:id/task_name").getText();
      System.out.println("task 3:"+thirdtask);
      
      Assert.assertEquals("Complete Activity with Google Tasks", firsttask);
      Assert.assertEquals("Complete Activity with Google Keep", secondtask);
      Assert.assertEquals("Complete the second Activity Google Keep", thirdtask);     
      
  }
  
  @BeforeClass
  public void beforeClass() throws MalformedURLException {		
      // Set the Desired Capabilities	
      DesiredCapabilities caps = new DesiredCapabilities();	
      caps.setCapability("deviceName", "<device name>");	
      caps.setCapability("platformName", "Android");	
      caps.setCapability("noReset", true);	
      // Use your own device's messaging app	
      caps.setCapability("appPackage", "com.google.android.apps.tasks");	
      caps.setCapability("appActivity", ".ui.TaskListsActivity");	
      // Instantiate Appium Driver	
      URL appServer = new URL("http://0.0.0.0:4723/wd/hub");	
      driver = new AndroidDriver<MobileElement>(appServer, caps);	
      wait = new WebDriverWait(driver, 10);
	
  }


  @AfterClass
  public void afterClass() {
	 for (int i=0; i<3; i++) {
		  wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("com.google.android.apps.tasks:id/tasks_item_completed_check")));
		  driver.findElementById("com.google.android.apps.tasks:id/tasks_item_completed_check").click();
		  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	 }	
	 driver.quit();
		  
  }

}
