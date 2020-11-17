package selenium_session1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity_1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new FirefoxDriver();
		
		driver.get("https://www.google.com");
		Thread.sleep(5000);
		
		System.out.println(driver.getTitle());
		driver.close();

	}

}
