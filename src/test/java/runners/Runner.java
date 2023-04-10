package runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        //features = {"c:/features"},                   // feature'lar genellikle test/resources altinda olur
        features = {"src/test/resources/features/yusuf/Movita_Homepage_TopMenu.feature"},         // feature yolu alinirken content rootdan baslanir
        glue = {"stepdefs"},       // glue'lar, stepdefs ve hooks classlarinin yeridir, sourceroot'dan baslar
        tags = "@Language",
        dryRun = false           // sadece step defsler düzgün hazirlanmismi, yapilandirma uygun mu
        /*tags = "@login",         // @login tagli senaryolar calistirilin
        plugin = {"pretty",
                "html:test-output/report.html",
                "json:test-output/report.json"
        }*/
)

public class Runner extends AbstractTestNGCucumberTests {



}









