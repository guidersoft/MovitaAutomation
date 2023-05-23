package stepdefs;

import Base.BaseMovita;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.Mov_10;

import java.util.List;
import java.util.Map;



public class LoginFunctionalityStepdefs extends BaseMovita {


    @And("user sends username and password and verify")
    public void userSendsUsernameAndPasswordAndVerify(DataTable table) {

        List<Map<String, String>> mapList = table.asMaps();

        for (Map<String, String> map : mapList) {
            sendKeys(Mov_10.loginFormİnput(map.get("username")), "username");
            sendKeys(Mov_10.loginFormİnput(map.get("password")), "password");
            click(lLoginFormSubmitButton);

            if (map.get("verify").equalsIgnoreCase("false")){
                visible(Mov_10.username_password("Lutfen sifre girin."));

            } else if (map.get("verify").equalsIgnoreCase("false")){
                visible(Mov_10.username_password("Lutfen kullanici adi girin."));

            } else if (map.get("verify").equalsIgnoreCase("false")){
                visible(Mov_10.lHata);

            }else{
                visible(Mov_10.lVerifyMap);
            }

        }
    }
}
