package Locaators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface Locator {
    String url = "https://movita.com.tr/";
    String str = "Mobil Vasıta İzleme Takip Sistemi";
    By llogo = By.xpath("//div[@id='logo']");
    By lMobilVasita = By.xpath("//div[@class='tp-mask-wrap']//div[text()='"+str+"']");
    By lEnterButton = By.xpath("//button[@id='dropdownMenuButton']/parent::div");
    By lEnglishLang = By.xpath("//a[contains(.,'English')]");
    By lTurkishLang = By.xpath("//a[contains(.,' Türkçe')]");
    By lAnaSayfa = By.xpath("//ul[@class='menu-container']//div[text()='Ana Sayfa']");
    By lSubMenuKurumsal=By.xpath("(//ul[@class='sub-menu-container'])[1]//div");
    By lLoginFormSubmitButton = By.xpath("//form//button[@type='submit']");
    By lMobilVasıtaTurkish = By.xpath("//div[@class='tp-mask-wrap']//div[contains(text(),'Mobil Vasıta')]");
    By lMobilVasıtaEnglish=By.xpath("//div[@class='tp-mask-wrap']//div[contains(text(),'Mobile Vehicle')]");
    By LDetaylıFiltre=By.xpath("//span[contains(.,'Detaylı Filtre')]");
    By lLogoutDemoFilo=By.xpath("//div//a[contains(.,'Çıkış Yap')]");
    By lAnasayfayaDon=By.xpath("//div//a[@href='/'][contains(.,'Ana sayfaya dön')]");
    By lLangButton=By.xpath("//button[@type='button']");

    WebElement homePageMenu(String text);

}

