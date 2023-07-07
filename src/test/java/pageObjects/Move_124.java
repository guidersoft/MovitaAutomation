package pageObjects;

import Base.BaseMovita;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Move_124 extends BaseMovita {

    public static final By lAlarmButton=By.xpath("//li[@id='alarm_listesi']//span");
    public static final By lVerifyAlarmPage=By.xpath("//h3[contains(.,'Bölge İhlali - Bölge Giriş Çıkış Alarmı')]");
    public static final By lAlarmCode=By.xpath("//label[contains(.,'Alarm Kodu')]");
    public static final By lDetaylıFiltre=By.xpath("//span[contains(.,'Detaylı Filtre')]");
    public static final By lVerifyExplanation=By.xpath("//label[@for='aciklama_filter']");
    public static final By lAddAlarm=By.xpath("//li//a[@class='nav-link active']");
    public static final By lAttention=By.xpath("//div//button//span[@aria-hidden='true']");

}