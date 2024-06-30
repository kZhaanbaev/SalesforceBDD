package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "html:target/report.html",
                "json:target/cucumber-reports/cucumber2.json"
        },
        features = "src/test/resources/features",
        glue = "stepDefs",
        stepNotifications = true,
        tags = "@homeTests",
        dryRun = false
)
public class HomeRunner {

}
