package selenium_session1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity9_1 {

	public static void main(String[] args) {
		// 	TODO Auto-generated method stub
        WebDriver driver = new FirefoxDriver();
    	
        WebDriverWait wait = new WebDriverWait(driver, 10);
		
        //Open browser	
        driver.get("https://training-support.net/selenium/dynamic-attributes");
        System.out.println("Title of the page is: "+driver.getTitle());
        
        driver.findElement(By.xpath("//div/input[contains(@class,'username')]")).sendKeys("admin");
        driver.findElement(By.xpath("//div/input[contains(@class,'password')]")).sendKeys("password");
        driver.findElement(By.xpath("//div/button[contains(text(),'Log in')]")).click();
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("action-confirmation")));
        
        System.out.println(driver.findElement(By.id("action-confirmation")).getText());
        
        driver.close();

	}

}
