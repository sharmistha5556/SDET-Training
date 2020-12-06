package appium_session1;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class activity2_2 {
    // Instantiate Appium Driver
	AppiumDriver<MobileElement> driver = null;
	
  @Test
  public void Sum() {
	  driver.findElementById("com.android.calculator2:id/digit_5").click();
	  driver.findElementById("com.android.calculator2:id/op_add").click();
	  driver.findElementById("com.android.calculator2:id/digit_9").click();
	  driver.findElementById("com.android.calculator2:id/eq").click();
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  String Sum=driver.findElementById("com.android.calculator2:id/result").getText();
	  System.out.println("Sum of 2 numbers, 5 and 9 is: " + Sum);
	  Assert.assertEquals(Sum, "14");
	  driver.findElementById("com.android.calculator2:id/clr").click();
	  
  }
  
  @Test
  public void Subtract() {
	  driver.findElementById("com.android.calculator2:id/digit_1").click();
	  driver.findElementById("com.android.calculator2:id/digit_0").click();
	  driver.findElementById("com.android.calculator2:id/op_sub").click();
	  driver.findElementById("com.android.calculator2:id/digit_5").click();
	  driver.findElementById("com.android.calculator2:id/eq").click();
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  String Sub=driver.findElementById("com.android.calculator2:id/result").getText();
	  System.out.println("Sub of 2 numbers, 10 and 5 is: " + Sub);
	  Assert.assertEquals(Sub, "5");
	  driver.findElementById("com.android.calculator2:id/clr").click();
	  
  }
  
  @Test
  public void Multiply() {
	  driver.findElementById("com.android.calculator2:id/digit_5").click();
	  driver.findElementById("com.android.calculator2:id/op_mul").click();
	  driver.findElementById("com.android.calculator2:id/digit_1").click();
	  driver.findElementById("com.android.calculator2:id/digit_0").click();
	  driver.findElementById("com.android.calculator2:id/digit_0").click();
	  driver.findElementById("com.android.calculator2:id/eq").click();
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  String Mul=driver.findElementById("com.android.calculator2:id/result").getText();
	  System.out.println("Sum of 2 numbers, 5 and 100 is: " + Mul);
	  Assert.assertEquals(Mul, "500");
	  driver.findElementById("com.android.calculator2:id/clr").click();
	  
  }
  
  @Test
  public void Divide() {
	  driver.findElementById("com.android.calculator2:id/digit_5").click();
	  driver.findElementById("com.android.calculator2:id/digit_0").click();
	  driver.findElementById("com.android.calculator2:id/op_div").click();
	  driver.findElementById("com.android.calculator2:id/digit_2").click();
	  driver.findElementById("com.android.calculator2:id/eq").click();
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  String Div=driver.findElementById("com.android.calculator2:id/result").getText();
	  System.out.println("Sum of 2 numbers, 50 and 2 is: " + Div);
	  Assert.assertEquals(Div, "25");
	  driver.findElementById("com.android.calculator2:id/clr").click();
	  
  }
  @BeforeClass
	  public void setUp() throws InterruptedException, IOException {
			
	        // Set the Desired Capabilities
		
	        DesiredCapabilities caps = new DesiredCapabilities();
		
	        caps.setCapability("deviceName", "LatestPhoneAVD");
		
	        caps.setCapability("platformName", "android");
		
	        caps.setCapability("appPackage", "com.android.calculator2");
		
	        caps.setCapability("appActivity", "com.android.calculator2.Calculator");
		
	        try {
		
	            // Initialize driver
		
	            driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		
	            System.out.println("Calculator is open");
		
	        } catch (MalformedURLException e) {
		
	            System.out.println(e.getMessage());
		
	        }
		
	    }
  

  @AfterClass
  public void tearDown() {
	  driver.quit();
  }

}
