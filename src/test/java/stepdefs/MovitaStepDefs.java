package stepdefs;

import Base.BaseMovita;
import Locaators.Locator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

public class MovitaStepDefs extends BaseMovita {
    @Given("users go to url {string}")
    public void usersGoToUrl(String url) {
        driver.get(url);
    }


    @When("users clicked the movita logo")
    public void usersClickedTheMovitaLogo() {
        click(llogo);
    }



    @And("Mobile Vehicle Tracking System shoould be visible")
    public void mobileVehicleTrackingSystemShoouldBeVisible() {
        visible(lMobilVasıtaTurkish);
}
    @Then("should be succus")
    public void shouldBeSuccus() {
        getScreenshot("Mobil Vasıta");
    }


    @Given("user clicks the enter button")
    public void userClicksTheEnterButton() {
        click(lEnterButton);
    }

    @And("user clicks the english language button")
    public void userClicksTheEnglishLanguageButton() {
        click(lEnglishLang);
    }

    @And("user String verify English → “Mobile Vehicle Tracking System” yazisini verify et")
    public void userStringVerifyEnglishMobileVehicleTrackingSystemYazisiniVerifyEt() {
        visible(lMobilVasıtaEnglish);
        getScreenshot("Mobile Vehicle Tracking System");
    }

    @And("user clicks the Turkish language button")
    public void userClicksTheTurkishLanguageButton() {
        click(lTurkishLang);
    }

    @And("user String verify Türkce → “Mobil Vasita izleme takip Sistemi” yazisini verify et")
    public void userStringVerifyTürkceMobilVasitaIzlemeTakipSistemiYazisiniVerifyEt() {
        bekle(500);
        visible(lMobilVasıtaTurkish);
        getScreenshot("Mobil Vasita izleme takip Sistemi");


    }

    @When("users hover over the homepage title")
    public void usersHoverOverTheHomepageTitle() {
        WebElement element=driver.findElement(lAnaSayfa);
        hoverOver(element,"Ana Sayfa");

    }

    @And("homepage should be clickable")
    public void homepageShouldBeClickable() {
        click(lAnaSayfa);
        visible(lMobilVasıtaTurkish);
    }
}
