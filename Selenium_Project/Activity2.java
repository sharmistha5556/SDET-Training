package hrm_project;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2 {
	WebDriver driver = new FirefoxDriver();
	  @BeforeMethod
	  public void beforeMethod() {
		  driver.get("http://alchemy.hguy.co/orangehrm");
		  
		  }  
	  	
  @Test
  public void test() {
	  String title = driver.getTitle();
      System.out.println("Title is: " + title);
	  WebElement imgurl = driver.findElement(By.xpath("//img[@src=\"/orangehrm/symfony/web/webres_5d69118beeec64.10301452/themes/default/images/login/logo.png\"]"));
	  System.out.println(" url of the header image is" +  imgurl.getAttribute("src"));
        
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }

}


