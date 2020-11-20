package hrm_project;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class Activity6 {
	WebDriver driver = new FirefoxDriver();
	WebDriverWait wait = new WebDriverWait(driver,10);
	Actions actions = new Actions(driver);
  @Test
  public void f() {
	  //Fill in the login credentials
	  WebElement username=driver.findElement(By.id("txtUsername"));
	  WebElement password=driver.findElement(By.id("txtPassword"));
	  username.sendKeys("orange");
	  password.sendKeys("orangepassword123");
	  
	  //Click on the login button
	  driver.findElement(By.id("btnLogin")).click();
	  
	  //Wait for the Directory menu
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("menu_directory_viewDirectory")));
	  
	  //Navigate to the Directory page
	  WebElement directory=driver.findElement(By.xpath("//a[@id='menu_directory_viewDirectory']/b"));
	  actions.doubleClick(directory).perform();
	  
	//Wait for the Directory menu
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='content']//h1[text()='Search Directory']")));
	  
	  String header=driver.findElement(By.xpath("//div[@id='content']//h1[text()='Search Directory']")).getText();  
	  
	  //Verify the header of the page
	  Assert.assertEquals("Search Directory", header);
	  	  
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
