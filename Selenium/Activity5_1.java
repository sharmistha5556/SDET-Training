package selenium_session1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5_1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		 WebDriver driver = new FirefoxDriver();
 		
		    //Open the browser
			 driver.get("https://training-support.net/selenium/dynamic-controls");
			 
			//Find the page title and print it			
		     String pageTitle = driver.getTitle();		
		     System.out.println(pageTitle);
		     
		     WebElement idcheckbox = driver.findElement(By.xpath("//input[@class='willDisappear']"));
		     System.out.println("The checkbox Input is displayed: " + idcheckbox.isDisplayed());
		     idcheckbox.click();
		     System.out.println("The checkbox Input is displayed: " + idcheckbox.isDisplayed());
		     Thread.sleep(5000);
		     
			 //Close the browser
			 	
		     driver.close();

	}

}
