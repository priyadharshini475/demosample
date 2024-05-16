package parallelScripts;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;

public class SampleOneTest {
	WebDriver driver;
  @Test
  public void testOne() {
	  driver=new ChromeDriver();
	  long id=Thread.currentThread().getId();
	  System.out.println("Test 1 in sampleone..."+id);
  }
  @Test
  public void testTwo() {
	  driver=new ChromeDriver();
	  long id=Thread.currentThread().getId();
	  System.out.println("Test 2 in sampleone..."+id);
  }
  @Test
  public void testThree() {
	  driver=new ChromeDriver();
	  long id=Thread.currentThread().getId();
	  System.out.println("Test 3 in sampleone..."+id);
  }
  @Test
  public void testFour() {
	  driver=new ChromeDriver();
	  long id=Thread.currentThread().getId();
	  System.out.println("Test 4 in sampleone..."+id);
  }
}
