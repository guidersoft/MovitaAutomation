package pageObjects;

import Base.BaseMovita;
import org.openqa.selenium.By;

public class Move_124 extends BaseMovita {
    public static final By lAlarmButton = By.xpath("//li[@id='alarm_listesi']//span");
    public static final By lVerifyAlarmPage = By.xpath("//h3[contains(.,'Bölge İhlali - Bölge Giriş Çıkış Alarmı')]");
    public static final By lVerifyAlarmPageOfAlarmType = By.xpath("//th[.='Alarm Tipi']");
    public static final By lAlarmCode = By.xpath("//label[contains(.,'Alarm Kodu')]");
    public static final By lDetaylıFiltre = By.xpath("//span[contains(.,'Detaylı Filtre')]");
    //public static final By lVerifyExplanation=By.xpath("//label[@for='aciklama_filter']");
    public static final By lAddAlarm = By.xpath("//li[@class='nav-item']//a[@href='/alarm-ekle'][contains(.,'Alarm Ekle')]");
    public static final By lAttention = By.xpath("//div//button//span[@aria-hidden='true']");
    public static final By lAttentionInf = By.xpath("//div[@class='alert alert-warning alert-dismissible mb-2' and contains(.,'Dikkat!')]");
    public static final By lAlarmType = By.xpath("//label[@for='kural_tipi_filter']");
    public static final By lBasedGroup = By.xpath("//span[text()='Grup Bazlı']");
    public static final By lVechileBased = By.xpath("//span[text()='Araç Bazlı']");
    public static final By lActiveDays = By.xpath("//span[text()='Araç Bazlı']");
    public static final By lActiveDays1 = By.xpath("//select[@id='kural_gun']");
    public static final By lsaveButton = By.xpath("//button[contains(.,'Kaydet')]']");
    public static final By lsaveButton1 = By.xpath("//button[@class='btn btn-secondary pull-right']");
    public static final By larrangeable = By.xpath("//span//i[@class='icon-pencil'][1]");
    public static final By leraseble = By.xpath("//span[@class='tag tag-default tag-danger']/i[1]");
    public static final By lverifyOfEraseble = By.xpath("//*[.='K-0UGF55OTHB66']");

    public static final By subtitlesOfDetailedFilter(String text) {
        return By.xpath("//div//label[text()='" + text + "']");


    }

    public static By alarmInformationAndSubtitles() {
        return By.xpath("//h4[@class='form-section']/following-sibling::div[position()=1 or" +
                " position()=2]//label | //div[normalize-space()='Aktif Günler']");

    }

    public static By alarmTipeOfSubtitle() {
        return By.xpath("//div/label[contains(.,'Alarm Tipi') ]/parent::div//select");
    }

    public static By smsNotificiation() {
        return By.xpath("//div/label[contains(.,'Sms Bildirim') ]/parent::div//select");
    }

    public static By contentOfSubtitle(String text) {
        return By.xpath("//div/label[contains(.,'Kapsamı') ]/parent::div//label//span[text()='" + text + "']");
    }

    public static By basedOfGroupAndVerifyToGroupAndDropdownMenuTitles() {
        return By.xpath("//div//select[@id='grup_id']");
    }

    public static By BasedOfVehicleAndVerifyToVehicleAndDropdownMenuTitle() {
        return By.xpath("//div/select[@id='plaka']");
    }

    public static By BasedOfVehicleAndVerifyToVehicleAndDropdownMenuTitles() {
        return By.xpath("//div/select[@id='plaka']//option");
    }

    public static By activeDaysOfWeek(String text) {
        return By.xpath(String.format("//li[contains (@class,'option') and text()='%s']", text));
    }
}