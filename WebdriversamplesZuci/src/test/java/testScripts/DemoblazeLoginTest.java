package testScripts;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Properties;
 import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
 import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.testng.annotations.Test;

public class DemoblazeLoginTest {
	WebDriver driver;
	@BeforeMethod
	public void loginsetup()
	{
		 driver=new ChromeDriver();
	    driver.get("https://www.demoblaze.com/");
        WebElement login=driver.findElement(By.xpath("//a[text()='Log in']"));
		  login.click();
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	@Test(priority=3)
	  public void incrtUsr_incrtpass() throws InterruptedException
	  {
		  
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		  WebElement usrname = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='loginusername']")));
		  usrname.sendKeys("priyadhar");
		  WebElement pswd=driver.findElement(By.xpath("//input[@id='loginpassword']"));
		  pswd.sendKeys("priya12");
		  WebElement loginBtn=driver.findElement(By.xpath("//button[text()='Log in']"));
		  loginBtn.click();
	       wait.until(ExpectedConditions.alertIsPresent());
		  Alert alert=driver.switchTo().alert();
		  Assert.assertEquals(alert.getText(), "User does not exist.");
		  alert.accept();
		
		  
	  }
	@Test(priority=1)
	  public void incorrectUserName() throws InterruptedException
	  {
		  
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		  WebElement usrname = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='loginusername']")));
		  usrname.sendKeys("priyadhar");
		  WebElement pswd=driver.findElement(By.xpath("//input[@id='loginpassword']"));
		  pswd.sendKeys("priya123");
		  WebElement loginBtn=driver.findElement(By.xpath("//button[text()='Log in']"));
		  loginBtn.click();
	       wait.until(ExpectedConditions.alertIsPresent());
		  Alert alert=driver.switchTo().alert();
		  Assert.assertEquals(alert.getText(), "User does not exist.");
		  alert.accept();
		
		  
	  }
	@Test(priority=2)
	  public void incorrectPassword() {
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		  WebElement usrname = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='loginusername']")));
		  usrname.sendKeys("Priyadharshini");
		  WebElement pswd=driver.findElement(By.xpath("//input[@id='loginpassword']"));
		  pswd.sendKeys("priya");
		  WebElement loginBtn=driver.findElement(By.xpath("//button[text()='Log in']"));
		  loginBtn.click();
	      wait.until(ExpectedConditions.alertIsPresent());
		  Alert alert=driver.switchTo().alert();
		  Assert.assertEquals(alert.getText(), "Wrong password.");
		  alert.accept();
	}
	
	@Test(priority=4)
	  
	  public void blankPassword() throws InterruptedException
	  {
		  
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		  WebElement usrname = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='loginusername']")));
		  usrname.sendKeys("Priyadharshini");
		  WebElement loginBtn=driver.findElement(By.xpath("//button[text()='Log in']"));
		  loginBtn.click();
	       wait.until(ExpectedConditions.alertIsPresent());
		  Alert alert=driver.switchTo().alert();
		  Assert.assertEquals(alert.getText(), "Please fill out Username and Password.");
		  alert.accept();
		 }
	@Test(priority=5)
	  public void blankUsername() throws InterruptedException
	  {
		  
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		  WebElement password = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='loginpassword']")));
		  password.sendKeys("priya123");
		  WebElement loginBtn=driver.findElement(By.xpath("//button[text()='Log in']"));
		  loginBtn.click();
	       wait.until(ExpectedConditions.alertIsPresent());
		  Alert alert=driver.switchTo().alert();
		  Assert.assertEquals(alert.getText(), "Please fill out Username and Password.");
		  alert.accept();
		 }
	@Test(priority=6)
	  public void blankUsrname_blankpwdTest() throws InterruptedException
	  {
		  
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		  WebElement usrname = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='loginusername']")));
		  usrname.sendKeys("");
		  WebElement pswd=driver.findElement(By.xpath("//input[@id='loginpassword']"));
		  pswd.sendKeys("");
		  WebElement loginBtn=driver.findElement(By.xpath("//button[text()='Log in']"));
		  loginBtn.click();
	       wait.until(ExpectedConditions.alertIsPresent());
		  Alert alert=driver.switchTo().alert();
		  Assert.assertEquals(alert.getText(), "Please fill out Username and Password.");
		  alert.accept();
		 }
	
	  
	  @AfterMethod
	  public void terminate()
	  {
		  driver.close();
	  }
	  
	  
  
  
  
}
