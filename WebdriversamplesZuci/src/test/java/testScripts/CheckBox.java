package testScripts;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
public class CheckBox {
  @Test
  public void checkRadioButton() {
	  WebDriver d1=new ChromeDriver();
	  //checkbox
	  d1.get("https://demo.seleniumeasy.com/basic-checkbox-demo.html");
	  WebElement age=d1.findElement(By.id("isAgeSelected"));
	  if(!age.isSelected()) {
		  age.click();
	  }
	  d1.findElement(By.xpath("(//input[@class='cb1-element'])[2]")).click();
	 //Radio button
	  d1.get("https://demo.seleniumeasy.com/basic-radiobutton-demo.html");
	  d1.findElement(By.xpath("//input[@value='5 - 15']")).click();
	  //Dropdown
	  d1.get("https://demo.seleniumeasy.com/basic-select-dropdown-demo.html");
	  Select singSel=new Select(d1.findElement(By.id("select-demo")));
	  singSel.selectByValue("Tuesday");
	  Select mulSel=new Select(d1.findElement(By.id("multi-select")));
	  if(mulSel.isMultiple()) {
		  mulSel.selectByIndex(0);
		  mulSel.selectByValue("Florida");
		  mulSel.deselectByVisibleText("Washington");
	  }
	  List<WebElement> items=mulSel.getAllSelectedOptions();
	  System.out.println("Items selected: "+items.size());
	  for(WebElement elem:items)
	  {
		  System.out.println(elem.getText());
	  }
	  mulSel.deselectByValue("Florida");
	  
  }
}