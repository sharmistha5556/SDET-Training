package hrm_project;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;


public class Activity9 {
	WebDriver driver;
	WebDriverWait wait;
	WebElement userName;
	WebElement password;
	WebElement login;
	WebElement loggedIn;
	//Actions actions = new Actions(driver);
    
 @BeforeMethod
	  public void beforeMethod() {
		  driver = new FirefoxDriver();
		  wait = new WebDriverWait(driver,10);
		   driver.get("http://alchemy.hguy.co/orangehrm");
		   userName = driver.findElement(By.id("txtUsername"));
		  password = driver.findElement(By.id("txtPassword"));
		  login = driver.findElement(By.id("btnLogin"));
		  	  }
  @Test
  public void test() {
	  userName.sendKeys("orange");
	  password.sendKeys("orangepassword123");
	  login.click();
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("menu")));
	  loggedIn = driver.findElement(By.id("welcome"));
	  Assert.assertTrue(loggedIn.isDisplayed());
	 //Navigate to the “My Info” page.
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"menu_pim_viewMyDetails\"]")));
	 driver.findElement(By.id("menu_pim_viewMyDetails")).click();
	 driver.findElement(By.id("menu_pim_viewMyDetails")).click();
	
	 //Click on the “Emergency Contacts” menu item	 
	 driver.findElement(By.xpath("//a[contains(@href,'viewEmergencyContacts')]")).click();
	   
	 //Retrieve information about all the contacts listed in the table
	//To locate rows of table. 
		 List<WebElement> rows_table =driver.findElements(By.xpath("//table[contains(@class, 'table')]/tbody/tr"));
		 //To calculate no of rows In table.
		    	int rows_count = rows_table.size();
			System.out.println(rows_count);
			//Loop will execute till the last row of table.
				for (int row = 0; row < rows_count; row++) {
		    	    //To locate columns(cells) of that specific row.
		    	    List < WebElement > Columns_row = rows_table.get(row).findElements(By.tagName("td"));
		    	    //To calculate no of columns (cells). In that specific row.
		    	    int columns_count = Columns_row.size();
		    	    //Loop will execute till the last cell of that specific row.
		    	    for (int column = 1; column < columns_count; column++) {
		    	        // To retrieve text from that specific cell.
		    	        String celtext = Columns_row.get(column).getText();
		    	        System.out.println("Row " + row + " and column  " + column + " Is " + celtext);
		    	    }
		    	    System.out.println("-------------------------------------------------- ");
		    	}
     
	
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }

}
