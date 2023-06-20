package stepdefs;

import Base.BaseMovita;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;


import java.util.List;
import java.util.Map;

public class LoginFunctionalityStepdefs extends BaseMovita {
    @And("user sends username and password and verify")
    public void userSendsUsernameAndPasswordAndVerify(DataTable table) {
        List<Map<String,String>> mapList=table.asMaps();

        for (Map<String, String> stringMap : mapList) {
            sendKeys(BaseMovita.loginFormİnput("username"),stringMap.get("username"));
            sendKeys(BaseMovita.loginFormİnput("password"),stringMap.get("password"));


            if (stringMap.get("verify").equalsIgnoreCase("false")) {
                click(lLoginFormSubmitButton);
                bekle(1000);

                visible(username_password("Lütfen şifre girin!"));
                getScreenshot("lütfen");


            } else if (stringMap.get("verify").equalsIgnoreCase("false")) {

                click(lLoginFormSubmitButton);
                bekle(1000);
                visible(username_password("Lütfen kullanıcı adı girin!"));

            } else if (stringMap.get("verify").equalsIgnoreCase("false")) {

                click(lLoginFormSubmitButton);
                bekle(1000);
                visible(lHata);
                getScreenshot("hata");

            } else {

                click(lLoginFormSubmitButton);
                bekle(1000);
                visible(lDemoFilo);
                getScreenshot("map");

            }
        }



      /*  for (Map<String, String> map : mapList) {

            sendkeys(lusername,map.get("username"));
            sendkeys(lpassword,map.get("password"));

            if (map.get("status").equalsIgnoreCase("true")){
                click(lsubmitButton);
                wait.until(ExpectedConditions.visibilityOfElementLocated(lassert));
                click(llogoutMenu);
                click(llogout);

            }else {
                click(lsubmitButton);
                wait.until(ExpectedConditions.visibilityOfElementLocated(lInvalidLogin));

            }

        }*/

    }

    @And("user clicks demo filo")
    public void userClicksDemoFilo() {
        click(lDemoFilo);

    }

    @And("user clicks logout")
    public void userClicksLogout() {
        bekle(500);
        click(lLogOut);
    }

    @And("user clicks return the homepage")
    public void userClicksReturnTheHomepage() {
        bekle(500);
        click(lLoginFormAnaSayfayaDon);
    }

    @And("user clicks the english login button")
    public void userClicksTheEnglishLoginButton() {
        click(homePageMenu("Login"));
        getScreenshot("invalid Language");
    }
}
