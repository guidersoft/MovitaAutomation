package pageObjects;

import Base.BaseMovita;
import Utilities.Driver;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDrive;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebDriver;

public class Mov_10 extends BaseMovita {


    public static By lVerifyMap = By.xpath("//span[contains(.,'Raporlar')]");
    public static By lRaporlarSubMenu = By.xpath("//li[@class='nav-item has-sub' and contains(.,'Raporlar')]//ul//li[contains(.,'Grup Bazlı')]");
    public static By lRaporlarMenu = By.xpath("//li[@class='nav-item has-sub' and contains(.,'Raporlar')]");
    public static By lHata = By.xpath("//div[@id='toast-container']//div[text()='Kullanıcı Adı Yada Şifre Hatalı']");
    public static By lLogout = By.xpath("//a[contains(.,'Çıkış Yap')]");
    public static By lDemoFilo = By.xpath("//span[contains(.,'Demo')]");
    public static By lBacktoHomePage = By.xpath("//a[contains(.,'Ana sayfaya dön')]");
    By lLoginFormSubmitButton = By.xpath("//form//button[@type='submit']");
    By lDetaylıFiltre = By.xpath("//span[contains(.,'Detaylı Filtre')]");
    public static final By lAracDropDownMenu = By.xpath("//span[@role='presentation']");
    public static final By lStartDateDropDownMenu = By.xpath("//div[@class='card']//div[@class='form-group']");
    By lDetaylıFiltre = By.xpath("//span[contains(.,'Detaylı Filtre')]");
    public static final By lAracDropDownMenu = By.xpath("//span[@role='presentation']");
    public static final By lStartDateDropDownMenu = By.xpath("//div[@class='card']//div[@class='form-group']");


    public static final By lHata = By.xpath("//div[@id='toast-container']//div[text()='Kullanıcı Adı Yada Şifre Hatalı']");
    public static final By lLogout=By.xpath("//a[contains(.,'Çıkış Yap')]");
    public static final By lDemoFilo=By.xpath("//span[contains(.,'Demo')]");
    public static final By lLoginFormAnaSayfayaDon = By.xpath("//a[contains(.,'Ana sayfaya dön')]");




    public static By loginFormİnput(String text) {
        return By.xpath("//form[@class='needs-validation mb-2 mt-10']//input[@id='" + text + "']");

    }

    public static By raporlarSubMenu(String text) {
        return By.xpath("//a[contains(.,'" + text + "')]");

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
   /* public static By logout(String text){
        return By.xpath("//a[contains(.,'"+text+"')]");
    }
    public  static By anasayfayaDon(String text){
        return By.xpath("//a[contains(.,'"+text+"')]");
    }*/

        //div[@class='dt-buttons']//a[contains(@title,Pdf Olarak İndir)]

    }

    public static By selectDateMenu(String text) {
        return By.xpath("//div[@class='form-group']//input[@id='" + text + "']");


    public static WebElement aracSelect(String text) {
        WebElement element = driver.findElement(By.xpath("//div[@class='card']//select[@id='aracSelect']//option[contains(.,'" + text + "')]"));
        return element;

    }

    public static WebElement selectMonth() {
        WebElement webElement = driver.findElement(By.xpath("//select[@class='monthselect']"));
        return webElement;
    }

    public static WebElement selectYear() {
        WebElement webElement = driver.findElement(By.xpath("//select[@class='yearselect']"));
        return webElement;

    }


    public static WebElement username_password(String text) {
        WebElement element = driver.findElement(By.xpath("(//div[contains(., '" + text + "' )])[4]"));
        return element;
    }
}









    public static By selectDateMenu(String text) {
        return By.xpath("//div[@class='form-group']//input[@id='" + text + "']");

    }

    public static WebElement selectMonth() {


        return selectMonth(1);
    }
    public static WebElement selectMonth(int index) {

        WebElement element = driver.findElement(By.xpath("(//select[@class='monthselect'])["+index+"]"));
        return element;
    }

    public static WebElement selectYear() {

        WebElement element = driver.findElement(By.xpath("//select[@class='yearselect']"));

        return element;
    }

    public static WebElement username_password(String text){
        WebElement element = driver.findElement(By.xpath("(//div[contains(., '"+text+"' )])[4]"));
        return element;
    }


