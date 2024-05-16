package testScripts;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Form {
  @Test
  public void form() throws InterruptedException {
	  WebDriver driver=new ChromeDriver();
	  driver.get("https://demoqa.com/automation-practice-form");
	  WebElement firstName=driver.findElement(By.xpath("//input[@id='firstName']"));
	  firstName.sendKeys("Priya");
	  WebElement lastName=driver.findElement(By.id("lastName"));
	  lastName.sendKeys("dharshini");
	  WebElement email=driver.findElement(By.id("userEmail"));
	  email.sendKeys("priya@gmail.com");
      WebElement gender=driver.findElement(By.xpath("//label[text()='Female']"));
	  gender.click();
	//  WebElement gender = driver.findElement(By.xpath("(//label[@class=\"custom-control-label\"])[1]"));
	//  gender.click();
	// WebDriverWait wait1=new WebDriverWait(driver,Duration.ofSeconds(20));*/
	 WebElement number=driver.findElement(By.id("userNumber"));
	  number.sendKeys("9788593738");
	  JavascriptExecutor js=(JavascriptExecutor)driver;
	  WebElement date=(WebElement)js.executeScript("return document.getElementById('dateOfBirthInput').value='01 Mar 2024'");
	  date.click();		
     
	 /* WebElement textArea=driver.findElement(By.xpath("//input[@id='subjectsInput']"));
	  textArea.sendKeys("This is the form");
	//  Thread.sleep(1000);
	  WebElement sports=driver.findElement(By.xpath("//label[text()='Sports']"));
	  sports.click();
	  WebElement addFile=driver.findElement(By.id("uploadPicture"));
	  String strPath=System.getProperty("user.dir")+"//1706690658899 .png";
	  addFile.sendKeys(strPath);
	  WebElement curAddress=driver.findElement(By.id("currentAddress"));
	  curAddress.sendKeys("abcdefgh");
	 /* Select stateSelect=new Select(driver.findElement(By.cssSelector(".css-19bqh2r")));
	  stateSelect.selectByVisibleText("Uttar Pradesh");
	  Select citySelect=new Select(driver.findElement(By.xpath("//*[@id=\"city\"]/div/div[2]/div/svg")));//
	  citySelect.selectByVisibleText("Agra");
	  driver.findElement(By.id("submit")).click();*/
  }
}
