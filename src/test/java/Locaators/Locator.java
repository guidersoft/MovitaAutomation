package Locaators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface Locator {
    String url = "https://movita.com.tr/";
    String str = "Mobil Vasıta İzleme Takip Sistemi";
    By llogo = By.xpath("//div[@id='logo']");
    By lMobilVasita = By.xpath("//div[@class='tp-mask-wrap']//div[text()='"+str+"']");

    By lEnterButton = By.xpath("//button[@id='dropdownMenuButton']/parent::div");
    By lEnglishLang = By.xpath("(//button[@id='dropdownMenuButton']/parent::div//a)[1]");
    By lTurkishLang = By.xpath("(//button[@id='dropdownMenuButton']/parent::div//a)[2]");
    By lHeaderMenuLink = By.xpath("//ul[@class='menu-container']//div");
    By lAnaSayfa = By.xpath("//ul[@class='menu-container']//div[text()='Ana Sayfa']");
    By lSubMenuKurumsal=By.xpath("(//ul[@class='sub-menu-container'])[1]//div");
    By lLoginFormLoginButton=By.xpath("//button[@type='submit']");

    WebElement homePageMenu(String text);


    String TOP_MENU = "//*[@id='header-wrap']//a[contains(.,'%s')]";
    By lLanguageOptionButton = By.xpath("//div[@class='dropdown dropdown-langs']//button");
    By lTextOfMobilVasitaIzlemeTakipSistemi = By.xpath("//div[@class='tp-mask-wrap']//div[contains(text(),'Mobil')]");
    By lLoginFormUsername = By.id("username");
    By lLoginFormPassword = By.id("password");
    By lLoginFormSubmitButton = By.xpath("//form//button[@type='submit']");
    By lLoginFormUsernameWarningMessage = By.xpath("//div[contains(text(),'Lütfen kullanıcı adı girin!')]");
    By lLoginFormPasswordWarningMessage = By.xpath("//div[contains(text(),'Lütfen şifre girin!')]");
    By lLoginFormInvalidUsernamePasswordWarningMessage = By.xpath("//div[@class='toast-message']");
    By lDemoFileDropdownMenuLogout = By.xpath("//a[contains(.,' Çıkış Yap')]");
    By lDemoFileDropdownMenu = By.xpath("//a[contains(.,'Demo Filo (129)')]");
    By lLoginFormAnaSayfayaDon = By.xpath("//a[contains(.,'Ana sayfaya dön')]");
    By lLoginFormBackToHomepage = By.xpath("//a[contains(.,'back to home page')]");
    By lMobilVasıtaTurkish = By.xpath("//div[@class='tp-mask-wrap']//div[contains(text(),'Mobil Vasıta')]");
    By lMobilVasıtaEnglish=By.xpath("//div[@class='tp-mask-wrap']//div[contains(text(),'Mobile Vehicle')]");
    By lKurumsal = By.xpath("//ul[@class='menu-container']//div[text()='Kurumsal']");
    By lSubMenuUrunler=By.xpath("(//ul[@class='sub-menu-container'])[2]//div");
    By lSubMenuCozumler=By.xpath("(//ul[@class='sub-menu-container'])[3]//div");

    By lSubTitlesKurumsal=By.xpath("//div[text()='Belgelerimiz']");
    By lSubMenuKurumsalVerify=By.xpath("//h1[text()='Bayilik Başvuru']");
     By lHata = By.xpath("//div[@id='toast-container']//div[text()='Kullanıcı Adı Yada Şifre Hatalı']");
    By lVerifyMap=By.xpath("//span[contains(.,'Raporlar')]");
    By lLogOut= By.xpath("//a[contains(.,'Çıkış Yap')]");
    By lDemoFilo= By.xpath("//span[contains(.,'Demo')]");
    By lRaporlarMenu=By.xpath("//li[@class='nav-item has-sub' and contains(.,'Raporlar')]");
    By lDetaylıFiltre=By.xpath("//span[contains(.,'Detaylı Filtre')]");




}
