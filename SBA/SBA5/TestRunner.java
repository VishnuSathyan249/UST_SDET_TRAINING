package stepDefinition;



import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
 

@CucumberOptions( 	
		features = "src/test/resources/Fearures", 
		glue = "stepDefinition",
		monochrome = true,
		plugin= {"pretty", "html:target/HtmlReports"})

 
public class TestRunner extends AbstractTestNGCucumberTests {
 
}
