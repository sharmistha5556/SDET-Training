package stepDefinitions;

import io.cucumber.java.en.And;

public class CloseBrowser extends OpenBrowser{
	@And ("^Close the Browser$")
	
		public void closeBrowser() {
		//close the driver
			//driver.close();
			driver.quit();
	
	}
	
}
