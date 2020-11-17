package selenium_session1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new FirefoxDriver();
		
		driver.get("https://www.training-support.net");
		Thread.sleep(5000);
			
		System.out.println("Title of the page is " +driver.getTitle());
		
		WebElement idLocator = driver.findElement(By.xpath("//a[@id='about-link']"));
		idLocator.click();
		Thread.sleep(5000);
		
        System.out.println("Heading is: " + driver.getTitle());
    	
        
    	
        //Close the browser
	
        driver.close();
	
 
				

	}

}
