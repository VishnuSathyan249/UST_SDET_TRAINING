

package test;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

class NewTest {
	
	WebDriver driver ;
	
	@BeforeTest
	public void Chkwebsite()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Vishnu sathyan\\Desktop\\chromedriver_win32\\chromedriver.exe");	
		driver = new ChromeDriver();
		driver.navigate().to("https://www.google.com/");
		
	}

	@Test
	public void run()
	{
		driver.findElement(By.name("q")).sendKeys("Weather");
		
		driver.close();
	}
	

}
