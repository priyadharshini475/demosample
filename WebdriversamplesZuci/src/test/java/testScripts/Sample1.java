package testScripts;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;

import commonUtils.Utility;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Sample1 {
	WebDriver driver;
	ExtentReports extentReports;
	ExtentSparkReporter spark;
	ExtentTest extentTest;
	@BeforeTest
	public void setupExtent() {
		extentReports=new ExtentReports();
		spark=new ExtentSparkReporter("test-output/Sparkreport.html")
				   .viewConfigurer()
				   .viewOrder()
				   .as(new ViewName[] {
						 ViewName.DASHBOARD,
						 ViewName.TEST,
						 ViewName.AUTHOR,
						 ViewName.DEVICE,
						 ViewName.LOG
				   }).apply();
	    extentReports.attachReporter(spark);
	}
	
	@BeforeMethod
	//@BeforeTest
	public void setup() {
		 driver=new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
 // @Test(alwaysRun=true,dependsOnMethods = "seleniumSearch")
	@Test(retryAnalyzer=RetryAnalyzer.class)
  public void javaSearch() throws InterruptedException{
	  extentTest=extentReports.createTest("Java Search Test");
	  driver.get("https://www.google.com/");
	  WebElement srcBox=driver.findElement(By.id("APjFqb"));
	     srcBox.sendKeys("Java Tutorial");
	     srcBox.sendKeys(Keys.ENTER);
	     Assert.assertEquals(driver.getTitle(),"Java Tutorial - Google Search");
	     
  }
  @Test
  public void seleniumSearch() throws InterruptedException {
	  extentTest=extentReports.createTest("Selenium Search Test");
	  driver.get("https://www.google.com/");
	  WebElement srcBox=driver.findElement(By.id("APjFqb"));
	     srcBox.sendKeys("Selenium Tutorial");
	     srcBox.sendKeys(Keys.ENTER);
	     Assert.assertEquals(driver.getTitle(),"Selenium Tutoria - Google Search");
	  System.out.println("Selenium-Selenium");
	     
  }
 // @Test
  public void assertSearchMethod() throws InterruptedException{
	  driver.get("https://www.google.com/");
	  SoftAssert softAssert=new SoftAssert();
	  softAssert.assertEquals(driver.getTitle(),"Google Page");// Google is title
	  WebElement srcBox=driver.findElement(By.id("APjFqb"));
	     srcBox.sendKeys("Java Tutorial");
	     srcBox.sendKeys(Keys.ENTER);
	     Assert.assertEquals(driver.getTitle(),"Java Tutorial - Google Search");
	     softAssert.assertAll();// It will validate the no.of.testcases pass using all the test we done in the same method          // Anyone testcase fail it returns Failure:1
  }
  @AfterMethod
  public void teardown(ITestResult result) {
	  extentTest.assignAuthor("AutomationTester1")
	  .assignCategory("Regression")
	  .assignDevice(System.getProperty("os.name"))
	  .assignDevice(System.getProperty("os.version"));
	  
	  if(ITestResult.FAILURE==result.getStatus()) {
		  extentTest.log(Status.FAIL,result.getThrowable().getMessage());
		  String strPath=Utility.getScreenshotPath(driver);
		  
		  extentTest.fail(MediaEntityBuilder.createScreenCaptureFromPath(strPath).build());
	  }
	  else if(ITestResult.SKIP==result.getStatus()) {
		  extentTest.log(Status.SKIP,result.getThrowable().getMessage());
	  }
	  driver.close();
  }
 // @AfterMethod
   //@AfterTest
   public void end() {
	   driver.close();
  }
  @AfterTest
   public void finishExtent() {
	  extentReports.flush();
  }
}
