package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;

public class OrangeHRM_Activity{
	public WebDriver driver;
	public WebDriverWait wait;
	
	@Before("@activity2_1")
	public void initializeORangeHRM1() {
		driver=new FirefoxDriver();	
		wait=new WebDriverWait(driver, 10);
	}
	
	 @Given("^Open the OrangeHRM page$")
	    public void userIsOnOrangeHRMPage() throws Throwable {	    	
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
	 
	 @Before("@activity2_2")
		public void initializeOrangeHRM2() {
			driver=new FirefoxDriver();	
			wait=new WebDriverWait(driver, 10);
		}
		
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
		 
		 @Before("@activity2_3")
			public void initializeORangeHRM3() {
				driver=new FirefoxDriver();	
				wait=new WebDriverWait(driver, 10);
			}
			
				String employeeId;
			  Random rand = new Random();
			  // Generating random integers in range 0 to 99
			  int int1 = rand.nextInt(1000);
			  int int2 = rand.nextInt(2000);
			  
			@And("^Click the PIM option$")
			public void ClickPIMmenu() throws Throwable{
				 //Wait for the PIM menu
				  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("menu_pim_viewPimModule")));
				  
				  //Navigate to PIM page
				  driver.findElement(By.id("menu_pim_viewPimModule")).click();	
				  driver.findElement(By.id("menu_pim_viewPimModule")).click();
			}
			
			@And("^Click on the add employee button$")
			public void AddEmployee() throws Throwable{
				//Wait for the AddEmployee menu
				  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("menu_pim_addEmployee")));
				  
				  //launch the addEmployee page
				  driver.findElement(By.id("menu_pim_addEmployee")).click();
				  driver.findElement(By.id("menu_pim_addEmployee")).click();
			}
			
			@And("^Check the \"Create Login Details\" checkbox$")
			public void CheckCreateLoginDetails() throws Throwable{
				wait.until(ExpectedConditions.elementToBeClickable(By.id("chkLogin")));
				 WebElement checkbox= driver.findElement(By.id("chkLogin"));
				  
				  if (!checkbox.isSelected())
					  checkbox.click();
			}
			
			@When("^User creates employee with \"(.*)\", \"(.*)\"$")
			public void addEmployee(String firstname, String lastname) throws Throwable{
				  driver.findElement(By.id("firstName")).sendKeys(firstname);
				  driver.findElement(By.id("lastName")).sendKeys(lastname);
				  driver.findElement(By.id("user_name")).sendKeys(firstname+int1);
				  driver.findElement(By.id("user_password")).sendKeys(lastname+int2);
				  driver.findElement(By.id("re_password")).sendKeys(lastname+int2);
				  
				  WebElement statuscheckbox=driver.findElement(By.id("status"));
				  
				  Select dropdown=new Select(statuscheckbox);
				  
				  dropdown.selectByValue("Enabled");
				  
				  //Fetch the employeeID
				  employeeId=driver.findElement(By.cssSelector("#employeeId")).getAttribute("value");	 
				  
				//Click on the save button
				  driver.findElement(By.id("btnSave")).click();
				  
				  //Wait for the AddEmployee menu
				  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='personalDetails']")));
				 
			}
			
			@Then("^Verify that the employee details has been created$")
			
			public void VerifyaddEmployee() throws Throwable{
				 //Navigate to EmployeeList page
				  driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
				  driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
				  
				  //Wait for the admin landing page to load
				  wait.until(ExpectedConditions.elementToBeClickable(By.id("empsearch_id")));
				  
				  //Set the employee id
				  driver.findElement(By.id("empsearch_id")).sendKeys(employeeId);	
				  
				  driver.findElement(By.id("searchBtn")).click();
				  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				  
				//Validate that the vacancy has been added 
				  List<WebElement> tableRows=driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr"));
				  
				  for (int i=1;i<=tableRows.size();i++){
					  WebElement EmployeeNumber =driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr["+i+"]/td[2]/a")); 
					  Assert.assertEquals("The employee was not created", employeeId, EmployeeNumber.getText());
				  }
				  
			}
			
			@Before("@activity2_4")
			public void initializeORangeHRM4() {
				driver=new FirefoxDriver();	
				wait=new WebDriverWait(driver, 10);
			}
	 
	 @And ("^Close the Orange HRM Browser$")		
		public void OrangeHRMburndown() {
		//close the driver
			driver.quit();
			
	 }

}
