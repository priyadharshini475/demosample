package testScripts;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
public class HerokuApp {
  @Test
  public void herokuApp() {
 WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://the-internet.herokuapp.com/iframe");
	  driver.switchTo().frame("mce_0_ifr");
	  driver.findElement(By.tagName("p")).sendKeys("  Hello World");
	  driver.switchTo().defaultContent();
	  driver.findElement(By.linkText("Powered by Tiny")).click();
  }
}
