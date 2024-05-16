package testScripts;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsHandle {
  @Test
  public void windowHand() {
	  WebDriver driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://stqatools.com/demo/Windows.php");
	  String parentwin=driver.getWindowHandle();
	  driver.findElement(By.xpath("//button[contains(text(),'new Tab')]")).click();
	  Set<String> tabs=driver.getWindowHandles();
	  for(String childWin:tabs) {
		  System.out.println(childWin);
		  if(!childWin.equalsIgnoreCase(parentwin)) {
			  driver.switchTo().window(childWin);
			  driver.findElement(By.xpath("//a[contains(text(),'Java')]")).click();
		  }
	  }//
//	  Navigate to parent window and do other actions
	  driver.close();
	  driver.switchTo().window(parentwin);
	  driver.findElement(By.xpath("//button[contains(text(),'new Window')]")).click();
	  //To handle window in new browser
	  Set<String> tab=driver.getWindowHandles();
	  for(String childWin:tab) {
		  System.out.println(childWin);
		  if(!childWin.equalsIgnoreCase(parentwin)) {
			  driver.switchTo().window(childWin);
		  }
	  }  
	  driver.quit();// It quit all the windows for the current driver
  }
}
