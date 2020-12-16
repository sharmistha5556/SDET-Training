package stepDefinitions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class CRM_Activity1 extends OpenBrowser{
	
	 @Given("^Open the CRM page$")
	 public void openCRM() throws Throwable{
		//Create a new instance of the Firefox driver	 
	        wait = new WebDriverWait(driver, 15);
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
	

}
