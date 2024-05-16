package parallelScripts;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SampleTwoTest {
	 WebDriver driver;
	 public void testOne1() {
		  driver=new ChromeDriver();
		  long id=Thread.currentThread().getId();
		  System.out.println("Test 1 in sampletwo..."+id);
	  }
	  @Test
	  public void testTwo2() {
		  driver=new ChromeDriver();
		  long id=Thread.currentThread().getId();
		  System.out.println("Test 2 in sampletwo..."+id);
	  }
	  @Test
	  public void testThree3() {
		  driver=new ChromeDriver();
		  long id=Thread.currentThread().getId();
		  System.out.println("Test 3 in sampletwo..."+id);
	  }
	  @Test
	  public void testFour4() {
		  driver=new ChromeDriver();
		  long id=Thread.currentThread().getId();
		  System.out.println("Test 4 in sampletwo..."+id);
	  }
 
}
