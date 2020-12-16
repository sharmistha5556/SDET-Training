package stepDefinitions;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CRM_Activity2 extends OpenBrowser{
	Actions actions = new Actions(driver);
	@And("^Navigate to Create Lead$")
	public void NavigateToCreateLead() throws Throwable{
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span//a[text()='Sales']")));
    	
     	WebElement menuOption = driver.findElement(By.xpath("//span//a[text()='Sales']"));
     	
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

}
