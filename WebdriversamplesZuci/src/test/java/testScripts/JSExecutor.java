package testScripts;

import org.testng.annotations.Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class JSExecutor {
  @Test
  public void jsExecutor() {
	  WebDriver driver=new ChromeDriver();
	  driver.manage().deleteAllCookies();
	  driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
	  driver.manage().window().maximize();
	  driver.get("https://demo.opencart.com/");
	  JavascriptExecutor js=(JavascriptExecutor)driver;
	  String strTitle=(String)js.executeScript("return document.title");
	  System.out.println(strTitle);
	  WebElement searchBox=(WebElement)js.executeScript("return document.getElementsByName('search')[0]");//It will always return as a array
	  searchBox.sendKeys("Phone");
	  driver.findElement(By.cssSelector("button.btn.btn-light.btn-lg")).click();
	  js.executeScript("history.go(-1)");
	  js.executeScript("window.scrollBy(10,700)");
	  js.executeScript("window.scrollBy(10,document.body.scrollHeight)");
	  
  }
}
