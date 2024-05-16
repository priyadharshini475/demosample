package testScripts;
 
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Properties;
 
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
 
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class Demoblaze1 {
	WebDriver driver;
	@BeforeClass
	public void login() throws IOException, InterruptedException
	{
		 Properties tempProp = new Properties();
			String path=System.getProperty("user.dir")+"//src//test//resources//ConfigFile//demoblaze_login.properties";
			FileInputStream fin = new FileInputStream(path);
			tempProp.load(fin);
		  driver=new ChromeDriver();
		  driver.get("https://www.demoblaze.com/");
		  WebElement login=driver.findElement(By.xpath("//a[text()='Log in']"));
		  login.click();
		  String uname = tempProp.getProperty("username");
		  System.out.println(uname);
	      String password = tempProp.getProperty("password");
	      Thread.sleep(1000);
	     // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		  WebElement usrname=driver.findElement(By.xpath("//input[@id='loginusername']"));
		  usrname.sendKeys(uname);
		  WebElement pswd=driver.findElement(By.xpath("//input[@id='loginpassword']"));
		  pswd.sendKeys(password);
		  WebElement loginBtn=driver.findElement(By.xpath("//button[text()='Log in']"));
		  loginBtn.click();
		  
	}
	@DataProvider(name="itemData")
	public Object[] getData() throws CsvValidationException, IOException
	{
		 String path=System.getProperty("user.dir")+"//src//test//resources//testData//demoblaze_items.csv";
		 CSVReader reader=new CSVReader(new FileReader(path));
		 String row[];
		 ArrayList<Object> itemList=new ArrayList<Object>();
		 while((row=reader.readNext())!=null) {
			 String item_name=row[0];
			 itemList.add(item_name);
		 }
		 return itemList.toArray(new Object[itemList.size()]);
	}


 
  @Test(dataProvider="itemData")
  public void addItem(String itemname) throws Exception {
	  driver.navigate().refresh();
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      WebElement itemLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'" + itemname + "')]")));
      itemLink.click();
      Thread.sleep(2000);
      
	  WebElement cart=driver.findElement(By.xpath("//a[text()='Add to cart']"));
	  cart.click();
	  Thread.sleep(3000);
	  Alert alert=driver.switchTo().alert();
	  Assert.assertEquals(alert.getText(), "Product added");
	  alert.accept();
	  driver.navigate().refresh();
      WebElement hp = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='navbarExample']//a[text()='Home ']")));
      hp.click();

  }
  

 
}
