import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features =  "src/test/java/FeaturesOne",
        glue = "StepsOne",
        plugin =    {"pretty"},
        publish =   true
)
public class TestRunnerOne {
}
