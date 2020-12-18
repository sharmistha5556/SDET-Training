package stepDefinitions;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CRM_Activity{
	//public WebDriver driver;
	//public WebDriverWait wait;	
	WebDriver driver;
	WebDriverWait wait;
	
	@Before
	public void initialise() {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver,10);
	}
	
	
	 @Given("^Open the CRM page$")
	 public void openCRM() throws Throwable{
	        //Open the browser	
	        driver.get("https://alchemy.hguy.co/crm/");
		 
	 }
	 
	 @And("^Login with CRM credentials,\"(.*)\" and \"(.*)\"$")
	 public void CRMLoginPage(String username, String password) throws Throwable{
		 	//Enter username from Feature file			
	        driver.findElement(By.id("user_name")).sendKeys(username);
		
	        //Enter password from Feature file		
	        driver.findElement(By.id("username_password")).sendKeys(password);
		
	        //Click Login		
	        driver.findElement(By.id("bigbutton")).click();
		 
	 }
	 
	 @When("^Print the number and title of each Dashlet into the console$")
	 public void Dashletinfo() throws Throwable{
		 //wait for the landing page
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='text']")));
		 List<WebElement> Dashlets=driver.findElements(By.xpath("//td[@class='dashlet-title']"));
		 
		 //print the dashlet size
		 System.out.println("The total number of dashlets in the home page are:"+Dashlets.size());
		 
		 List<WebElement> dashletTitle = driver.findElements(By.xpath("//td[@class='dashlet-title']//span[2]"));
	        for(WebElement title : dashletTitle ){
	        	String titleTxt = title.getText();	
	        	System.out.println("Title of the dashlet is: "+titleTxt);
			 
	        } 
		
		 
	 }
	 
		@And("^Navigate to Create Lead$")
		public void NavigateToCreateLead() throws Throwable{
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span//a[text()='Sales']")));
	    	
	     	WebElement menuOption = driver.findElement(By.xpath("//span//a[text()='Sales']"));
	     	
	     	Actions actions = new Actions(driver);
	     	actions.moveToElement(menuOption).perform();
	     	
	     	driver.findElement(By.xpath("(//li//a[text()='Leads'])[1]")).click();
	     	
	     	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(), 'Leads')]")));
	     	
	     	driver.findElement(By.xpath("//div[@class='actionmenulink'][text()='Create Lead']")).click();
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'OVERVIEW')]")));
		}
		
		@When("^User fills in the necessary details, \"(.*)\" and \"(.*)\" to create lead accounts$")
		public void createLeads(String firstname, String lastname) throws Throwable{
			driver.findElement(By.id("first_name")).sendKeys(firstname);
	    	driver.findElement(By.id("last_name")).sendKeys(lastname);

		}
		
		@And("^Click Save to finish$")
		public void saveLeads() throws Throwable{
			driver.findElement(By.xpath("(//input[@id='SAVE'])[1]")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='actionmenulink'][text()='View Leads']")));
			
		}
		
		@Then("^Navigate to the View Leads page to see results of \"(.*)\" and \"(.*)\"$")
		public void ValidateLeadCreated(String firstname, String lastname) throws Throwable{
			driver.findElement(By.xpath("//div[@class='actionmenulink'][text()='View Leads']")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(), 'Leads')]")));
			String name=firstname+" "+lastname;
	    	
	    	 List<WebElement> leadnames = driver.findElements(By.xpath("//td[@class=' inlineEdit']/b/a[contains(@href,'DetailView')]"));
	    	 Assert.assertEquals(name, leadnames.get(0).getText());	
		     System.out.println("The expected name is:"+name);
		     System.out.println("The actual name was:"+leadnames.get(0).getText());
		     
		}
		
		@And("^Navigate to Schedule a Meeting$")
		public void ScheduleMeeting() throws Throwable{
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Activities']")));
	    	Actions actions = new Actions(driver);
	     	WebElement menuOption = driver.findElement(By.xpath("//a[text()='Activities']"));
	     	actions.moveToElement(menuOption).perform();
	     	
	     	driver.findElement(By.xpath("(//a[text()='Meetings'])[1]")).click();     	
	     	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h2[contains(text(), 'Meetings')]")));
	     	
	     	driver.findElement(By.xpath("//div[@class='actionmenulink'][text()='Schedule Meeting']")).click();
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'OVERVIEW')]")));
		
		}
		
		@When("^User enters the details of the meeting with subject \"(.*)\"$")
		public void MeetingDetails(String MeetingSubject) throws Throwable{
			driver.findElement(By.id("name")).sendKeys(MeetingSubject);
	    	   	
	     //Fill in Meeting start date
	  	  SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	  	  Date date = new Date();	  
	  	  
	  	  driver.findElement(By.id("date_start_date")).clear();
	  	  driver.findElement(By.id("date_start_date")).sendKeys(dateFormat.format(date));
	  	  
	  	  //Fill in the meeting end date
	  	  driver.findElement(By.id("date_end_date")).clear();
	  	  driver.findElement(By.id("date_end_date")).sendKeys(dateFormat.format(date)); 
			
		}
		
		@And("^Search for members and add them to the meeting and save the invite$")
		public void SearchMembers(DataTable email) throws InterruptedException {
			List<List<String>> list = email.asLists(String.class);
			
			for(int i=1; i<list.size(); i++) {
					driver.manage().window().maximize();
					driver.findElement(By.id("search_first_name")).clear();
					driver.findElement(By.id("search_first_name")).sendKeys(list.get(i).get(0));
					
					driver.findElement(By.id("search_last_name")).clear();
					driver.findElement(By.id("search_last_name")).sendKeys(list.get(i).get(1));
					
					// Clicking on 'Search' button
					driver.findElement(By.id("invitees_search")).click();
					
					driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
					
					wait.until(ExpectedConditions.elementToBeClickable(By.id("invitees_add_1")));
					driver.findElement(By.id("invitees_add_1")).click(); 
					
					driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			}
			
			//save invite
	    	driver.findElement(By.xpath("(//input[@id='SAVE_HEADER'])[2]")).click();
			
		}
		
		@Then("^Navigate to View Meetings page and confirm creation of the \"(.*)\"$")
		public void Validatemeeting(String MeetingSubject) throws Throwable{ 
			driver.findElement(By.xpath("//div[@class='actionmenulink'][text()='View Meetings']")).click();
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(), 'Meetings')]")));
	  
	    	 List<WebElement> Subjects = driver.findElements(By.xpath("//table[contains(@class,'list view table-responsive')]//b/a[contains(@href,'DetailView')]"));
	    	 Assert.assertEquals(MeetingSubject, Subjects.get(0).getText());	
		}
		
		@And("^Navigate to Create Product$")
		public void CreateProduct() throws Throwable{
			WebElement all = driver.findElement(By.xpath("//a[text()='All']"));
			Actions actions = new Actions(driver);
			actions.moveToElement(all).perform();
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[text()='Products'][contains(@href,'Products')]")));
			
			driver.findElement(By.xpath("//a[text()='Products'][contains(@href,'Products')]")).click();
			
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h2[contains(text(),'Products')]")));
			
			driver.findElement(By.xpath("//div[@class='actionmenulink'][text() = 'Create Product']")).click();
			
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h2[contains(text(),'CREATE')]")));	
		}
		
		@When("^User enters the details of the product like \"(.*)\" and \"(.*)\"$")
		public void ProductAddition(String productname, String price) throws Throwable{
			driver.findElement(By.id("name")).sendKeys(productname);  
	  	  	driver.findElement(By.id("price")).sendKeys(price);
		}
		
		@And("^save the product created$")
		public void SaveProduct() throws Throwable{
	    	//save invite
			driver.findElement(By.id("SAVE")).click();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
		}
		
		@Then("^Navigate to View Products page and confirm creation of the product named \"(.*)\"$")
		public void ValidateProductCreated(String Productname) throws Throwable{ 
			driver.findElement(By.xpath("//div[@class='actionmenulink'][text()='View Products']")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.
					xpath("//table[@class='list view table-responsive']/tbody/tr[1]/td[3]/b/a")));
	  
	    	 List<WebElement> Subjects = driver.findElements(By.xpath("//table[contains(@class,'list view table-responsive')]//b/a[contains(@href,'DetailView')]"));
	    	 Assert.assertEquals(Productname, Subjects.get(0).getText());	
		}
	 

		@After
		@And ("^Close the Browser$")		
		public void burndown() {
		//close the driver
			driver.quit();
			
	 }

}
