package stepDefinitions;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OrangeHRM_Activity3 extends OpenBrowser{
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
	
}
