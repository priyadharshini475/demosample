package testScripts;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.HashMap;
import java.util.Map;

public class HideImage {
  @Test
  public void hideImage() {
	  ChromeOptions options=new ChromeOptions();
	  //this will disable the image loading methods
	  options.addArguments("--blink-settings=imagesEnabled=false");//true image is shown
	  
	  //or alternative method to disable the method
	  Map<String,Object> prefs=new HashMap<>();
	  prefs.put("profile.managed_default_content_settings.images",2);
	  options.setExperimentalOption("prefs", prefs);
	  WebDriver driver=new ChromeDriver(options);
	  driver.get("https://demo.opencart.com/");
	  
  }
}
