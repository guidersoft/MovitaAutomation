package pageObjects;

import Base.BaseMovita;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Mov_12_SmokeTest extends BaseMovita {
    public static final By lRaporlarSubtitle = By.xpath("(//ul[@class='menu-content'])[1]//li");

    public static WebElement raporlarSubtitle(String text){
        WebElement element = driver.findElement(By.xpath("(//ul[@class='menu-content'])[1]//a[contains(.,'" + text + "')]"));
        return  element;
    }
    public void mov_12_changeColor (String text){
        String beforeColor = Mov_12_SmokeTest.raporlarSubtitle(text).getCssValue("background-color");
        click(Mov_12_SmokeTest.raporlarSubtitle(text));
        String afterColor  = Mov_12_SmokeTest.raporlarSubtitle(text).getCssValue("color");
        Assert.assertNotEquals(beforeColor,afterColor);



    }
}
