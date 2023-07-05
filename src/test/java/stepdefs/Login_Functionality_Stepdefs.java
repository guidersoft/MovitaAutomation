package stepdefs;


import Base.BaseMovita;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pageObjects.Mov_10;
import pageObjects.Move_12;
import pageObjects.Move_20;

import java.awt.*;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static pageObjects.Mov_10.*;


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
    @And("user clicks login form login button")
    public void userClicksLoginFormLoginButton() {
        click(lLoginFormSubmitButton);
    }

    @And("verify with map")
    public void verifyWithMap() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        System.out.println(screenSize);
        visible(lDemoFilo);
    }

    @And("user click pizza menu")
    public void userClickPizzaMenu() {
        By lPizzaMenuActive = By.xpath("(//a[@class='nav-link nav-menu-main menu-toggle hidden-xs is-active'])[2]");
        String hiden="(//a[@class='nav-link nav-menu-main menu-toggle hidden-xs'])[2]";

        if (hiden.equals(hiden)){
            click(lPizzaMenu);
            click(lRaporlarMenu);
            click(Mov_10.raporlarSubMenu("Araç Bazlı Rapor"));

        }else {
            click(lRaporlarMenu);
            click(Mov_10.raporlarSubMenu("Araç Bazlı Rapor"));


        }

    }
    @And("user clicks detailed report")
    public void userClicksDetailedReport() {
        userClicksFormGroupOfStartOfDate();
        userSelectStartOfDate();
        userClicksFormGroupOfFinishOfDate();
        userSelectFinishOfDate();
        click(Mov_10.raporlarSubMenu("Rapor Al"));
    }

    @And("user click raporlar menu")
    public void userClickRaporlarMenu() {
        click(lRaporlarMenu);
    }

    @And("user clicks the base tool report")
    public void userClicksTheBaseToolReport() {
        click(Mov_10.raporlarSubMenu("Araç Bazlı Rapor"));

    }
    @And("user clicks the detailed filter")
    public void userClicksTheDetailedFilter() {
        bekle(500);
        click(LDetaylıFiltre);

    }
    @And("user sends detailed filter of sub menu")
    public void userSendsDetailedFilterOfSubMenu(DataTable table) {
        Map<String, String> map = table.asMap();
        sendKeys(Mov_10.detailedFilterSubMenu(map.get("tarih")), "2023.05.15");
        sendKeys(Mov_10.detailedFilterSubMenu(map.get("is baslama")), "2023.05.15");
        sendKeys(Mov_10.detailedFilterSubMenu(map.get("is bitis")), "2023.05.15");

        sendKeys(Mov_10.detailedFilterSubMenu(map.get("tarih")), "Mayıs");
        getScreenshot("Tarih");
        sendKeys(Mov_10.detailedFilterSubMenu(map.get("is baslama")), "Haziran");
        getScreenshot("İşe baslama");
        sendKeys(Mov_10.detailedFilterSubMenu(map.get("is bitis")), "Temmuz");
        getScreenshot("İş bitiş");

    }

    @And("user clicks the result of the report")
    public void userClicksTheResultOfTheReport(DataTable table) {

        Map<String, String> map = table.asMap();

        click(Mov_10.resultOfReportWith(map.get("exel")));
        getScreenshot("exel");
        bekle(500);
        click(Mov_10.resultOfReportWith(map.get("pdf")));
        getScreenshot("pdf");
        bekle(500);
        click(Mov_10.resultOfReportWith(map.get("yazıcı")));
        getScreenshot("yazıcı");
        String mainWin = driver.getWindowHandle();
        Set<String> wins = driver.getWindowHandles();

        for (String win : wins) {
            if (!win.equalsIgnoreCase(mainWin)) {
                driver.switchTo().window(win);
                break;
            }
        }

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .build();
        actions.perform();

        driver.switchTo().window(mainWin);

        //By lCancelButton = By.xpath("//cr-button[@class='cancel-button']");
       /* By lShadowRoot1 = By.tagName("print-preview-app");
        By lShadowRoot2 = By.id("sidebar");
        By lShadowRoot3 = By.tagName("print-preview-button-strip");
        WebElement topOne = wait.until(ExpectedConditions.presenceOfElementLocated(lShadowRoot1));
        WebElement topTwo = topOne  //ilk shadowroot
                .getShadowRoot()
                .findElement(lShadowRoot2);
        WebElement topThree = topTwo  //ilk shadowroot
                .getShadowRoot()
                .findElement(lShadowRoot3);//ikinci shadow
                WebElement eCancelButton=topThree.getShadowRoot().findElement(lCancelButton);
        click(eCancelButton);*/

    }

    @And("user clicks form group of vehicle")
    public void userClicksFormGroupOfVehicle() {
        click(Mov_10.lAracDropDownMenu);

    }

    @And("user select vehicle")
    public void userSelectVehicle() {
        click(Mov_10.aracSelect("OFISTESTPRO"));
        click(Mov_10.lAracDropDownMenu);
    }

    @And("user clicks form group of start of date")
    public void userClicksFormGroupOfStartOfDate() {
        bekle(500);
        click(Mov_10.selectDateMenu("tarih1"));

    }
    @And("user select start of date")
    public void userSelectStartOfDate() {
        /*Select select = new Select(Mov_10.selectMonth());
        select.selectByValue("10");*/
        Select select = new Select(driver.findElement(By.xpath("//select[@class='monthselect']")));
        select.selectByValue("9");

        bekle(200);

        Select select1 = new Select(driver.findElement(By.xpath("//select[@class='yearselect']")));
        select1.selectByValue("2022");

        bekle(200);

        click(driver.findElement(By.xpath("//td[@class='available' and text()='26']")));
        // click(Mov_10.selectDay("20",1));

        bekle(3000);
    }
    @And("user clicks form group of finish of date")
    public void userClicksFormGroupOfFinishOfDate() {
        click(Mov_10.selectDateMenu("tarih2"));

    }

    @And("user select finish of date")
    public void userSelectFinishOfDate() {

        Select select2 = new Select(driver.findElement(By.xpath("//select[@class='monthselect']")));
        select2.selectByValue("9");

        bekle(200);

        Select select3 = new Select(driver.findElement(By.xpath("//select[@class='yearselect']")));
        select3.selectByValue("2022");

        bekle(200);

        click(driver.findElement(By.xpath("//td[@class='available' and text()='26']")));
        // click(Mov_10.selectDay("25",2));

        bekle(3000);



    }
    @And("user clicks report")
    public void userClicksReport() {
        click(Mov_10.raporlarSubMenu("Rapor Al"));

    }
    @And("uuser clicks on create report")
    public void uuserClicksOnCreateReport() {
        click(Mov_10.raporlarSubMenu("Rapor Al"));
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

/*

            } else if (map.get("verify").equalsIgnoreCase("false")) {

                click(lLoginFormSubmitButton);
                bekle(1000);
                visible(Mov_10.username_password("Lütfen kullanıcı adı girin!"));

            } else if (map.get("verify").equalsIgnoreCase("false")) {

                click(lLoginFormSubmitButton);
                bekle(1000);
               //visible(Mov_10.lHata);
                getScreenshot("hata");
*/

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
        click( MainSubtitle("Hakkımızda"));
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
        // visible(Move_20_smokeTest.headingBlocks(headingBlock));

    }

    @And("user hover over the arrow icons color should be changable")
    public void userHoverOverTheArrowIconsColorShouldBeChangable() {
        bekle(500);
        // scroll();
        //changeColor("click","background-color",Move_20.lIcon);
        String beforeColor =driver.findElement(Move_20.lIcon).getCssValue("background-color");
        bekle(200);
        hoverOver(driver.findElement(Move_20.lIcon));
        String afterColor = driver.findElement(Move_20.lIcon).getCssValue("color");
        Assert.assertNotEquals(beforeColor,afterColor);

    }
    @And("user click to arrow icons the turn back to about us page")
    public void userClickToArrowIconsTheTurnBackToAboutUsPage() {
        // scroll();
        /*JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollBy(500, 500)");*/
        click(Move_20.lIcon);
        visible(llogo);
    }







}
