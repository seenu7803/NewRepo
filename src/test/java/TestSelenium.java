package JavaSelenium;		

import org.openqa.selenium.By;		
import org.openqa.selenium.WebDriver;		
import org.openqa.selenium.firefox.FirefoxDriver;		
import org.testng.Assert;		
import org.testng.annotations.Test;	
import org.testng.annotations.BeforeTest;	
import org.testng.annotations.AfterTest;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import org.apache.commons.io.FileUtils;

public class TestSelenium {		
	    private WebDriver driver;		
		@Test				
		public void testEasy() {	
			driver.get("http://54.197.163.83:80/demo/");  
			getscreenshot();
			String title = driver.getTitle();			
			System.out.println("Check for Title");
			Assert.assertTrue(title.contains("Hello AWS")); 		
		}	
		@BeforeTest
		public void beforeTest() {
		    //System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
			System.out.println("Sarted");
		    driver = new FirefoxDriver();		    		
		}		
		@AfterTest
		public void afterTest() {
			driver.quit();		
			System.out.println("Stoped");
		}
		
		
		public void getscreenshot() throws Exception 
	      {
	              File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	           //The below method will save the screen shot in d drive with name "screenshot.png"
	              FileUtils.copyFile(scrFile, new File("D:\\screenshot1.jpg"));
	      }
}	
