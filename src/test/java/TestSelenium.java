package JavaSelenium;		

import org.openqa.selenium.By;		
import org.openqa.selenium.WebDriver;		
import org.openqa.selenium.firefox.FirefoxDriver;		
import org.testng.Assert;		
import org.testng.annotations.Test;	
import org.testng.annotations.BeforeTest;	
import org.testng.annotations.AfterTest;	

public class TestSelenium {		
	    private WebDriver driver;		
		@Test				
		public void testEasy() {	
			driver.get("http://54.197.163.83:80/demo/");  
			String title = driver.getTitle();				 
			Assert.assertTrue(title.contains("Hello AWS")); 		
		}	
		@BeforeTest
		public void beforeTest() {
		    //System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		    driver = new FirefoxDriver();  
		}		
		@AfterTest
		public void afterTest() {
			driver.quit();			
		}		
}	
