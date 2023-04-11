package Locaators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.StringReader;

public interface Locator {
    String url = "https://movita.com.tr/";


    By llogo = By.xpath("//a[@class='standard-logo']");

    By lMobilVasıtaTurkish = By.xpath("//div[@class='tp-mask-wrap']//div[contains(text(),'Mobil Vasıta')]");

    By lMobilVasıtaEnglish=By.xpath("//div[@class='tp-mask-wrap']//div[contains(text(),'Mobile Vehicle')]");


    By lEnterButton = By.xpath("//button[@id='dropdownMenuButton']");
    By lEnglishLang = By.xpath("(//button[@id='dropdownMenuButton']/parent::div//a)[1]");
    By lTurkishLang = By.xpath("(//button[@id='dropdownMenuButton']/parent::div//a)[2]");

    By lHeaderMenuLink = By.xpath("//ul[@class='menu-container']//div");

    By lAnaSayfa = By.xpath("//ul[@class='menu-container']//div[text()='Ana Sayfa']");

    By lSubMenuKurumsal=By.xpath("(//ul[@class='sub-menu-container'])[1]//div");

    WebElement homePageMenu(String text);



}
