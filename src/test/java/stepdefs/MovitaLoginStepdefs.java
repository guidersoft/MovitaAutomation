package stepdefs;

import Base.BaseMovita;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import java.util.Map;


public class MovitaLoginStepdefs extends BaseMovita {

    @When("user clicks {string} links")
    public void userClicksLinks(String arg0) {
        click(By.xpath(String.format(TOP_MENU, "GİRİŞ Yap")));
    }

    @Then("Login page should be visible")
    public void loginPageShouldBeVisible() {
        visible(lLoginFormUsername);
    }

    @When("user fill the login form with the following data")
    public void userFillTheLoginFormWithTheFollowingData(DataTable table) {
        Map<String, String> map = table.asMap();
        String username = map.get("username");
        String password = map.get("password");
        if (username == null) username = "";
        if (password == null) password = "";
        sendKeys(lLoginFormUsername, username);
        sendKeys(lLoginFormPassword, password);
    }

    @And("user clicks Login button")
    public void userClicksLoginButton() {
        click(lLoginFormSubmitButton);
    }

    @Then("login should be {string} with {string} and {string}")
    public void loginShouldBeWithAnd(String success, String username, String password) {
        if (success.equalsIgnoreCase("true")) {
            click(lDemoFileDropdownMenu);
            click(lDemoFileDropdownMenuLogout);
        }

        if (success.equalsIgnoreCase("false")) {
            if (username.equalsIgnoreCase("") && password.equalsIgnoreCase("")) {
                visible(lLoginFormUsernameWarningMessage);
                visible(lLoginFormPasswordWarningMessage);
            } else if (username.equalsIgnoreCase("")) {
                visible(lLoginFormUsernameWarningMessage);
            } else if (password.equalsIgnoreCase("")) {
                visible(lLoginFormPasswordWarningMessage);
            } else {
                visible(lLoginFormInvalidUsernamePasswordWarningMessage);
            }
        }

    }
}

