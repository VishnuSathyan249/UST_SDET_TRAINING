package j;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class NewTest {
  @Test
  public void f() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vishnu sathyan\\Desktop\\chromedriver_win32\\chromedriver.exe");
		WebDriver wd = new ChromeDriver();
		wd.navigate().to("https://www.google.com/");
		wd.findElement(By.name("csi"));
		String s = wd.getTitle();
		System.out.println(s);
		s.equals("Google");
  }
}



