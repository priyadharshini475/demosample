package testScripts;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
public class MouseClick {
  @Test
  public void actionsTest() {
	  WebDriver driver=new ChromeDriver();
	  Actions actions=new Actions(driver);
	  driver.manage().window().maximize();
/*	  //Hover the mouse
	  driver.get("https://demo.opencart.com/");
	  WebElement srcBox=driver.findElement(By.cssSelector("ul.nav.navbar-nav li.dropdown:nth-child(3)"));
	  actions.contextClick(srcBox).perform();
	  //Double click and multiple click
	  driver.get("https://stqatools.com/demo/DoubleClick.php");
	  WebElement button=driver.findElement(By.xpath("//button[text()='Click Me / Double Click Me!']"));
	  actions.doubleClick(button).perform();
	  actions.doubleClick(button).doubleClick(button).build().perform();*/
	  driver.get("https://www.stqatools.com/demo/MouseHover.php");
	  WebElement menu=driver.findElement(By.cssSelector("button.dropbtn"));
	  actions.moveToElement(menu).perform();
	  WebElement menuItem=driver.findElement(By.cssSelector("div.dropdown-content > a:nth-child(1)"));
	  actions.moveToElement(menu).click(menuItem).build().perform();
  }
}
