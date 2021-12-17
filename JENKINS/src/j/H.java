package j;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class H {
  @Test
  public void f() {
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\Vishnu sathyan\\Desktop\\chromedriver_win32\\chromedriver.exe");
		WebDriver wd1 = new ChromeDriver();
		wd1.navigate().to("https://www.facebook.com/");
  }
}



