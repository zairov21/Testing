import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumberReport.html", "json:target/testReport.json"},
        features = "src/test/resources/features",
        glue = "api",
        tags = "@productCash",
        dryRun = true
)

public class CucumberRunner{

}
