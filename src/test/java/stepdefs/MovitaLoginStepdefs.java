package stepdefs;

import Base.BaseMovita;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import java.util.Map;


public class MovitaLoginStepdefs extends BaseMovita {
    By lLoginFormUsername = By.id("username");
    By lLoginFormPassword = By.id("password");
    By lLoginFormSubmitButton = By.xpath("//form//button[@type='submit']");
    By lLoginFormUsernameWarningMessage = By.xpath("//div[contains(text(),'Lütfen kullanıcı adı girin!')]");
    By lLoginFormPasswordWarningMessage = By.xpath("//div[contains(text(),'Lütfen şifre girin!')]");
    By lDemoFileDropdownMenuLogout = By.xpath("//a[contains(.,' Çıkış Yap')]");
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

    }

    @And("user clicks Login button")
    public void userClicksLoginButton() {
    }

    @Then("login should be {string} with {string} and {string}")
    public void loginShouldBeWithAnd(String arg0, String arg1, String arg2) {
    }
}
