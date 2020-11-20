package hrm_project;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity7 {
	WebDriver driver;
	WebDriverWait wait;
	WebElement userName;
	WebElement password;
	WebElement login;
	WebElement loggedIn;
	@BeforeMethod

	  public void beforeMethod() {

		  driver = new FirefoxDriver();
		  wait = new WebDriverWait(driver,10);
		  driver.get("http://alchemy.hguy.co/orangehrm");
		  userName = driver.findElement(By.id("txtUsername"));
		  password = driver.findElement(By.id("txtPassword"));
		  login = driver.findElement(By.id("btnLogin"));
		  	 
		 
	  }
  @Test
  public void F() throws InterruptedException {

	  userName.sendKeys("orange");
	  password.sendKeys("orangepassword123");
	  login.click();
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("menu")));
	  loggedIn = driver.findElement(By.id("welcome"));
	  Assert.assertTrue(loggedIn.isDisplayed());
	  
	  //wait for MyInfo menu
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("menu_pim_viewMyDetails")));
	  
	//Navigate to the “My Info” page.
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"menu_pim_viewMyDetails\"]")));
		driver.findElement(By.id("menu_pim_viewMyDetails")).click();
		driver.findElement(By.id("menu_pim_viewMyDetails")).click();
		
	//scroll down the page
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
	//select qualifications option
		driver.findElement(By.linkText("Qualifications")).click();
	
	//add work exp
		driver.findElement(By.id("addWorkExperience")).click();
        driver.findElement(By.id("experience_employer")).sendKeys("IBM");
        driver.findElement(By.id("experience_jobtitle")).sendKeys("Test Specialist");
        
     //adding dates
        driver.findElement(By.id("experience_from_date")).click();
        driver.findElement(By.id("experience_from_date")).sendKeys("2018-01-01");
        driver.findElement(By.id("experience_from_date")).sendKeys(Keys.ENTER);
        
        Thread.sleep(2000);
        driver.findElement(By.id("experience_to_date")).click();
        driver.findElement(By.id("experience_to_date")).sendKeys("2020-01-01");
        driver.findElement(By.id("experience_to_date")).sendKeys(Keys.ENTER);
        
      //adding comment
        driver.findElement(By.id("experience_comments")).sendKeys("comment for test");
       
      //save the details
        driver.findElement(By.id("btnWorkExpSave")).click();
        

  }
  @AfterMethod
  public void afterMethod() {
      driver.close();
  }
}
