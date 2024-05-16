package testScripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class GoogleSearchScenarios {
  @Test
  public void javaSearch() throws InterruptedException{
	  WebDriver driver=new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	  driver.get("https://www.google.com/");
	  WebElement srcBox=driver.findElement(By.id("APjFqb"));
	     srcBox.sendKeys("Java Tutorial");
	     srcBox.sendKeys(Keys.ENTER);
	     Assert.assertEquals(driver.getTitle(),"Java Tutorial - Google Search");
  }
  @Test(priority=1)
  public void seleniumSearch() throws InterruptedException {
	  WebDriver driver=new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	  driver.get("https://www.google.com/");
	  WebElement srcBox=driver.findElement(By.id("APjFqb"));
	     srcBox.sendKeys("Selenium Tutorial");
	     srcBox.sendKeys(Keys.ENTER);
	     Assert.assertEquals(driver.getTitle(),"Selenium Tutorial - Google Search");
  }
  @Test(enabled=false)
  public void cucumberSearch() throws InterruptedException{
	  WebDriver driver=new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	  driver.get("https://www.google.com/");
	  WebElement srcBox=driver.findElement(By.id("APjFqb"));
	     srcBox.sendKeys("Cucumber Tutorial");
	     srcBox.sendKeys(Keys.ENTER);
	     Assert.assertEquals(driver.getTitle(),"Cucumber Tutorial - Google Search");
  }
}
