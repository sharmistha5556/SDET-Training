package stepDefinitions;

import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class JobBoard_Activity3 extends OpenBrowser{
	
	// creating an instance of Random class
		  Random rand = new Random();
		  // Generating random integers in range 0 to 99
		  int int1 = rand.nextInt(100);
		  int int2 = rand.nextInt(200);
	 
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
		 email=email+int1;
		 JobTitle=JobTitle+int2;
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
	 	 

}
