package runners;

import Utilities.Driver;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;

import java.time.Duration;


@CucumberOptions(
            features = {"src/main/resources/features/Automation_AnaSayfa.feature"},
            glue = {"stepdefs"},
            dryRun=false
    )
    public class Runner extends AbstractTestNGCucumberTests {

    }

