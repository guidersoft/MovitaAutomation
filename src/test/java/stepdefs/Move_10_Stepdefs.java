package stepdefs;
import Base.BaseMovita;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import pageObjects.Mov_10;

import java.awt.*;
import java.util.Map;


import static pageObjects.Mov_10.*;



public class Move_10_Stepdefs extends BaseMovita{


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

        if (driver.findElements(By.xpath(hiden)).size()>0){
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
        userSelectVehicle();
        userClicksFormGroupOfStartOfDate();
        Select select = new Select(driver.findElement(By.xpath("//select[@class='monthselect']")));
        select.selectByValue("0");

        bekle(200);

        Select select1 = new Select(driver.findElement(By.xpath("//select[@class='yearselect']")));
        select1.selectByValue("2023");

        bekle(200);

        click(driver.findElement(By.xpath("//td[@class='available' and text()='18']")));
        userClicksFormGroupOfFinishOfDate();
        Select select2 = new Select(driver.findElement(By.xpath("(//select[@class='monthselect'])[1]")));
        select2.selectByValue("5");


        Select select3 = new Select(driver.findElement(By.xpath("//select[@class='yearselect']")));
        select3.selectByValue("2023");

        bekle(200);

        click(driver.findElement(By.xpath("//td[@class='available' and text()='21']")));
        click(Mov_10.raporlarSubMenu("Rapor Al"));
    }

    @And("user clicks the detailed filter")
    public void userClicksTheDetailedFilter() {
        click(LDetaylıFiltre);
        bekle(500);
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

        // List<String> strings = driver.getWindowHandles().stream().toList();
/*
        String mainWin = driver.getWindowHandle();


        //driver.switchTo().window(strings.get(1));
        //driver.switchTo().window(strings.get(2));

        Set<String> windowHandles = driver.getWindowHandles();
        for (String win : windowHandles) {
            if (!win.equalsIgnoreCase(mainWin)) {

                break;
            }
        }
*/
        bekle(2000);
        new Actions(driver)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();

//        driver.switchTo().window(mainWin);

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
        Select select=new Select(driver.findElement(By.cssSelector("#aracSelect")));
        select.selectByVisibleText("OFISTESTPRO");

    }

    @And("user clicks form group of start of date")
    public void userClicksFormGroupOfStartOfDate() {
        bekle(500);
        click(Mov_10.selectDateMenu("tarih1"));

    }
    @And("user select start of date")
    public void userSelectStartOfDate() {

        Select select = new Select(driver.findElement(By.xpath("//select[@class='monthselect']")));
        select.selectByValue("0");

        bekle(200);

        Select select1 = new Select(driver.findElement(By.xpath("//select[@class='yearselect']")));
        select1.selectByValue("2023");

        bekle(200);

        click(driver.findElement(By.xpath("//td[@class='available' and text()='18']")));

        bekle(3000);
    }
    @And("user clicks form group of finish of date")
    public void userClicksFormGroupOfFinishOfDate() {
        click(Mov_10.selectDateMenu("tarih2"));

    }

    @And("user select finish of date")
    public void userSelectFinishOfDate() {
        bekle(500);
        Select select2 = new Select(driver.findElement(By.xpath("//div[5]/div/div[2]/table/thead/tr/th[2]/select")));
        select2.selectByValue("6");
        bekle(500);
        Select select3 = new Select(driver.findElement(By.xpath("(//div[5]/div/div[2]/table/thead/tr/th[2]/select)[2]")));
        select3.selectByValue("2023");
        bekle(500);
        click(driver.findElement(By.xpath("//td[@class='available' and text()='12']")));

    }
    @And("user clicks report")
    public void userClicksReport() {
        click(Mov_10.raporlarSubMenu("Rapor Al"));

    }

}
