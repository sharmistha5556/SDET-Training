package stepDefinitions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OrangeHRM_Activity2 extends OpenBrowser{
	 @And("^Click on the Add button to add candidate$")
	 public void ClickAddCandidate() throws Throwable {		  
		  driver.findElement(By.cssSelector("#btnAdd")).click();
		  
		  //wait for the vacancies page to load
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("addCandidateHeading")));
		 
	 }
	 
	 @When("^User fills out \"(.*)\",\"(.*)\", \"(.*)\",\"(.*)\" candidate details$")
	 public void CandidateDetails(String FirstName, String Lastname, String email, String VacancyName) throws Throwable{
		 driver.findElement(By.id("addCandidate_firstName")).sendKeys(FirstName);
		 driver.findElement(By.id("addCandidate_lastName")).sendKeys(Lastname);
		 driver.findElement(By.id("addCandidate_email")).sendKeys(email);
		 
		 
		  WebElement textbox =driver.findElement(By.id("addCandidate_vacancy"));
		  Select dropdown=new Select(textbox);
		  dropdown.selectByVisibleText(VacancyName);
	 }
	 
	 @And("^Upload resume \"(.*)\" to the form$")
	 public void Upload(String FilePath) throws Throwable{
		 //driver.findElement(By.id("addCandidate_resume")).click();
		 WebElement upload =driver.findElement(By.id("addCandidate_resume"));
		 upload.sendKeys(FilePath);
		 driver.findElement(By.id("addCandidate_keyWords")).click();
		 
	 }
	 
	 @And("^Click Save$")
	 public void Save() throws Throwable{
		 driver.findElement(By.cssSelector("#btnSave")).click();
		 String text=driver.findElement(By.xpath("//div[@id='search-results']/div/h1")).getText();
		Assert.assertEquals("The vacancy was not created", "Candidate's History", text);
	 }
	 
	 @Then("^Navigate back to the Recruitments page to confirm candidate entry with \"(.*)\", \"(.*)\"$")
	 public void ValidateCandidateEntry(String name, String VacancyName) throws Throwable{
		  driver.findElement(By.cssSelector("#menu_recruitment_viewCandidates")).click();
		  driver.findElement(By.cssSelector("#menu_recruitment_viewCandidates")).click();
		  
		  //wait for the vacancies page to load
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("srchCandidates")));
		  
		  driver.findElement(By.id("candidateSearch_candidateName")).sendKeys(name);
		  
		  WebElement jobVacancy=driver.findElement(By.id("candidateSearch_jobVacancy"));
		  Select dropdown1=new Select(jobVacancy);
		  dropdown1.selectByVisibleText(VacancyName);
		  
		  WebElement status=driver.findElement(By.id("candidateSearch_status"));
		  Select dropdown2=new Select(status);
		  dropdown2.selectByVisibleText("Application Initiated");
		  
		  driver.findElement(By.id("btnSrch")).click();
		  
		  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		  
		//Validate that the vacancy has been added 
		  List<WebElement> tableRows=driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr"));
		  
		  for (int i=1;i<=tableRows.size();i++){
			  WebElement Candidatename =driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr["+i+"]/td[3]/a")); 
			  Assert.assertEquals("The vacancy was not created", name, Candidatename.getText());
		  }
	 }
}
