package testScripts;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SeleniumSearchDemo {
  @Test
  public void search() {
	  WebDriver driver=new ChromeDriver();
	  driver.get("https://demo.seleniumeasy.com/basic-first-form-demo.html");
	  WebElement msgBox=driver.findElement(By.id("user-message"));
	  msgBox.sendKeys("Java");
	  WebElement showbutton=driver.findElement(By.xpath("//div//button[contains(text(),'Show Message')]"));
	  showbutton.click();
	  WebElement a=driver.findElement(By.id("value1"));
	  a.sendKeys("10");
	  WebElement b=driver.findElement(By.id("value2"));
	  b.sendKeys("20");
	  WebElement total=driver.findElement(By.xpath("//div//button[contains(text(),'Get Total')]"));
	  total.click();
  }
}
