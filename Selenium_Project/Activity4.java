package hrm_project;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeMethod;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class Activity4 {
	WebDriver driver = new FirefoxDriver();
	WebDriverWait wait = new WebDriverWait(driver,10);
	 
  @Test
  public void f() {
	  //Fill in the login credentials
	  WebElement username=driver.findElement(By.id("txtUsername"));
	  WebElement password=driver.findElement(By.id("txtPassword"));
	  username.sendKeys("orange");
	  password.sendKeys("orangepassword123");
	  
	  //Click on the login button
	  driver.findElement(By.id("btnLogin")).click();
	  //Wait for the PIM menu
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("menu_pim_viewPimModule")));
	  
	  //Navigate to PIM page
	  driver.findElement(By.id("menu_pim_viewPimModule")).click();
	  
	  //Wait for the AddEmployee menu
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("menu_pim_addEmployee")));
	  
	  //launch the addEmployee page
	  driver.findElement(By.id("menu_pim_addEmployee")).click();
	  
	  //Fill required employee details
	  driver.findElement(By.id("firstName")).sendKeys("Sharmistha");
	  driver.findElement(By.id("lastName")).sendKeys("Sinha");
	  
	  WebElement checkbox= driver.findElement(By.id("chkLogin"));
	  
	  if (!checkbox.isSelected())
		  checkbox.click();
	  
	// creating an instance of Random class
	  Random rand = new Random();
	  // Generating random integers in range 0 to 99
	  int int1 = rand.nextInt(1000);
	  int int2 = rand.nextInt(2000);
	  
	  driver.findElement(By.id("user_name")).sendKeys("Sharmistha Sinha"+int1);
	  driver.findElement(By.id("user_password")).sendKeys("HappyDays@"+int2);
	  driver.findElement(By.id("re_password")).sendKeys("HappyDays@"+int2);
	  
	  WebElement statuscheckbox=driver.findElement(By.id("status"));
	  
	  Select dropdown=new Select(statuscheckbox);
	  
	  dropdown.selectByValue("Enabled");
	  
	  //Click on the save button
	  driver.findElement(By.id("btnSave")).click();
	  
	  //Wait for the AddEmployee menu
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='personalDetails']")));
	  
	  //Navigate to admin page
	  driver.findElement(By.id("menu_admin_viewAdminModule")).click();
	  
	  //Wait for the admin landingg page to load
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchSystemUser_userName")));
	  
	  //Set the username and click on search button
	  driver.findElement(By.id("searchSystemUser_userName")).sendKeys("Sharmistha Sinha"+int1);
	  driver.findElement(By.id("searchBtn")).click();
	  
	//Validate that the Employee profile has been added 
	  WebElement textvalue=driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr/td[4]"));
	  String actualvalue=textvalue.getText();
	  String expected="Sharmistha Sinha";
	  
	  Assert.assertTrue(actualvalue.contains(expected));
	  
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
