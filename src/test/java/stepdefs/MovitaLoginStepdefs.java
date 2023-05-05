package stepdefs;

import Base.BaseMovita;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import readers.MyPojo;
import readers.json.ConfigJsonPojo;
import readers.yaml.ConfigYamlPojo;


import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;


public class MovitaLoginStepdefs extends BaseMovita {

    @When("user clicks {string} links")
    public void userClicksLinks(String text) {
        click(By.xpath(String.format(TOP_MENU, text)));
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
        List<String> username = getExcelColValuesOf(file, 0, 1);
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
        List<ConfigJsonPojo.User> users = ((ConfigYamlPojo) getPojo(file, pojo)).getUsers();

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

    @Then("user sees {string} on loginpage")
    public void userSeesOnLoginpage(String text) {
        if (text.equalsIgnoreCase("Ana sayfaya dön")){
            visible(lLoginFormAnaSayfayaDon);
        }else {
            visible(lLoginFormBackToHomepage);
        }

    }
    public MyPojo getPojo(String file, MyPojo pojo) {
        String[] arr = file.split("[.]");
        String fileType = arr[arr.length - 1].toLowerCase();
        try {
            switch (fileType) {
                case "json" -> {
                    ObjectMapper mapperJson = new ObjectMapper();
                    return mapperJson.readValue(new FileReader(file), pojo.getClass());
                }
                case "yaml" -> {
                    ObjectMapper mapperYaml = new ObjectMapper(new YAMLFactory());
                    return mapperYaml.readValue(new FileReader(file), pojo.getClass());
                }
                default -> throw new RuntimeException(file + " is not .yaml or .json file");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }




}






