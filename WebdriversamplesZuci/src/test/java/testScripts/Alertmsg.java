package testScripts;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class Alertmsg {
  @Test
  public void sampleAlert() {
	  WebDriver driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://demo.seleniumeasy.com/javascript-alert-box-demo.html");
	  driver.findElement(By.xpath("(//button[contains(text(),'Click me!')])[1]")).click();
	  Alert alert=driver.switchTo().alert();
	  Assert.assertEquals(alert.getText(),"I am an alert box!");
	  alert.accept();
	  //Handling confirmation alert
	  driver.findElement(By.xpath("//button[contains(text(),'Prompt')]")).click();
	  Alert prompt=driver.switchTo().alert();
	  System.out.println("Alert Text : "+prompt.getText());
	  prompt.sendKeys("Hello Welcome");
	  prompt.accept();
	  //prompt.dismiss();
	  
  }
}
