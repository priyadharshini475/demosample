package testScripts;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomationBooks {
  @Test
  public void SearchMessage() throws InterruptedException {
	  WebDriver driver = new ChromeDriver();
	  driver.get("https://automationbookstore.dev/");
	  WebElement textBox = driver.findElement(By.id("searchBar"));
	//  textBox.sendKeys("Agile Testing");
	   Thread.sleep(1000);
	  WebElement hiddenIcon = driver.findElement(By.linkText("Clear text"));
	  if(hiddenIcon.isDisplayed()){
		  hiddenIcon.click();
		  System.out.println("Text Cleared");
	  }
	  else {
		  System.out.println("Clear Icon Hidden");
	  }
  }}
