package stepdefs;

import Base.BaseMovita;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import readers.MyPojo;
import readers.json.ConfigJsonPojo;
import readers.yaml.ConfigYamlPojo;

import java.util.List;
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
                System.out.println(driver.findElement(lLoginFormInvalidUsernamePasswordWarningMessage).getText());
            }
        }

    }


    @Then("user try to login with credential given in excel file name as {string}")
    public void userTryToLoginWithCredentialGivenInExcelFileNameAs(String fileName) {
        String file = "src/test/resources/datafiles/" + fileName;
        List<String> username = getExcelColValuesOf(file,0,1);
        List<String> password = getExcelColValuesOf(file, 0, 2);
        List<String> success = getExcelColValuesOf(file, 0, 3);
        for (int i = 0; i < username.size(); i++) {
            sendKeys(lLoginFormUsername, username.get(i));
            sendKeys(lLoginFormPassword, password.get(i));
            click(lLoginFormSubmitButton);

            if (success.get(i).equalsIgnoreCase("true")) {
                click(lDemoFileDropdownMenu);
                click(lDemoFileDropdownMenuLogout);
            }

            if (success.get(i).equalsIgnoreCase("false")) {
                if (username.get(i).equalsIgnoreCase("") && password.get(i).equalsIgnoreCase("")) {
                    visible(lLoginFormUsernameWarningMessage);
                    visible(lLoginFormPasswordWarningMessage);
                } else if (username.get(i).equalsIgnoreCase("")) {
                    visible(lLoginFormUsernameWarningMessage);
                } else if (password.get(i).equalsIgnoreCase("")) {
                    visible(lLoginFormPasswordWarningMessage);
                } else {
                    visible(lLoginFormInvalidUsernamePasswordWarningMessage);
                }
            }
        }
    }

    @Then("user try to login with credential given in yaml file name as {string}")
    public void userTryToLoginWithCredentialGivenInYamlFileNameAs(String fileName) {
        String file = "src/test/resources/datafiles/" + fileName;
        MyPojo pojo = new ConfigYamlPojo();
        ConfigYamlPojo pojo1 = (ConfigYamlPojo) getPojo(file, pojo);

        String username1 = pojo1.getUsers().getUser1().getUsername();
        String password1 = pojo1.getUsers().getUser1().getPassword();
        sendKeys(lLoginFormUsername, username1);
        sendKeys(lLoginFormPassword, password1);
        click(lLoginFormSubmitButton);
        click(lDemoFileDropdownMenu);
        click(lDemoFileDropdownMenuLogout);

        String username2 = pojo1.getUsers().getUser2().getUsername();
        String password2 = pojo1.getUsers().getUser2().getPassword();
        sendKeys(lLoginFormUsername, username2);
        sendKeys(lLoginFormPassword, password2);
        click(lLoginFormSubmitButton);
        visible(lLoginFormInvalidUsernamePasswordWarningMessage);

        String username3 = pojo1.getUsers().getUser3().getUsername();
        String password3 = pojo1.getUsers().getUser3().getPassword();
        if (username3==null) username3 ="";
        sendKeys(lLoginFormUsername, username3);
        sendKeys(lLoginFormPassword, password3);
        click(lLoginFormSubmitButton);
        visible(lLoginFormUsernameWarningMessage);

        String username4 = pojo1.getUsers().getUser4().getUsername();
        String password4 = pojo1.getUsers().getUser4().getPassword();
        if (password4==null) password4 ="";
        sendKeys(lLoginFormUsername, username4);
        sendKeys(lLoginFormPassword, password4);
        click(lLoginFormSubmitButton);
        visible(lLoginFormPasswordWarningMessage);

        String username5 = pojo1.getUsers().getUser5().getUsername();
        String password5 = pojo1.getUsers().getUser5().getPassword();
        if (password5==null) password5 ="";
        if (username5==null) username5 ="";
        sendKeys(lLoginFormUsername, username5);
        sendKeys(lLoginFormPassword, password5);
        click(lLoginFormSubmitButton);
        visible(lLoginFormUsernameWarningMessage);
        visible(lLoginFormPasswordWarningMessage);
    }

    @Then("user try to login with credential given in json file name as {string}")
    public void userTryToLoginWithCredentialGivenInJsonFileNameAs(String fileName) {
        String file = "src/test/resources/datafiles/" + fileName;
        MyPojo pojo = new ConfigJsonPojo();
        List<ConfigJsonPojo.User> users = ((ConfigJsonPojo) getPojo(file, pojo)).getUsers();

        for (int i = 0; i < users.size(); i++) {
            sendKeys(lLoginFormUsername, users.get(i).getUsername());
            sendKeys(lLoginFormPassword, users.get(i).getPassword());
            click(lLoginFormSubmitButton);

            if (users.get(i).getValid().equalsIgnoreCase("true")) {
                click(lDemoFileDropdownMenu);
                click(lDemoFileDropdownMenuLogout);
            }

            if (users.get(i).getValid().equalsIgnoreCase("false")) {
                if (users.get(i).getUsername().equalsIgnoreCase("") && users.get(i).getPassword().equalsIgnoreCase("")) {
                    visible(lLoginFormUsernameWarningMessage);
                    visible(lLoginFormPasswordWarningMessage);
                } else if (users.get(i).getUsername().equalsIgnoreCase("")) {
                    visible(lLoginFormUsernameWarningMessage);
                } else if (users.get(i).getPassword().equalsIgnoreCase("")) {
                    visible(lLoginFormPasswordWarningMessage);
                } else {
                    visible(lLoginFormInvalidUsernamePasswordWarningMessage);
                }
            }
        }
    }
}

