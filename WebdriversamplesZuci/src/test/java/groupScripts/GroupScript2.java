package groupScripts;

import org.testng.annotations.Test;

public class GroupScript2 {
	 @Test(groups="feature1")
	  public void testOne() {
		  System.out.println("TestOne in Sample-2");
	  }
	  @Test(groups="feature2")
	  public void testTwo() {
		  System.out.println("TestTwo in Sample-2");
	  }
	  @Test
	  public void testThree() {
		  System.out.println("TestThree in Sample-2");
	  }
	  @Test
	  public void testFour() {
		  System.out.println("TestFour in Sample-2");
	  }
}
