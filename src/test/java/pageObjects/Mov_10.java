package pageObjects;

import Base.BaseMovita;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Mov_10 extends BaseMovita {

    public static By lVerifyMap = By.xpath("//span[contains(.,'Raporlar')]");
    public static By lRaporlarSubMenu = By.xpath("//li[@class='nav-item has-sub' and contains(.,'Raporlar')]//ul//li[contains(.,'Grup Bazlı')]");
    public static By lRaporlarMenu = By.xpath("//li[@class='nav-item has-sub' and contains(.,'Raporlar')]");
    By lLoginFormSubmitButton = By.xpath("//form//button[@type='submit']");
    By lDetaylıFiltre = By.xpath("//span[contains(.,'Detaylı Filtre')]");
    public static final By lAracDropDownMenu = By.xpath("//span[@role='presentation']");
    public static final By lStartDateDropDownMenu = By.xpath("//div[@class='card']//div[@class='form-group']");

    public static By loginFormİnput(String text) {
        return By.xpath("//form[@class='needs-validation mb-2 mt-10']//input[@id='" + text + "']");


    }

    public static By raporlarSubMenu(String text) {
        return By.xpath("//a[contains(.,'" + text + "')]");


    }

    public static By detailedFilterSubMenu(String text) {
        return By.xpath("//div[@id='user-profile']//input[@id='" + text + "']");

    }

    public static By resultOfReportWith(String text) {
        return By.xpath("//div[@class='dt-buttons']//a[contains(@title,'" + text + "')]");

    }

    public static By aracSelect(String text) {
        return By.xpath("//div[@class='card']//select[@id='aracSelect']//option[contains(.,'" + text + "')]");


    }

    public static By selectDateMenu(String text) {
        return By.xpath("//div[@class='form-group']//input[@id='" + text + "']");

    }

    public static By selectMonth(String monthselect, String month, int num) {
        return By.xpath("(//div[@class='calendar-table']//select[@class='" + monthselect + "'])[" + num + "]//option[text()='" + month + "']");

    }

    public static By selectYear(String yearselect, String year, int num) {

        return By.xpath("(//div[@class='calendar-table']//select[@class='" + yearselect + "'])[" + num + "]//option[text()='" + year + "']");

    }

    public static By selectDay(String day, int num) {

        return By.xpath(" (//div[@class='calendar-table']//tr//td[text()='" + day + "'])[" + num + "]");

    }

    public static WebElement username_password(String text) {
        WebElement element = driver.findElement(By.xpath("(//div[contains(., '" + text + "' )])[4]"));
        return element;
    }

    public static By demoFilo() {

        return By.xpath("//span[text()='Demo Filo (129)']");

    }
   /* public static By logout(String text){
        return By.xpath("//a[contains(.,'"+text+"')]");
    }
    public  static By anasayfayaDon(String text){
        return By.xpath("//a[contains(.,'"+text+"')]");
    }*/
}
