package stepdefs;

import Base.BaseMovita;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageObjects.Mov_12_SmokeTest;

import java.util.List;

public class RaporlarSmokeTestStepdefs extends BaseMovita {

    @And("user clicks to {string} of the reports and subtitle colours should be changeable")
    public void userClicksToOfTheReportsAndSubtitleColoursShouldBeChangeable(String subtitle) {
       List<WebElement> elements = driver.findElements(Mov_12_SmokeTest.lRaporlarSubtitle);
        for (WebElement element : elements
        ) {
            bekle(300);
            String beforeColor = Mov_12_SmokeTest.raporlarSubtitle(subtitle).getCssValue("background-color");
        click(Mov_12_SmokeTest.raporlarSubtitle(subtitle));
        String afterColor  = Mov_12_SmokeTest.raporlarSubtitle(subtitle).getCssValue("color");
            click(element);
            Assert.assertNotEquals(beforeColor,afterColor);
        }
       /* bekle(200);
        String beforeColor = Mov_12_SmokeTest.raporlarSubtitle(subtitle).getCssValue("background-color");
        click(Mov_12_SmokeTest.raporlarSubtitle(subtitle));
        String afterColor  = Mov_12_SmokeTest.raporlarSubtitle(subtitle).getCssValue("color");
        Assert.assertNotEquals(beforeColor,afterColor);


        Mov_12_SmokeTest smokeTest= new Mov_12_SmokeTest();
        smokeTest.mov_12_changeColor(subtitle); */

    }
}
