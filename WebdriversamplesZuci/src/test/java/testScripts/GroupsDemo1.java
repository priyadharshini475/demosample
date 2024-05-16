package testScripts;

import org.testng.annotations.Test;

public class GroupsDemo1 {
  @Test(groups= {"b"})
  public void logOut() {
	  System.out.println("Log Out");
  }
}
