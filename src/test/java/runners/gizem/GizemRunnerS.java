package runners.gizem;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/features/gizem/LoginFunctionality.feature"},
        glue = {"stepdefs"},
        dryRun = false,
        plugin = {"pretty",
                "json:test-output/cucumber-reports/cucumber.json",
                "html:test-output/cucumber-reports/cucumberreport.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
        // Commit edilmeye çalışıldı.
)
public class GizemRunnerS extends AbstractTestNGCucumberTests{

}
