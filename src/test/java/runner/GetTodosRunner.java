package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/feature/getTodos.feature",
        glue = {"stepDefinitions"},
        plugin = {"pretty" , "html:target/cucumber-reports/report.html"},
        monochrome = true
)

public class GetTodosRunner {
}
