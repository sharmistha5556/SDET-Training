package testNG_Sessions;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;

public class Activity2 {
	WebDriver driver;
  @BeforeMethod
  public void beforeMethod() {
	   //Create a new instance of the Firefox driver
	    driver = new FirefoxDriver();
	      
	   //Open browser
	    driver.get("https://www.training-support.net/selenium/target-practice");
	  }

  @Test
  public void login() {
	// Check the title of the page
      String title = driver.getTitle();
          
      //Print the title of the page
      System.out.println("Page title is: " + title);
          
          //Assertion for page title
      Assert.assertEquals("Target Practice", title);
  }
  
  @Test
  public void findButton() {
	  WebElement blackbutton=driver.findElement(By.className("black button"));
	  Assert.assertTrue(blackbutton.isDisplayed());
	  Assert.assertEquals(blackbutton.getText(), "black");		
	  }
  
  @Test(enabled = false) 	
  public void skipcase() {
	  //This test will be skipped and not counted	
      String subHeading = driver.findElement(By.className("sub")).getText();	
      Assert.assertTrue(subHeading.contains("Practice"));	
  }
  
  @Test
  
  public void Testcase4() {
	  throw new SkipException("Skipping test case");  
  } 

  @AfterMethod
  public void afterMethod() {
	  //Close the browser
     // driver.quit();
  }

}
