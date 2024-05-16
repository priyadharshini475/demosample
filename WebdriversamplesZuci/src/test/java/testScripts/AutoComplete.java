package testScripts;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class AutoComplete {
  @Test
  public void autoComplete() {
	  WebDriver driver=new ChromeDriver();
	  driver.get("https://jqueryui.com/autocomplete/");
	  WebElement frame1=driver.findElement(By.cssSelector(".demo-frame"));
	  driver.switchTo().frame(frame1);
	  WebElement inp=driver.findElement(By.cssSelector("#tags"));
	  inp.sendKeys("as");
	  List<WebElement> items= driver.findElements(By.cssSelector("ul#ui-id-1 > li"));
	  //to know No.Of . matching items
	  System.out.println(items.size());
	  for(WebElement item:items) {
		  System.out.println(item.getText());
	      if(item.getText().equalsIgnoreCase("expValue")) {
		  item.click();
	  }
  }
}}
