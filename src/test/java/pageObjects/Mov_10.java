package pageObjects;

import Base.BaseMovita;
import Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Mov_10 extends BaseMovita {

    public static By lVerifyMap = By.xpath("//span[contains(.,'Raporlar')]");
    public static By lRaporlarSubMenu = By.xpath("//li[@class='nav-item has-sub' and contains(.,'Raporlar')]//ul//li[contains(.,'Grup Bazlı')]");
    public static By lRaporlarMenu = By.xpath("//li[@class='nav-item has-sub' and contains(.,'Raporlar')]");
    By lLoginFormSubmitButton = By.xpath("//form//button[@type='submit']");
    By LDetaylıFiltre=By.xpath("//span[contains(.,'Detaylı Filtre')]");

    public static By loginFormİnput(String text) {
        By lLoginForm = By.xpath("//form[@class='needs-validation mb-2 mt-10']//input[@id='" + text + "']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(lLoginForm));
        // WebElement element = driver.findElement(lLoginForm);
        return lLoginForm;

    }

    public static By raporlarSubMenu(String text) {
        By lRaporlarSubMenu = By.xpath("//a[contains(.,'" + text + "')]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(lRaporlarSubMenu));
        return lRaporlarSubMenu;
    }
    public  static  By detailedFilterSubMenu(String text){
        By ldetailedFilterSubMenu=By.xpath("//div[@id='user-profile']//input[@id='"+text+"']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(ldetailedFilterSubMenu));
        return ldetailedFilterSubMenu;
    }


}
