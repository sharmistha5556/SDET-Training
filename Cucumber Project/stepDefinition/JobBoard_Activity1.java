package stepDefinitions;

import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import static org.junit.Assert.*;

public class JobBoard_Activity1 extends OpenBrowser{
		
	
	// creating an instance of Random class
	  Random rand = new Random();
	  // Generating random integers in range 0 to 99
	  int int1 = rand.nextInt(1000);
	  int int2 = rand.nextInt(2000);
	  String username = "Sharmistha Sinha"+int1;
	  String email = "Sharmistha"+int2+"@jobs.com";
	 
	 @Given("^User is on Job Board Login page$")
	    public void userIsOnLoginPage() throws Throwable {	    	
	        //Create a new instance of the Firefox driver
		 
	        wait = new WebDriverWait(driver, 15);
	        //Open the browser
		
	        driver.get("https://alchemy.hguy.co/jobs/wp-admin");
		
	    }
	 
	 @When("^User enters \"(.*)\" and \"(.*)\"$")
		
	    public void parameterizedCredentials(String username, String password) throws Throwable {
		
	        //Enter username from Feature file
		
	        driver.findElement(By.id("user_login")).sendKeys(username);
		
	        //Enter password from Feature file
		
	        driver.findElement(By.id("user_pass")).sendKeys(password);
		
	        //Click Login
		
	        driver.findElement(By.id("wp-submit")).click();
		
	    }
	 
	 
	 @And("^Click on users$")
	 
	 public void Users() throws Throwable {
		 
		 //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'menu')][@text()='Dashboard']")));
		 
		 
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class, 'dashboard')]")));
		 
		 //Click on users
		 driver.findElement(By.xpath("//div[contains(@class, 'users')]")).click();
		 
	 }
	 
	 @And("^Click the Add New button$")
	 
	 public void AddNew() throws Throwable {
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@href,'user-new')]")));
		 
		 //Click on Add New link
		 driver.findElement(By.xpath("//a[contains(@href,'user-new')]")).click();
	 }
	 
	 @And("^Create a new user$")
	 
	 public void CreateNewuser() throws Throwable {
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_login")));
		 //Fill the details to add user
		 driver.findElement(By.id("user_login")).sendKeys(username);
		 driver.findElement(By.id("email")).sendKeys(email);
		 driver.findElement(By.id("first_name")).sendKeys("Sharmistha");
		 	 
		 //Click on create user
		 driver.findElement(By.id("createusersub")).click();
		 
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search-submit")));
	 }
 

	@Then("^Validate the user has been created$")
 	
 		public void ValidateNewUser() throws Throwable {
 		
 		//set the username to search for
 		 driver.findElement(By.id("user-search-input")).sendKeys(username);
 		 
 		 //Click on search user
		 driver.findElement(By.id("search-submit")).click();
		 
		//Validate that the user has been added 
		  WebElement textvalue=driver.findElement(By.xpath("//tbody[@id='the-list']/tr/td[3]"));
		  String actualvalue=textvalue.getText();
		  
		  System.out.println("the email is"+email);
		  Assert.assertEquals(email, actualvalue);
		  
	      }
		  
 		
 	
 	}


