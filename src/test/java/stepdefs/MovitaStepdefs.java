package stepdefs;

import Base.BaseMovita;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;

public class MovitaStepdefs extends BaseMovita {

    @Given("users navigate to {string}")
    public void usersNavigateTo(String url) {
        driver.get(url);

    }

    @When("users clicked the movita logo")
    public void usersClickedTheMovitaLogo() {
        click(llogo);
    }

    @And("Mobile Vehicle Tracking System shoould be visible")
    public void mobileVehicleTrackingSystemShoouldBeVisible() {
        visible(lMobilVasita);

    }

    @Then("should be success")
    public void shouldBeSuccess() {
        getScreenshot("Mobil Vasıta");

    }

    @When("user hover over {string}")
    public void userHoverOver(String mainLink) {
        hoverOverByAction(By.xpath(String.format(TOP_MENU, mainLink)));
    }

    @And("user assert change color of {string}")
    public void userAssertChangeColorOf(String mainLink) {
        assertChangeColor(By.xpath(String.format(TOP_MENU, mainLink)),"#00adee");
    }

    @And("user click {string}")
    public void userClick(String mainLink) {
        click(By.xpath(String.format(TOP_MENU, mainLink)));
    }

    @Then("{string} should be visible")
    public void shouldBeVisible(String url) {
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @Then("{string} should be visible in related page")
    public void shouldBeVisibleInRelatedPage(String text) {
        Assert.assertTrue(driver.getPageSource().contains(text));
    }

    @When("user clicked the language option dropdown menu")
    public void userClickedTheLanguageOptionDropdownMenu() {
        click(lLanguageOptionButton);
    }

    @And("user select {string} option")
    public void userSelectOption(String language) {
        click(By.xpath(String.format(TOP_MENU, language)));
    }


    @Then("user sees {string} on Page")
    public void userSeesOnPage(String text) {
        visible(lTextOfMobilVasıtaİzlemeTakipSistemi);
        Assert.assertTrue(driver.findElement(lTextOfMobilVasıtaİzlemeTakipSistemi).getText().contains(text));
    }


}
