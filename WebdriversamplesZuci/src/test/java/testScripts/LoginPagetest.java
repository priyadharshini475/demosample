package testScripts;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;




public class LoginPagetest {
	Properties tempProp;
	FileInputStream obtained;
	
    WebDriver driver;
//	@Parameters("browser")
	@BeforeMethod
	public void setUp() throws IOException {
		 tempProp=new Properties();
		 String path=System.getProperty("user.dir")+"//src//test//resources//ConfigFile//config.properties";
		obtained=new FileInputStream(path);
		tempProp.load(obtained);
		obtained.close();
		String browser=tempProp.getProperty("browser");
		String url=tempProp.getProperty("url");
		System.out.println("Browser name..."+browser);
		if(browser.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
			driver.get(url);
	     }
		else if(browser.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
			driver.get(url);
		}
		}
    @Test(dataProvider="loginData")
	public void validLogin(String usrname,String passwrd) {
	    //For different browser version
		WebElement username=driver.findElement(By.xpath("//input[@type='text']"));
		 username.sendKeys(usrname);
	      WebElement password=driver.findElement(By.xpath("//input[@name='password' and @type='password']"));
		 password.sendKeys(passwrd);
		 driver.findElement(By.tagName("button")).click();
	 
		//driver.findElement(By.partialLinkText("Elemental")).click();
		 boolean isUserValid=driver.findElement(By.cssSelector("div.flash.success")).isDisplayed();
		 Assert.assertTrue(isUserValid);
		
 }   
     @DataProvider(name="loginData")
     public Object[][] getData() throws CsvValidationException, IOException{
    	 String path=System.getProperty("user.dir")+"//src//test//resources//testData//loginData.csv";
    	 CSVReader reader=new CSVReader(new FileReader(path));
    	 String cols[];
    	 ArrayList<Object> dataList=new ArrayList<Object>();
    	 while((cols=reader.readNext())!=null){
    		 Object record[]= {cols[0],cols[1]};
    		 dataList.add(record);
    	 }
    	 reader.close();
    	 return dataList.toArray(new Object[dataList.size()][]);
     }
    //@AfterMethod
	 public void end() {
	       driver.close();
 }
    }
