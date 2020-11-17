package selenium_session1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity_2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new FirefoxDriver();
		
		driver.get("https://www.training-support.net");
		Thread.sleep(5000);
			
		System.out.println("Title of the page is " +driver.getTitle());
		
		//WebElement idelement=driver.findElement(By.id("about-link"));
		//WebElement classelement=driver.findElement(By.className("green"));
		//WebElement linkelement=driver.findElement(By.linkText("About Us"));
		//WebElement csselement=driver.findElement(By.cssSelector(".green"));
		
		//System.out.println("Text in the element is: " +idelement.getText());
		//System.out.println("Text in the element is: " +classelement.getText());
		//System.out.println("Text in the element is: " +linkelement.getText());
		//System.out.println("Text in the element is: " +csselement.getText());
        
		//Find the About Us link using id()
		
        WebElement idLocator = driver.findElement(By.id("about-link"));
	
        System.out.println("Text in element: " + idLocator.getText());
	
        
	
        //Find the About Us link using className()
	
        WebElement classNameLocator = driver.findElement(By.className("green"));
	
        System.out.println("Text in element: " + classNameLocator.getText());
	
        
	
        //Find the About Us link using cssSelector()
	
        WebElement cssLocator = driver.findElement(By.cssSelector(".green"));
	
        System.out.println("Text in element: " + cssLocator.getText());
	
        
	
        //Find the About Us link using linkText()
	
        WebElement linkTextLocator = driver.findElement(By.linkText("About Us"));
	
        System.out.println("Text in element: " + linkTextLocator.getText());
	
        
		
		driver.close();
		

	}

}
