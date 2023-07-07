package stepdefs;

import Utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import readers.property.PropertyReader;

public class Hooks {

    @After(order = 0)
    public void after0() {
        Driver.quitDriver();
    }

    @AfterStep
    public void afterStep(Scenario scenario) {
        boolean scrShot = PropertyReader.propertyReader().get("takescreenshot").equalsIgnoreCase("true");
        String takescreenOn = PropertyReader.propertyReader().get("takescreenshot.on");
        if (scrShot) {
            if (takescreenOn.equalsIgnoreCase("fail")) {
                if (scenario.isFailed()) {
                    byte[] screenShot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
                    scenario.attach(screenShot, "image/png", scenario.getName());

                }
            } else {
                byte[] screenShot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenShot, "image/png", scenario.getName());

            }
        }
    }
}