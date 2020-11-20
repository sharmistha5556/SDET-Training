package hrm_project;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class Activity1 {
	WebDriver driver = new FirefoxDriver();
	WebDriverWait wait = new WebDriverWait(driver,10);
	 
  @Test
  public void f() {
	  //wait for the landing page
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logInPanelHeading")));
	  
	  //get the website title
	  String actualtitle=driver.getTitle();
	  String expectedtitle="OrangeHRM";
	  
	  Assert.assertEquals(expectedtitle,actualtitle);
	  
      }
  @BeforeMethod
  public void beforeMethod() {
	  //Launch the website
	  driver.get("http://alchemy.hguy.co/orangehrm");
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }

}
