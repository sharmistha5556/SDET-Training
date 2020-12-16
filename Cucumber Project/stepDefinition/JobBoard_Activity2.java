package stepDefinitions;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class JobBoard_Activity2 extends OpenBrowser{
	 
	 @Given("^Open Alchemy JobSite$")
	  
	 	public void LaunchAlchemyJobSite() throws Throwable {
	    	
	        //Create a new wait instance of the Firefox driver		
	        wait = new WebDriverWait(driver, 10);
				
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
	 

}
