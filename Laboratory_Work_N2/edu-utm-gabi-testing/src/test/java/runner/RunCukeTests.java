package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true,
        features = "src/test/resources/cucumber/features/nike-store/",
        tags = {"@Run"},
        glue = {"steps"}

)

public class RunCukeTests {


}
