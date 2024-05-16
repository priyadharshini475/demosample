package testScripts;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class LoadTimeout {
  @Test
  public void loadTime() {
	  WebDriver d1=new ChromeDriver();
	  d1.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
	  d1.get("http://uitestingplayground.com/");
	  d1.findElement(By.linkText("Load Delay")).click();
	  d1.findElement(By.cssSelector("button.btn.btn-primary")).click();
  }
}
