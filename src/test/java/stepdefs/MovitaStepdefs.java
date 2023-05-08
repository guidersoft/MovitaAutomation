package stepdefs;


import Base.BaseMovita;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageObjects.Mov_10;

import java.util.Map;

public class MovitaStepdefs extends BaseMovita {

    @Given("users navigate to {string}")
    public void usersNavigateTo(String url) {
        driver.get(url);
    }
    @When("users clicked the movita logo")
    public void usersClickedTheMovitaLogo() {
        click(llogo);
    }
    @And("Mobile Vehicle Tracking System shoould be visible")
    public void mobileVehicleTrackingSystemShoouldBeVisible() {
        visible(lMobilVasıtaTurkish);
    }
    @Then("should be success")
    public void shouldBeSuccess() {
      getScreenshot("Mobil Vasıta");
    }

    @Given("user clicks the enter button")
    public void userClicksTheEnterButton() {
        click(lEnterButton);
    }
    @And("user clicks the Turkish language button")
    public void userClicksTheTurkishLanguageButton() {
        click(lTurkishLang);
    }
    @And("user String verify Türkce → “Mobil Vasita izleme takip Sistemi” yazisini verify et")
    public void userStringVerifyTürkceMobilVasitaIzlemeTakipSistemiYazisiniVerifyEt() {
        visible(lMobilVasıtaTurkish);
    }
    @And("user clicks the english language button")
    public void userClicksTheEnglishLanguageButton() {
        click(lEnglishLang);
    }
    @And("user String verify English → “Mobile Vehicle Tracking System” yazisini verify et")
    public void userStringVerifyEnglishMobileVehicleTrackingSystemYazisiniVerifyEt() {
        visible(lMobilVasıtaEnglish);
        getScreenshot("Mobile Vehicle Tracking System");
    }
    @When("user hover over the homepage title and title color should be changeable")
    public void userHoverOverTheHomepageTitleAndTitleColorShouldBeChangeable() {

        WebElement element = driver.findElement(lAnaSayfa);
        String beforeColor = element.getCssValue("color");
        hoverAll(lAnaSayfa);
        String afterColor = element.getCssValue("color");
        Assert.assertNotEquals(beforeColor, afterColor);
    }
    @And("home title should be clickable")
    public void homeTitleShouldBeClickable() {
        click(lAnaSayfa);
    }
    @When("users hover over on the {string}")
    public void usersHoverOverOnThe(String mainTitle) {
        hoverOver(homePageMenu(mainTitle));
    }
    @And("hover over the  {string}")
    public void hoverOverThe(String subTitle) {
        hoverOver(MainSubtitle(subTitle));
    }
    @And("The user {string} the subTitle")
    public void theUserTheSubTitle(String text) {
        click(MainSubtitle(text));
    }
    @And("The {string} and{string} colours should be change")
    public void theAndColoursShouldBeChange(String mainTitle, String subTitle) {
        assertChangeColorMainTitle(mainTitle);
        assertChangeColorSubTitle(subTitle);
    }
    @Then("verify the subtitle with {string}")
    public void verifyTheSubtitleWith(String text) {
        visibleVerifyWithSubtitle(text);
    }

    @When("user clicks the login button")
    public void userClicksTheLoginButton() {
        click(homePageMenu("GİRİŞ Yap"));
    }

    @And("user sends <username> and <password>")
    public void userSendsUsernameAndPassword(DataTable table) {
        Map<String,String> map=table.asMap();
        String username = map.get("username");
        String password = map.get("password");
        sendKeys(Mov_10.loginFormInput("username"),username);
        sendKeys(Mov_10.loginFormInput("password"),password);

    }

    @And("user clicks login form login button")
    public void userClicksLoginFormLoginButton() {
        click(lLoginFormSubmitButton);
    }


    @And("verify with map")
    public void verifyWithMap() {
        visible(Mov_10.lVerifyMap);
    }

    @And("user click raporlar menu")
    public void userClickRaporlarMenu() {
        click(Mov_10.lRaporlarMenu);
    }

    @And("user clicks the base tool report")
    public void userClicksTheBaseToolReport() {
        click(Mov_10.raporlarSubMenu("Araç Bazlı Rapor"));

    }
    @And("user clicks the detailed filter")
    public void userClicksTheDetailedFilter() {
        click(Mov_10.lDetaylıFiltre);

    }
    @And("user sends the detailed filter of sub menu")
    public void userSendsTheDetailedFilterOfSubMenu(DataTable table) {
        Map<String,String> map=table.asMap();
        sendKeys(Mov_10.detailFilterSubMenu(map.get("tarih")),"2023.05.08");
        sendKeys(Mov_10.detailFilterSubMenu(map.get("is baslama")),"2023.05.08");
        sendKeys(Mov_10.detailFilterSubMenu(map.get("is bitis")),"2023.05.08");
        sendKeys(Mov_10.detailFilterSubMenu(map.get("tarih")),"Mayıs");
        getScreenshot("tarih");
        sendKeys(Mov_10.detailFilterSubMenu(map.get("is baslama")),"Haziran");
        getScreenshot("İşe Başlama");
        sendKeys(Mov_10.detailFilterSubMenu(map.get("is bitis")),"Temmuz");
        getScreenshot("İş Bitiş");
    }


}
