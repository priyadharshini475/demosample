package testScripts;

import org.testng.annotations.Test;

import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class FileUpload {
  @Test
  public void file() {
	  WebDriver driver=new ChromeDriver();
	  driver.get("https://blueimp.github.io/jQuery-File-Upload/");
	  WebElement addFile=driver.findElement(By.xpath("//input[@type='file']"));
	  String strPath=System.getProperty("user.dir")+"//1706690658899 .png";
	  addFile.sendKeys(strPath);
	  driver.findElement(By.xpath("//span[text()='Start upload']")).click();
  }
}
