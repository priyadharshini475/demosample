package testScripts;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class JQuery {
  @Test
  public void jQuery() throws InterruptedException {
	  WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/jqueryui/menu");
		driver.findElement(By.xpath("//a[text()='Enabled']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='Downloads']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='CSV']")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Elemental Selenium")).click();
  }
}
