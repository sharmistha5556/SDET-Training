package selenium_session1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity11_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        WebDriver driver = new FirefoxDriver();      
	
        // Navigate to the activity page
	
        driver.get("https://www.training-support.net/selenium/javascript-alerts");
        
      //Find the page title and print it			
        String pageTitle = driver.getTitle();		
	     System.out.println(pageTitle);
	     
	   //Click the simple alert button
	     driver.findElement(By.xpath("//button[@id='confirm']")).click();
	     Alert confirmAlert=driver.switchTo().alert();
	     
	     String text=confirmAlert.getText();
	     System.out.println("Alert text says: "+text);
	     confirmAlert.dismiss();
	     
	   //Click the simple alert button
	     driver.findElement(By.xpath("//button[@id='confirm']")).click();
	     confirmAlert.accept();
	     
	     driver.close();
	     

	}

}
