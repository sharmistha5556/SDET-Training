package hrm_project;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Activity3 {
	WebDriver driver;
	WebDriverWait wait;
	WebElement userName;
	WebElement password;
	WebElement login;
	WebElement loggedIn;
	
  @BeforeMethod
  public void beforeMethod() {
	//Initialize driver and wait
	  driver = new FirefoxDriver();
	  wait = new WebDriverWait(driver,10);
	  //Get the url
	  driver.get("http://alchemy.hguy.co/orangehrm");
	  //Initialize userName, password and login fields
	  userName = driver.findElement(By.id("txtUsername"));
	  password = driver.findElement(By.id("txtPassword"));
	  login = driver.findElement(By.id("btnLogin"));
  }

  @Test
  public void testActivity3() {
	  //Enter userName and password
	  userName.sendKeys("orange");
	  password.sendKeys("orangepassword123");
	  //Click on login
	  login.click();
	  //Verify homepage has opened
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("menu")));
	  Assert.assertTrue(driver.findElement(By.id("welcome")).isDisplayed());
  }
  
  @AfterMethod
  public void afterMethod() {
	  //Close the driver
	  driver.close();
  }

}