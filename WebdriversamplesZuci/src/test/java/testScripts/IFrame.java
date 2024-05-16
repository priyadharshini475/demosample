package testScripts;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
public class IFrame {
  @Test
  public void iFrame() {
	  WebDriver driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
	  //From mainPage to frame1
	  driver.switchTo().frame("frame1");
	  WebElement inpBox=driver.findElement(By.xpath("//input[@type='text']"));
	  inpBox.sendKeys("Hello Welcome");
	  //from frame1 to frame3
	  driver.switchTo().frame("frame3");
	  WebElement clickBox=driver.findElement(By.xpath("//input[@id='a']"));
	  clickBox.click();
	  driver.switchTo().parentFrame();
	  driver.switchTo().defaultContent();
	  driver.switchTo().frame("frame2");
	  Select singSel=new Select(driver.findElement(By.cssSelector(".col-lg-3")));
	 // WebElement drop=driver.findElement(By.cssSelector(".col-lg-3"));
	  singSel.selectByValue("babycat");
      WebElement selectedOption = singSel.getFirstSelectedOption();
	  String selectedText = selectedOption.getText();
      System.out.println("Selected Option: " + selectedText);
  }
}
