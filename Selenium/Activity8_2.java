package selenium_session1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity8_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        WebDriver driver = new FirefoxDriver();
    	
        WebDriverWait wait = new WebDriverWait(driver, 10);
		
        //Open browser	
        driver.get("https://training-support.net/selenium/ajax");
        System.out.println("Title of the page is: "+driver.getTitle());
        
        //Clickchange content button
        driver.findElement(By.className("violet")).click();
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='ajax-content']/h1")));
        System.out.println("Message from the page: "+driver.findElement(By.xpath("//div[@id='ajax-content']/h1")).getText());
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='ajax-content']/h3")));
        System.out.println("Message from the page: "+driver.findElement(By.xpath("//div[@id='ajax-content']/h3")).getText());
        
        driver.close();

	}

}
