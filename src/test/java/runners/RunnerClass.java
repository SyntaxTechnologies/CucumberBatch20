package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //path of my feature file/directory
        features = "src/test/resources/features/",
        //name of the package where all step defs are available
        glue = "steps",
        //when the value of dry run is set to true, it stops execution and scan all the steps
        //when the value is false, again it starts execution
        dryRun = false,
        tags = "@excel"
)



public class RunnerClass {
}
