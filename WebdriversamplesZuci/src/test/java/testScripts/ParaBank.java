package testScripts;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ParaBank {
	WebDriver driver;
  
  @BeforeClass
  public void setup() {
  		 driver=new ChromeDriver();
  	    driver.manage().window().maximize();
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
  }
  @Test(priority=1)
  public void loginPage() throws InterruptedException {
	 
	  driver.findElement(By.xpath("//input[@name='username']")).sendKeys("aaaa");
	  driver.findElement(By.xpath("//input[@type='password']")).sendKeys("bbbb");
	  driver.findElement(By.xpath("//input[@value='Log In']")).click();
	  Assert.assertEquals(driver.getTitle(),"ParaBank | Accounts Overview" );
  }
  @Test(priority=2)
    public void newAccount() throws InterruptedException {
	  driver.findElement(By.xpath("//a[contains(text(),'Open New Account')]")).click();
	  driver.findElement(By.xpath("//option[contains(text(),'CHECKING')]")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//option[contains(text(),'18228')]")).click();
	  Thread.sleep(1000);
	 driver.findElement(By.xpath("//input[@type='submit' and @class='button']")).click();
	 boolean val=driver.findElement(By.xpath("//h1")).isDisplayed();
	 Assert.assertTrue(val);
  }
  @Test(priority=3)
  public void transfer() throws InterruptedException {
     driver.findElement(By.xpath("//a[contains(text(),'Transfer Funds')]")).click();
     Thread.sleep(1000);
  //   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(200));
	 driver.findElement(By.xpath("//input[@id='amount']")).sendKeys("400");
	 Select fromacc=new Select(driver.findElement(By.id("fromAccountId")));
	  fromacc.selectByValue("18228");
	  Select toacc=new Select(driver.findElement(By.id("toAccountId")));
	  toacc.selectByValue("18228");
	 driver.findElement(By.xpath("//input[@type='submit' and @value='Transfer']")).click();
	 Thread.sleep(1000);
	 boolean value1=driver.findElement(By.xpath("//h1")).isDisplayed();
	 Assert.assertTrue(value1);
  }
  @Test(priority=4)
   public void accountOverview() throws InterruptedException {
	driver.findElement(By.xpath("//a[contains(text(),'Accounts Overview')]")).click();
	 Thread.sleep(1000);
	 boolean transcheck=driver.findElement(By.xpath("//a[contains(text(),'18228')]")).isDisplayed();
	 Assert.assertTrue(transcheck);
  }
}
