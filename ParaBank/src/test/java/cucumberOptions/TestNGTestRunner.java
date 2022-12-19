package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/openingAccount_A.feature",glue ="stepDefinitions",
monochrome=true,
plugin= {"html:target/cucumber.html", "json:target/cucumber.json",
		
		"rerun:target/failed_scenarios.txt"
		}
)
public class TestNGTestRunner extends AbstractTestNGCucumberTests{


	
}
