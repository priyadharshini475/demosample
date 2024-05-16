package testScripts;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class Downloads {
  @Test
  public void downloadfile() throws InterruptedException {
	  ChromeOptions options=new ChromeOptions();
	  Map<String,Object> prefs=new HashMap<>();
	  prefs.put("download.prompt_for_download",false);
	  options.setExperimentalOption("prefs",prefs);
	  WebDriver driver=new ChromeDriver(options);
	  driver.manage().window().maximize();
	  driver.get("https://chromedriver.storage.googleapis.com/index.html?path=79.0.3945.36/");
	  Thread.sleep(2000);
	  WebElement btnDownload=driver.findElement(By.xpath(".//a[text()='chromedriver_win32.zip']"));
	  btnDownload.click();
	  Thread.sleep(7000);
  }}
