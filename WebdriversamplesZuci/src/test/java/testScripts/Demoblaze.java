package testScripts;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
public class Demoblaze {
	WebDriver driver;
	  String username;
	  String password;
	  String item;
	  
	  @BeforeMethod
	  public void login() throws IOException, InterruptedException{
		driver=new ChromeDriver();
		 driver.manage().window().maximize();
		driver.get("https://www.demoblaze.com/index.html");
		Properties temp=new Properties();
		 String path=System.getProperty("user.dir")+"//src//test//resources//ConfigFile//demoblaze_login.properties";
	     FileInputStream inputfile=new FileInputStream(path);
	     temp.load(inputfile);
	     inputfile.close();
	     username=temp.getProperty("username");
	     password=temp.getProperty("password");
	     item=temp.getProperty("item");
	     driver.findElement(By.xpath("//a[contains(text(),'Log in')]")).click();
	     Thread.sleep(1000);
	     driver.findElement(By.id("loginusername")).sendKeys(username);
	     driver.findElement(By.id("loginpassword")).sendKeys(password);
	     driver.findElement(By.xpath("//button[@onclick='logIn()']")).click();
	     Thread.sleep(1000);
	     String itempath = String.format("//a[contains(text(), '%s')]",item);
	     driver.findElement(By.xpath(itempath)).click();
	}

@Test(dataProvider="itemslist")
public void addToCart(String itemname) throws InterruptedException {
	//   Thread.sleep(1000);
	  String itempath = String.format("//a[contains(text(), '%s')]",itemname);
	  driver.findElement(By.xpath(itempath)).click();
	 //   Thread.sleep(1000);
	   driver.findElement(By.xpath("//a[contains(text(),'Add to cart')]")).click();
	  //  Thread.sleep(3000);
	    Alert alert=driver.switchTo().alert();
		 Assert.assertEquals(alert.getText(), "Product added");
		 alert.accept();
		/* driver.navigate().refresh();
		 driver.navigate().refresh();
	      WebElement hp=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='navbarExample']//a[text()='Home ']")));
	      hp.click();*/
	
	    }
@DataProvider(name="itemslist")
   public Object[] getItems() throws CsvValidationException, IOException {
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
@Test
public void displayCart() throws InterruptedException {
	// Thread.sleep(1000);
	 driver.findElement(By.xpath("//a[text()='Cart']")).click();
	
}
	  
	  
  
}
