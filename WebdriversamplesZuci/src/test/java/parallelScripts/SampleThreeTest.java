package parallelScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SampleThreeTest {
	WebDriver driver;
	 public void testOne11() {
		  driver=new ChromeDriver();
		  long id=Thread.currentThread().getId();
		  System.out.println("Test 1 in samplethree..."+id);
	  }
	  @Test
	  public void testTwo22() {
		  driver=new ChromeDriver();
		  long id=Thread.currentThread().getId();
		  System.out.println("Test 2 in samplethree..."+id);
	  }
	  @Test
	  public void testThree33() {
		  driver=new ChromeDriver();
		  long id=Thread.currentThread().getId();
		  System.out.println("Test 3 in samplethree..."+id);
	  }
	  @Test
	  public void testFour4() {
		  driver=new ChromeDriver();
		  long id=Thread.currentThread().getId();
		  System.out.println("Test 4 in sampletwo..."+id);
	  }
  
}
