package testScripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
public class WebTableTest {
  @Test
  public void searchEmpDetails() {
	  WebDriver driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://demo.seleniumeasy.com/table-sort-search-demo.html");
	  List<WebElement> items= driver.findElements(By.xpath("//td[text()='B. Wagner']//following-sibling::td"));
	  System.out.println("Number of Items: "+items.size());
	  for(WebElement e:items) {
		  System.out.println(e.getText());
	  }
	  // Salary of Wagner
	   String sal=driver.findElement(By.xpath("//td[text()='B. Wagner']//following::td[5]")).getText();
	   System.out.println(sal);
	   List<WebElement> item=driver.findElements(By.xpath("//td[contains(text(),'San Francisco')]//preceding-sibling::td[2]"));
	   for(WebElement name:item) {
		   System.out.println(name.getText());
	   }
	   String strLocation=driver.findElement(By.xpath("//td[text()='Wagner']//following-sibling::td][2]")).getText();
	   System.out.println(strLocation);
  }
}
