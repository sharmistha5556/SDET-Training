package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;

public class OrangeHRM_Activity1 extends OpenBrowser{
	 @Given("^Open the OrangeHRM page$")
	    public void userIsOnOrangeHRMPage() throws Throwable {	    	
	        //Create a new instance of the Firefox driver
		 
	        wait = new WebDriverWait(driver, 15);
	        //Open the browser
		
	        driver.get("http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/auth/login");
	        
	      //wait for the landing page
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logInPanelHeading")));
			 		
	    }
	 
	 @And("^Login with credentials provided$")
	 public void setCredentials() throws Throwable {		 		
		 //set values to userName, password and login fields
		  driver.findElement(By.id("txtUsername")).sendKeys("orange");;
		  driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
		  driver.findElement(By.id("btnLogin")).click();
		  
		  //Verify homepage has opened
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("menu")));
		 
	 }
	 
	 @And("^Navigate to \"Recruitment\" page$")
	 public void navigatetoRecruitment() throws Throwable {
		 //Actions actions = new Actions(driver);
		//Click on Recruitment
		  WebElement Recruitment=driver.findElement(By.cssSelector("#menu_recruitment_viewRecruitmentModule"));
		  //actions.doubleClick(Recruitment).perform();
		  Recruitment.click();
		  Recruitment.click();
	 }
	 
	 @And("^Navigate to Vacancies menu item$")
	 public void navigatetoVacancies() throws Throwable {		  
		  driver.findElement(By.cssSelector("#menu_recruitment_viewJobVacancy")).click();
		  driver.findElement(By.cssSelector("#menu_recruitment_viewJobVacancy")).click();
		  
		  //wait for the vacancies page to load
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("srchVacancy")));
		 
	 }
	 
	 @And("^Click on \"Add Job Vacancy\"$")
	 public void ClickAddJobvacancy() throws Throwable {		  
		  driver.findElement(By.cssSelector("#btnAdd")).click();
		  
		  //wait for the vacancies page to load
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("addJobVacancy")));
		 
	 }
	 
	 
	 @When("^User fills out \"(.*)\", \"(.*)\", \"(.*)\" details$")
	 public void FillDetails(String JobName, String VacancyName, String HiringMgr) throws Throwable {
		 WebElement jobTitle=driver.findElement(By.id("addJobVacancy_jobTitle"));
		  Select dropdown=new Select(jobTitle);
		  dropdown.selectByVisibleText(JobName);
		  
		  driver.findElement(By.id("addJobVacancy_name")).sendKeys(VacancyName);
		  
		  WebElement textbox =driver.findElement(By.id("addJobVacancy_hiringManager"));
		  textbox.sendKeys(HiringMgr);
		  textbox.sendKeys(Keys.ENTER);
		  
		  driver.findElement(By.id("addJobVacancy_noOfPositions")).sendKeys("2");		  
		  
	 }
	 
	 @And("^Click on save button$")
	 public void SaveButton() throws Throwable{
		 driver.findElement(By.cssSelector("#btnSave")).click();
		 String text=driver.findElement(By.xpath("//div[@id='addJobVacancy']/div/h1")).getText();
		Assert.assertEquals("The vacancy was not created", "Edit Job Vacancy", text);
	 }
	 
	 @Then("^Verify that the vacancy was created with \"(.*)\", \"(.*)\", \"(.*)\" details$")
	 public void VerifyVacancyGenerated(String JobName, String VacancyName, String HiringMgr) throws Throwable{
		 this.navigatetoVacancies();
		 
		  WebElement jobTitle=driver.findElement(By.id("vacancySearch_jobTitle"));
		  Select dropdown=new Select(jobTitle);
		  dropdown.selectByVisibleText(JobName);
		  
		  WebElement jobVacancy=driver.findElement(By.id("vacancySearch_jobVacancy"));
		  Select dropdown1=new Select(jobVacancy);
		  dropdown1.selectByVisibleText(VacancyName);
		  
		  driver.findElement(By.id("btnSrch")).click();
		  
		  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		  
		//Validate that the vacancy has been added 
		  List<WebElement> tableRows=driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr"));
		  
		  for (int i=1;i<=tableRows.size();i++){
			  WebElement vacancy =driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr["+i+"]/td[2]/a")); 
			  Assert.assertEquals("The vacancy was not created", VacancyName, vacancy.getText());
		  }
		  	  
		 
	 }

}
