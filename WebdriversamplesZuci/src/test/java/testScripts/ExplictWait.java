package testScripts;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class ExplictWait {
  @Test
  public void explicitWait() {
	  WebDriver driver=new ChromeDriver();
	  driver.get("http://uitestingplayground.com/ajax");
	  WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
	  driver.findElement(By.id("ajaxButton")).click();
	  wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.cssSelector("div#content")),"Data loaded with AJAX get request."));
	  String strTxt=driver.findElement(By.cssSelector("div#content")).getText();
	  System.out.println(strTxt);
	  		
	  
	  
  }
}
