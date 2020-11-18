package selenium_session1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity9_2 {

	public static void main(String[] args) {
		// 	TODO Auto-generated method stub
        WebDriver driver = new FirefoxDriver();
    	
        //Open browser	
        driver.get("https://training-support.net/selenium/dynamic-attributes");
        System.out.println("Title of the page is: "+driver.getTitle());
        
        driver.findElement(By.xpath("//div/input[contains(@class,'-username')]")).sendKeys("Sam");
        driver.findElement(By.xpath("//div/input[contains(@class,'-password')]")).sendKeys("pa$$w0rd");
       
        driver.findElement(By.xpath("//div/label[text()='Confirm Password']/following::input")).sendKeys("pa$$w0rd");
        driver.findElement(By.xpath("//div/input[contains(@class,'email-')]")).sendKeys("sharmistha555@gmail.com");
        driver.findElement(By.xpath("//div/button[contains(text(),'Sign Up')]")).click();
        
        String successMessage= driver.findElement(By.id("action-confirmation")).getText();
        
        System.out.println(successMessage);
        
        driver.close();
        
	}

}
