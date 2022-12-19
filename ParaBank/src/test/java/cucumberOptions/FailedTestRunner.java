package cucumberOptions;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="@target/failed_scenarios.txt",glue ="stepDefinitions"
,monochrome=true,
plugin= {"html:target/cucumber.html", "json:target/cucumber.json",

})
public class FailedTestRunner extends AbstractTestNGCucumberTests{


	
}
