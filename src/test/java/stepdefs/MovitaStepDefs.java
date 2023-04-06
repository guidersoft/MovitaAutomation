package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MovitaStepDefs {
    @Given("users go to url {string}")
    public void usersGoToUrl(String arg0) {
        driver.get(url);
    }

    @When("users clicked the movita logo")
    public void usersClickedTheMovitaLogo() {
        click(llogo);
    }

    @And("Mobile Vehicle Tracking System should be visible")
    public void mobileVehicleTrackingSystemShouldBeVisible() {
        click(llogo);
    }

    @Then("should be succus")
    public void shouldBeSuccus() {
    }
}
