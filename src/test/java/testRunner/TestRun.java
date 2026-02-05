package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions
(
features={"src/test/resources/Features/login.feature","src/test/resources/Features/GetNextLead.feature"},
glue="Stepdefination",
dryRun=false,
monochrome=false,   //remove unneccesary character in the console
plugin= {"pretty","html:test-output"		
}
		)

public class TestRun {
	

}
