package selenium_session1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Activity11_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Declare new WebDriver
		
        WebDriver driver = new FirefoxDriver();      
	
        // Navigate to the activity page
	
        driver.get("https://www.training-support.net/selenium/javascript-alerts");
        
      //Find the page title and print it			
	     String pageTitle = driver.getTitle();		
	     System.out.println(pageTitle);
	     
	     //Click the simple alert button
	     driver.findElement(By.xpath("//button[@id='simple']")).click();
	     
	     Alert simpleAlert = driver.switchTo().alert();
	     String alertext=simpleAlert.getText();
	     
	        System.out.println("Alert text is: " + alertext);
	    	
	        
	    	
	        //Close the alert box
		
	        simpleAlert.accept();
		
	 
		
	        //Close the Browser
		
	        driver.close();
	     

	}

}
