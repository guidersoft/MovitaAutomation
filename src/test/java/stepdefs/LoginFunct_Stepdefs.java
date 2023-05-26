package stepdefs;

import Base.BaseMovita;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pageObjects.Mov_10;

import java.util.List;
import java.util.Map;

import static Locaators.Locator.lLoginFormSubmitButton;

public class LoginFunct_Stepdefs extends BaseMovita {
    @And("user sends username and password and verify")
    public void userSendsUsernameAndPasswordAndVerify(DataTable table) {

        List<Map<String, String>> mapList = table.asMaps();

        for (Map<String, String> map : mapList) {

            bekle(1000);
            sendKeys(Mov_10.loginFormİnput("username"), map.get("username"));
            sendKeys(Mov_10.loginFormİnput("password"), map.get("password"));


            if (map.get("verify").equalsIgnoreCase("false")) {
                click(lLoginFormSubmitButton);
                bekle(1000);

                visible(Mov_10.username_password("Lütfen şifre girin!"));
                getScreenshot("lütfen");


            } else if (map.get("verify").equalsIgnoreCase("false")) {

                click(lLoginFormSubmitButton);
                bekle(1000);
                visible(Mov_10.username_password("Lütfen kullanıcı adı girin!"));

            } else if (map.get("verify").equalsIgnoreCase("false")) {

                click(lLoginFormSubmitButton);
                bekle(1000);
                visible(Mov_10.lHata);
                getScreenshot("hata");

            } else {

                click(lLoginFormSubmitButton);
                bekle(1000);
                visible(Mov_10.lVerifyMap);
                getScreenshot("map");

            }
        }
    }
    @And("user clicks demo filo")
    public void userClicksDemoFilo() {
        click(Mov_10.lDemoFilo);
    }

    @And("user clicks logout")
    public void userClicksLogout() {
        click(Mov_10.lLogout);
    }

    @And("user clicks return the homepage")
    public void userClicksReturnTheHomepage() {
        click(Mov_10.lLoginFormAnaSayfayaDon);
    }

    @When("user clicks the english login button")
    public void userClicksTheEnglishLoginButton() {
        click(homePageMenu("Login"));
        getScreenshot("invalid language");
    }

    //Login Page
}
