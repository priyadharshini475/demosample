package testScripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class GoogleSearchTest {
  @Test
  public void searchJavaTest() throws InterruptedException {
	 // ChromeOptions options=new ChromeOptions();    //For different browser version
	//	options.setBrowserVersion("115");
	//	WebDriver driver=new ChromeDriver(options);
	    WebDriver driver=new ChromeDriver();
		 driver.navigate().to("https://www.google.com/");
	     WebElement srcBox=driver.findElement(By.id("APjFqb"));
	     srcBox.sendKeys("Java Tutorial");
	    /* srcBox.sendKeys(Keys.ENTER);
	     System.out.println("Before click back.. Page title is..."+driver.getTitle());
	     driver.navigate().back();
	     System.out.println("After click... Page title is..."+driver.getTitle());
	     driver.navigate().forward();
	     System.out.println("After forward again..."+driver.getTitle());
	     System.out.println("The URL of teh page is..."+driver.getCurrentUrl());*/
	     Thread.sleep(1000);
	     List<WebElement> items=driver.findElements(By.xpath("(//ul[@class='G43f7e'])[1]//li//descendant::div[@class='wM6W7d']"));
	    System.out.println("No.of items..."+items.size());
	     for(WebElement item:items) {
	    	 System.out.println(item.getText());
	    	 if(item.getText().equalsIgnoreCase("java tutorial pdf"))
	    		   item.click();
	    	       break;
	    	       
	     }
	     
	  
	  
  }
}
