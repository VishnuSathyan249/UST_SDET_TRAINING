import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

  public class NewTest {
  	 WebDriver driver;
  	 String path = "C:\\Users\\Vishnu sathyan\\Desktop\\chromedriver_win32\\chromedriver.exe";
  	
    @Test(priority = 1)
    public void titletest()  {
  	  
  	  System.setProperty("webdriver.chrome.driver",path);
  	  driver = new ChromeDriver();
  	  driver.get("https://demo.guru99.com/test/newtours/register.php");
  	  Assert.assertEquals(driver.getTitle(),"Register: Mercury Tours");
    }
    
    @Test(priority = 2)
    public void userreg() {
 
  	  driver.findElement(By.name("firstName")).sendKeys("John");	
  	  driver.findElement(By.name("lastName")).sendKeys("Philip");	
  	  driver.findElement(By.name("phone")).sendKeys("1234567890");	
  	  driver.findElement(By.name("userName")).sendKeys("user");	
  	  driver.findElement(By.name("address1")).sendKeys("House no 14 hgj hhfbfvbfvffff");	
  	  driver.findElement(By.name("city")).sendKeys("Persia");	
  	  driver.findElement(By.name("state")).sendKeys("kerala");	
  	  driver.findElement(By.name("postalCode")).sendKeys("8905123");
  	  driver.findElement(By.name("country")).click();	  
  	  driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[11]/td[2]/select/option[7]")).click();
  	  driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("user");
  	  driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[14]/td[2]/input")).sendKeys("user");
  	  driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[15]/td[2]/input")).sendKeys("user");
  	  driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[17]/td/input")).click();
  	  driver.findElement(By.linkText("Home")).click();
    }
    
	  @Test(priority = 3) 
		public void userlogin()
		{
		    
		  driver.findElement(By.name("userName")).sendKeys("user");	
		  driver.findElement(By.name("password")).sendKeys("user");	  
		  driver.findElement(By.name("submit")).click(); 
		}
	  
	  @Test(priority = 4)
	  public void flightCheck(){
	  driver.findElement(By.linkText("Flights")).click();
	  //click on the Business class
      driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[9]/td[2]/font/font/input[1]")).click();
      // click on Blue Skies Airlines
      driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[10]/td[2]/select/option[2]")).click();
      //Then click continue
      driver.findElement(By.xpath(" /html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[14]/td/input")).click();
	  
	  	}
	  
	  @Test
	  public void imagechk()
	  {
		  
	  }
    
	  @AfterTest 
		public void close()
		{
		  driver.close();
		}
		    
    
  }

