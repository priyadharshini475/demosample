package testScripts;

import org.testng.annotations.Test;

public class GropsDemo {
	 @Test(groups={"a"})
	  public void SignUp() {
		  System.out.println("Sign up");
	  }
	 @Test(groups= {"a"})
	  public void Login() {
		  System.out.println("Log in");
	  }
	 @Test(groups= {"b"})
	  public void addToCart() {
		  System.out.println("Cart Added");
	  }


}
