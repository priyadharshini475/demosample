package testScripts;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class ParaBank1 {
	WebDriver driver;
	  @BeforeClass
	  public void setup() throws Exception {
		  driver=new ChromeDriver();
		  driver.get("https://parabank.parasoft.com/parabank/register.htm");
	  }
	@Test(priority=1)
		 public void login() throws InterruptedException
		 {
			 WebElement usrname=driver.findElement(By.xpath("//input[@name='username']"));
			  usrname.sendKeys("priya");
			  WebElement pswd=driver.findElement(By.xpath("//input[@name='password']"));
			  pswd.sendKeys("priya");
			  WebElement loginBtn=driver.findElement(By.xpath("//input[@class='button']"));
			  loginBtn.click();
			  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			  //Thread.sleep(1000);
			 Assert.assertEquals(driver.getTitle(),"ParaBank | Accounts Overview" );
		 }
	  @Test(priority=2)
	  public void openAccount() throws InterruptedException {
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		  WebElement openAcc = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Open New Account']")));
	      openAcc.click();
//		  WebElement openAcc=driver.findElement(By.xpath("//a[text()='Open New Account']"));
//		  openAcc.click();
		  Select acctype=new Select(driver.findElement(By.id("type")));
		  acctype.selectByVisibleText("CHECKING");
		  //Thread.sleep(1000);
	      wait.until(ExpectedConditions.elementToBeClickable(By.id("fromAccountId")));
		  Select accNo=new Select(driver.findElement(By.id("fromAccountId")));
		  accNo.selectByValue("18117");
		  WebElement openAccBtn=driver.findElement(By.xpath("//input[@value='Open New Account']"));
		  openAccBtn.click();
	    boolean isValid=driver.findElement(By.xpath("//div[@class='ng-scope']//p[1]")).isDisplayed();
	   	AssertJUnit.assertTrue(isValid);
	    boolean isValid2=driver.findElement(By.xpath("//div[@class='ng-scope']//p[2]")).isDisplayed();
	   	AssertJUnit.assertTrue(isValid2);
	  }
	  @Test(priority=3)
	   	public void transferFunds() throws InterruptedException {
	   	WebElement transferFunds=driver.findElement(By.xpath("//a[text()='Transfer Funds']"));
		  transferFunds.click();
		 Thread.sleep(1000);
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		  WebElement amount=driver.findElement(By.xpath("//input[@id='amount']"));
		  amount.sendKeys("500");
		//  wait.until(ExpectedConditions.elementToBeClickable(By.id("fromAccountId")));
		  wait.until(ExpectedConditions
			         .presenceOfNestedElementsLocatedBy
			         (By.xpath("//select[@id='fromAccountId']"), By.tagName("option")));
		  Select faccNo=new Select(driver.findElement(By.id("fromAccountId")));
		  faccNo.selectByValue("18117");
		  Select taccNo=new Select(driver.findElement(By.id("toAccountId")));
		  taccNo.selectByValue("18117");
		  WebElement transferBtn=driver.findElement(By.xpath("//input[@value='Transfer']"));
		  transferBtn.click();
		 // Thread.sleep(1000);
		  wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//h1[text()='Transfer Complete!']"), "Transfer Complete!"));
		  boolean isValid3=driver.findElement(By.xpath("//h1[text()='Transfer Complete!']")).isDisplayed();
	      AssertJUnit.assertTrue(isValid3);
	   	}
	  @Test(priority=3)
	   	public void accOverview() throws InterruptedException {
	     	WebElement accOverview=driver.findElement(By.xpath("//a[text()='Accounts Overview']"));
	  	  accOverview.click();
	  	Thread.sleep(1000);
//	  	 boolean isValid4=driver.findElement(By.xpath("//a[text()='19560']")).isDisplayed();
//	     AssertJUnit.assertTrue(isValid4);
	   	}
  
  }

