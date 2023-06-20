package pageObjects;

import Base.BaseMovita;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class Mov_10 extends BaseMovita {

    public static By lVerifyMap = By.xpath("//span[contains(.,'Raporlar')]");
    public static By lRaporlarMenu = By.xpath("//li[@class='nav-item has-sub' and contains(.,'Raporlar')]");
    public static final By lAracDropDownMenu = By.xpath("//span[@role='presentation']");

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

    public static WebElement username_password(String text) {
        WebElement element = driver.findElement(By.xpath("(//div[contains(., '" + text + "' )])[4]"));
        return element;
    }

    public static By demoFilo() {
        return By.xpath("//span[text()='Demo Filo (129)']");
    }

}