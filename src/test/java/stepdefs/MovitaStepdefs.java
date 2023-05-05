package stepdefs;

import Base.BaseMovita;
import Utilities.Driver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Map;


public class MovitaStepdefs extends BaseMovita{
    protected WebDriver driver;
    protected WebDriverWait wait;

    {
        driver = Driver.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }







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

        @And("user clicks the english language button")
        public void userClicksTheEnglishLanguageButton() {
            click(lEnglishLang);
        }

        @And("user String verify English → “Mobile Vehicle Tracking System” yazisini verify et")
        public void userStringVerifyEnglishMobileVehicleTrackingSystemYazisiniVerifyEt() {
            visible(lMobilVasıtaEnglish);
            getScreenshot("Mobile Vehicle Tracking System");
        }

        @And("user clicks the Turkish language button")
        public void userClicksTheTurkishLanguageButton() {
            click(lTurkishLang);
        }


        @And("user String verify Türkce → “Mobil Vasita izleme takip Sistemi” yazisini verify et")
        public void userStringVerifyTürkceMobilVasitaIzlemeTakipSistemiYazisiniVerifyEt() {
            visible(lMobilVasıtaTurkish);
        }

        @When("user hover over the homepage title and the title color should be changeable")
        public void userHoverOverTheHomepageTitleAndTheTitleColorShouldBeChangeable() {
            WebElement element = driver.findElement(lAnaSayfa);
            String beforeColor = element.getCssValue("color");
            hoverAll(lAnaSayfa);
            String afterColor = element.getCssValue("color");
            Assert.assertNotEquals(beforeColor, afterColor);

        }

        @And("homepage title should be clickable")
        public void homepageTitleShouldBeClickable() {
            click(lAnaSayfa);
        }


        @When("user hover over the {string} and {string}")
        public void userHoverOverTheAnd(String maintitle, String subtitles) {
            hoverOver(homePageMenu(maintitle));
            hoverOver(MainSubtitle(subtitles));


        }

        @And("{string} and {string} color should be changeable")
        public void andColorShouldBeChangeable(String maintitle, String subtitles) {
            //hoverOver(homePageMenu(maintitle));
            assertChangeColorMainTitle(maintitle);
            assertChangeColorSubTitle(subtitles);
        }

        @And("subtitles should be {string}")
        public void subtitlesShouldBe(String clickable) {
            hoverOver(homePageMenu("Kurumsal"));
            click(MainSubtitle(clickable));
        }

        @Then("verify the subtitle with of{string}")
        public void verifyTheSubtitleWithOf(String text) {
            visibleVerifyWithSubtitleKurumsal(text);
        }

        @Then("subtitles verify with {string}")
        public void subtitlesVerifyWith(String text) {
            visibleVerifyWithSubtitleKurumsal(text);
        }


        @When("user hover over the {string}")
        public void userHoverOverThe(String mainTitle) {
            hoverOver(homePageMenu(mainTitle));
        }

        @And("user {string} the subTitle")
        public void userTheSubTitle(String subTitle) {
            click(MainSubtitle(subTitle));

        }

        @Then("verify the subtitle of {string}")
        public void verifyTheSubtitleOf(String text) {
            visibleVerifyWithSubtitleUrunler(text);
        }



        @Then("{string} and {string} colours should be change")
        public void andColoursShouldBeChange(String mainTitle, String subTitle) {
            assertChangeColorMainTitle(mainTitle);
            assertChangeColorSubTitle(subTitle);
        }


        @When("users hover over the {string}")
        public void usersHoverOverThe(String main) {
            hoverOver(homePageMenu(main));
        }

        @And("hover over on the {string}")
        public void hoverOverOnThe(String sub) {
            hoverOver(MainSubtitle(sub));
        }

        @And("user {string} on the subTitle")
        public void userOnTheSubTitle(String sub) {
            hoverOver(homePageMenu("Çözümler"));
            click(MainSubtitle(sub));
        }

        @And("verify the subtitle of with{string}")
        public void verifyTheSubtitleOfWith(String sub) {

            visibleVerifyWithSubtitleCozumler(sub);
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

    public void visibleVerifyWithSubtitle(String text) {
        By lSubTitleVerify=By.xpath("//div[@class='col-md-3']//img");
        wait.until(ExpectedConditions.presenceOfElementLocated(lSubTitleVerify));
    }

    @When("user clicks the login button")
    public void userClicksTheLoginButton() {
        click(homePageMenu("GİRİŞ Yap"));
    }

    @And("user sends <username> and <password>")
    public void userSendsUsernameAndPassword(DataTable table) {
        Map<String,String> map=table.asMap();
        sendKeys(loginFormİnput("username"),map.get("username"));
        sendKeys(loginFormİnput("password"),map.get("password"));
    }

    @And("user clicks login form login button")
    public void userClicksLoginFormLoginButton() {
        click(lLoginFormSubmitButton);
    }
}
