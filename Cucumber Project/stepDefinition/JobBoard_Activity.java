package stepDefinitions;

import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import static org.junit.Assert.*;

public class JobBoard_Activity{
	WebDriver driver;
	WebDriverWait wait;
	
	@Before("@activity1_1")
	public void initializeJobBoard() {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver,10);
	}
			
	// creating an instance of Random class
	  Random rand = new Random();
	  // Generating random integers in range 0 to 99
	  int int1 = rand.nextInt(1000);
	  int int2 = rand.nextInt(2000);
	  String username = "Sharmistha Sinha"+int1;
	  String email = "Sharmistha"+int2+"@jobs.com";
	 
	 @Given("^User is on Job Board Login page$")
	    public void userIsOnLoginPage() throws Throwable {	    	
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
		  
	@Before("@activity1_2")
	public void initializeJobBoard2() {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver,10);
	}
	 
	 @Given("^Open Alchemy JobSite$")
	  
	 	public void LaunchAlchemyJobSite() throws Throwable {	
	        //Open the browser		
	        driver.get("https://alchemy.hguy.co/jobs/");
	 }
	 
	 @And("^Navigate to jobs page$")
	 	public void JobPageNavigate() throws Throwable{
		 
		  //wait for the Jobs link to become clickable
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), 'Jobs')]")));
		 
		 //click on Job link
		 driver.findElement(By.xpath("//a[(text()='Jobs')]")).click();
	 }
	 
	 @When("^User searches for \"(.*)\" jobs through keyword field$")
	 	public void FindJobs(String JobTitle) throws Throwable{
		 
		 //wait for the Keywords editbox to become editable
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='search_keywords']")));
		 
		 driver.findElement(By.xpath("//input[@id='search_keywords']")).sendKeys(JobTitle);
		 
		 //driver.findElement(By.xpath("//input[@type='submit']")).click();	
		 driver.findElement(By.xpath("//div[@class='search_submit']")).click();	
		 
	 }
	 
	 @And("^Filter job types to show \"Full Time\" jobs$")
	 	public void jobFilter() throws Throwable{
		 
		 //Find the list of all the filters
		 List<WebElement> JobTypes=driver.findElements(By.xpath("//ul[@class='job_types']/li"));
		 
		 //deselect all the filters
		 for (WebElement Jobtype : JobTypes) {
				 Jobtype.click();
			
		}
		
		 //select full Time filter
		 WebElement FullTimecheckbox=driver.findElement(By.xpath("//input[@id='job_type_full-time']"));
		 if (!FullTimecheckbox.isSelected())		 
			 FullTimecheckbox.click();
		 
	 }
	 
	 @And("^Find the job listing$")
	 	public void jobListed() throws Throwable{
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@class='job_listings']/li")));
		List<WebElement> jobHeaders=driver.findElements(By.xpath("//ul[@class='job_listings']/li"));
		jobHeaders.get(0).click();
		
	 }
	 
	 @And("^Find the job title and print on console$")
	 	public void PrintJob() throws Throwable{
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@class,'application_button')]")));
		 WebElement jobTitle=driver.findElement(By.xpath("//h1[@class='entry-title']"));	 
		 System.out.println("The job title is: "+jobTitle.getText());
	 }
	 
	 @Then("^Click and Apply for the job$")
	 	public void applyJob() throws Throwable{
		 driver.findElement(By.xpath("//input[contains(@class,'application_button')]")).click();		 
		 String actualtext=driver.findElement(By.xpath("//div[@class='application_details']/p")).getText();
		 
		 Assert.assertTrue(actualtext.contains("To apply for this job email your details to"));
	 }
	 
	 @Before("@activity1_3")
		public void initializeJobBoard3() {
		 driver = new FirefoxDriver();
		 wait = new WebDriverWait(driver,10);
		}
		
	 
	 @Before("@activity1_4")
		public void initializeJobBoard4() {
		 driver = new FirefoxDriver();
		 wait = new WebDriverWait(driver,10);
		}
	 
		// creating an instance of Random class
			  //Random rand = new Random();
			  // Generating random integers in range 0 to 99
			  int int3 = rand.nextInt(100);
			  int int4 = rand.nextInt(200);
		 
		 @And("^Navigate to Post A Job page$")	 
		 public void NavigatetoPostAJob() throws Throwable{
			 //wait for the Jobs link to become clickable
			 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), 'Post a Job')]")));
			 
			 //click on Post A Job link
			 driver.findElement(By.xpath("//a[(text()='Post a Job')]")).click();
			 
			//wait for the Keywords editbox to become editable
			 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='create_account_email']")));
			 
		 }
		 
		 @When("^User sets \"(.*)\", \"(.*)\", \"(.*)\" and \"(.*)\"$")
		 public void JobCreation(String email,String JobTitle, String websiteURL,String company) throws Throwable{
			 email=email+int3;
			 JobTitle=JobTitle+int4;
			 driver.findElement(By.xpath("//input[@id='create_account_email']")).sendKeys(email);
			 
			 driver.findElement(By.xpath("//input[@id='job_title']")).sendKeys(JobTitle);
			 
			 driver.findElement(By.xpath("//input[@id='application']")).sendKeys(websiteURL);
			 
			 driver.findElement(By.xpath("//input[@id='company_name']")).sendKeys(company);
			 
			 driver.findElement(By.xpath("//select[@id='job_type']")).click();
			 
			 driver.findElement(By.xpath("//input[@id='job_location']")).sendKeys("Tokyo");
			 
		 }
		 
		 @And("^Saves draft$")
		 public void SaveDraft() throws Throwable{
			 driver.findElement(By.xpath("//input[contains(@class,'save_draft')]")).click();
			 
			 //wait for the job dashboard to appear
			 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'job-manager-info')]")));		 
		 }
		 
		 @And("^Navigate to job dashboard$")
		 public void JobDashboard() throws Throwable{
			 driver.findElement(By.xpath("//div[contains(@class,'job-manager-info')]")).click();
			//wait for the job dashboard to appear
			 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(@class,'entry-title')]")));
		 }
		 
		 @Then("^Confirm the job listing contains \"(.*)\"$")
		 public void JobListing(String JobTitle) throws Throwable{
			//Validate that the Job Listing has the job
				  WebElement Title =driver.findElement(By.xpath("//table[@class='job-manager-jobs']/tbody/tr[1]/td[1]"));
				  Assert.assertTrue(Title.getText().contains(JobTitle));
		}
		 
		 @And ("^Close the Job Board Browser$")		
			public void JobBoardburndown() {
			//close the driver
				driver.quit();
				
		 }
 		
 	
 	}


