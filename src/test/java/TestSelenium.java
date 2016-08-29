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


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class TestSelenium {		
	    private WebDriver driver;	
	    private ExtentReports extent;
	    ExtentTest logger;
	    
		@Test				
		public void testEasy() {	
			try{
			driver.get("http://54.197.163.83:80/demo/");  
						
			logger.log(LogStatus.INFO, "Snapshot below: " + logger.addScreenCapture(GetScreenShot("D:\\screenshot1.jpg")));
			
			 String title = driver.getTitle();
			 logger.log(LogStatus.PASS, "Check for Title");
			 Assert.assertTrue(title.contains("Hello AWS"));
			 logger.log(LogStatus.PASS, "Title verified");
			 
			}
			catch(Exception ex)
			{ 
				System.out.println(ex);
				logger.log(LogStatus.FAIL, "Testcase Failed");
			}
		}	
		@BeforeTest
		public void beforeTest() {
		    //System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
			extent = new ExtentReports("D:\\Java\\JavaSeleniumReport.html", true);
			logger=extent.startTest("Verify App Title");
			
			System.out.println("Sarted");
		    driver = new FirefoxDriver();
		    driver.manage().window().maximize();
		    logger.log(LogStatus.INFO, "Browser started ");
		}		
		@AfterTest
		public void afterTest() {
			driver.quit();
			extent.endTest(logger);
			extent.flush();
			System.out.println("Stoped");
		}
		
		
		public string  GetScreenShot(string imgPath) throws Exception 
	      {
	              File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	           //The below method will save the screen shot in d drive with name "screenshot.png"
	              FileUtils.copyFile(scrFile, new File(imgPath));
	              return imgPath;
	      }
}	
