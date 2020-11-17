package selenium_session1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity_3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new FirefoxDriver();
		
		driver.get("https://www.training-support.net/selenium/simple-form");
		Thread.sleep(5000);
			
		System.out.println("Title of the page is " +driver.getTitle());
		
		WebElement firstnamelocator = driver.findElement(By.id("firstName"));
		WebElement lastnamelocator = driver.findElement(By.id("lastName"));
		WebElement emaillocator = driver.findElement(By.id("email"));
		WebElement contactlocator = driver.findElement(By.id("number"));
		
		firstnamelocator.sendKeys("Sharmistha");
		lastnamelocator.sendKeys("Sinha");
		emaillocator.sendKeys("sharsinh@in.ib.com");
		contactlocator.sendKeys("9049161929");
		
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".ui.green.button")).click();
		
		driver.close();
		
		
		
	}

}
