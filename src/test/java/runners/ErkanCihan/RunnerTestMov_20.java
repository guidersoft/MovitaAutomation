package runners.ErkanCihan;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        //features = {"c:/features"},                   // feature'lar genellikle test/resources altinda olur
        features = {"src/test/resources/features/ErkanCihan/Mov_20.feature"},         // feature yolu alinirken content rootdan baslanir
        glue = {"stepdefs"},       // glue'lar, stepdefs ve hooks classlarinin yeridir, sourceroot'dan baslar
        dryRun = false,           // sadece step defsler düzgün hazirlanmismi, yapilandirma uygun mu
        //tags = "@FormGroup",    // @login tagli senaryolar calistirilin
        plugin = {"pretty",
                "json:test-output/cucumber-reports/cucumber.json",
                "html:test-output/cucumber-reports/cucumberreport.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}

)
public class RunnerTestMov_20 extends AbstractTestNGCucumberTests {



}