package stepdef;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
 

@CucumberOptions( 	
		features = "src/Features", 
		glue = "stepdef",
		monochrome = true,
		plugin= {"pretty", "html:target/HtmlReports"})

 
public class Testrun extends AbstractTestNGCucumberTests {
 
}
