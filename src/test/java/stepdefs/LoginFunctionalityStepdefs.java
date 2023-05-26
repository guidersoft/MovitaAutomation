package stepdefs;

import Base.BaseMovita;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import pageObjects.Mov_10;

import java.util.List;
import java.util.Map;

public class LoginFunctionalityStepdefs extends BaseMovita {

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

            } else if (map.get("verify").equalsIgnoreCase("false")) {
                click(lLoginFormSubmitButton);
                bekle(1000);
                visible(Mov_10.username_password("Lütfen kullanıcı adı girin!"));


            } else if (map.get("verify").equalsIgnoreCase("false")) {
                click(lLoginFormSubmitButton);
                bekle(1000);
                visible(Mov_10.lHata);

            } else {
                click(lLoginFormSubmitButton);
                bekle(1000);
                visible(Mov_10.lVerifyMap);


            }

        }


    }


    @And("user click to DemoFilo")
    public void userClickToDemoFilo() {
        click(Mov_10.lDemoFilo);
    }

    @And("user click to logout")
    public void userClickToLogout() {
        click(Mov_10.lLogout);
    }

    @And("user click to return to Homepage")
    public void userClickToReturnToHomepage() {
        click(Mov_10.lBacktoHomePage);
    }

    @And("user clicks the English login button")
    public void userClicksTheEnglishLoginButton() {
        click(homePageMenu("Login"));
        getScreenshot("Invalid Lang. ");
    }
}
