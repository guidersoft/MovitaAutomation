package stepdefs;


import Base.BaseMovita;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import pageObjects.Mov_10;
import pageObjects.Move_12;
import pageObjects.Move_20;


import java.util.List;
import java.util.Map;



import static pageObjects.Mov_10.lDemoFilo;
import static pageObjects.Mov_10.lRaporlarMenu;


public class Login_Functionality_Stepdefs extends BaseMovita {
    @When("user clicks the login button")
    public void userClicksTheLoginButton() {
        click(homePageMenu("GİRİŞ Yap"));
    }
    @And("user sends <username> and <password>")
    public void userSendsUsernameAndPassword(DataTable table) {

        Map<String, String> map = table.asMap();
        String username = map.get("username");
        String password = map.get("password");
        sendKeys(Mov_10.loginFormİnput("username"), username);
        sendKeys(Mov_10.loginFormİnput("password"), password);

    }
    @And("user click raporlar menu")
    public void userClickRaporlarMenu() {
        click(lRaporlarMenu);
    }
    @And("user clicks login form login button")
    public void userClicksLoginFormLoginButton() {
        click(lLoginFormSubmitButton);
    }

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

            } else {

                click(lLoginFormSubmitButton);
                bekle(1000);
                visible(lDemoFilo);
                getScreenshot("map");

            }
        }
    }

    @And("user click demoFilo Button")
    public void userClickDemoFiloButton() {
        click(Mov_10.demoFilo());
    }

    @And("user clicks logout")
    public void userClicksLogout() {
        bekle(1000);
        click(lLogoutDemoFilo);
    }
    @And("user clicks return the homepage")
    public void userClicksReturnTheHomepage() {
        bekle(1000);
        click(lAnasayfayaDon);
    }
    @And("user clicks the english login button")
    public void userClicksTheEnglishLoginButton() {
        click(Mov_10.lMobilVasıtaEnglish);
    }
    @And("user clicks to {string} of the reports and subtitle colours should be changeable")
    public void userClicksToOfTheReportsAndSubtitleColoursShouldBeChangeable(String subtitle) {
        /*  List<WebElement> elements = driver.findElements(Mov_12_SmokeTest.raporlarSubtitle);

        for (WebElement element : elements) {
            String beforeColorMainTitle = Mov_12_SmokeTest.raporlarAltMenu(subtitle).getCssValue("background-color");
            bekle(200);
            click(element);
            String afterColorMainTitle = Mov_12_SmokeTest.raporlarAltMenu(subtitle).getCssValue("color");
            Assert.assertNotEquals(beforeColorMainTitle, afterColorMainTitle);
        }*/

        Move_12 smokeTest = new Move_12();
        smokeTest.mov_12_changeColor(subtitle);
    }
    @When("user hover over the ınstituonal title")
    public void userHoverOverTheInstituonalTitle() {

        hoverOver(homePageMenu("Kurumsal"));

    }
    @And("user clicks to about us title")
    public void userClicksToAboutUsTitle() {
        click(MainSubtitle("Hakkımızda"));
    }
    @And("user verify to heading block")
    public void userVerifyToHeadingBlock(DataTable table) {
        scroll();

        /*List<WebElement> elements = driver.findElements(By.xpath("//section[@id='content']//h4"));
        for (WebElement element : elements) {
            visible(element);

        }*/

        List<String> list = table.asList();
        for (String s : list) {
            visible(Move_20.headingBlocks(s));
        }
    }

    @And("user hover over the arrow icons color should be changable")
    public void userHoverOverTheArrowIconsColorShouldBeChangable() {

        bekle(500);
        changeColor("click","background-color",Move_20.lIcon);
        /*String beforeColor =driver.findElement(Move_20_smokeTest.lIcon).getCssValue("background-color");
        bekle(200);
        hoverOver(driver.findElement(Move_20_smokeTest.lIcon));
        String afterColor = driver.findElement(Move_20_smokeTest.lIcon).getCssValue("color");
        Assert.assertNotEquals(beforeColor,afterColor);*/

    }
    @And("user click to arrow icons the turn back to about us page")
    public void userClickToArrowIconsTheTurnBackToAboutUsPage() {

        /*JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollBy(500, 500)");*/
        click(Move_20.lIcon);
        visible(llogo);
    }
}