package selenium_session1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 WebDriver driver = new FirefoxDriver();
	    		
	    //Open the browser
		 driver.get("https://www.training-support.net/selenium/target-practice");
		 
		//Find the page title and print it			
	     String pageTitle = driver.getTitle();		
	     System.out.println(pageTitle);
	     
	     WebElement thirdheader= driver.findElement(By.xpath("//h3[@id='third-header']"));
	     System.out.println("The third header text is: "+thirdheader.getText());
	     
	     WebElement fifthheader= driver.findElement(By.xpath("//h5[contains(@class,'green header')]"));
	     System.out.println("The colour of the fifth header is: "+fifthheader.getCssValue("color"));
	     
	     WebElement violetbutton= driver.findElement(By.xpath("//button[contains(@class,'violet')]"));
	     System.out.println("The class attribute value is: "+violetbutton.getAttribute("class"));
	     
	     WebElement greybutton= driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/div[2]/div[3]/button[2]"));
	     System.out.println("The greybutton text is: " +greybutton.getText());
	}

}
