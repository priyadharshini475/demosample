package groupScripts;

import org.testng.annotations.Test;

public class GroupScript1 {
  
  @Test(groups="feature1")
  public void testOne() {
	  System.out.println("TestOne in Sample-1");
  }
  @Test(groups="feature1")
  public void testTwo() {
	  System.out.println("TestTwo in Sample-1");
  }
  @Test(groups="feature3")
  public void testThree() {
	  System.out.println("TestThree in Sample-1");
  }
  @Test
  public void testFour() {
	  System.out.println("TestFour in Sample-1");
  }
}
