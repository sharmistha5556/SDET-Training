package hrm_project;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class Activity5 {
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
	  //Wait for the PIM menu
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("menu_pim_viewPimModule")));
	  
	  //Click on MyInfo
	  WebElement myinfo=driver.findElement(By.cssSelector("#menu_pim_viewMyDetails"));
	  actions.doubleClick(myinfo).perform();
	  
	  //Wait for personal details tab to be visible
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@href,'viewPersonalDetails')]")));
	  
	  //Navigate to the personal details page
	  driver.findElement(By.xpath("//a[contains(@href,'viewPersonalDetails')]")).click();
	  
	  //Click the Edit button
	  driver.findElement(By.id("btnSave")).click();
	  
	  //Fill in Name
	  Random rand = new Random();
	  // Generating random integers in range 0 to 9999
	  int int1 = rand.nextInt(10000);
	  int int2 = rand.nextInt(10000);
	  
	  driver.findElement(By.id("personal_txtEmpFirstName")).clear();
	  driver.findElement(By.id("personal_txtEmpFirstName")).sendKeys("Sam"+int1);
	  driver.findElement(By.id("personal_txtEmpLastName")).clear();
	  driver.findElement(By.id("personal_txtEmpLastName")).sendKeys("Das"+int2);
	  
	  //Fill in Gender
	  driver.findElement(By.id("personal_optGender_2")).click();
	  
	  //Fill in Nationality
	  
	  WebElement nationality=driver.findElement(By.id("personal_cmbNation"));
	  Select dropdown=new Select(nationality);
	  dropdown.selectByVisibleText("Indian");  
	  
	  //Fill in DOB
	  driver.findElement(By.id("personal_DOB")).clear();
	  driver.findElement(By.id("personal_DOB")).sendKeys("1985-01-01");
	  
	//Click the Save button
	  driver.findElement(By.id("btnSave")).click();
	  	  
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
