package pageObjects;

import Base.BaseMovita;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Move_12 extends BaseMovita {

    public static final By raporlarSubtitle = By.xpath("(//ul[@class='menu-content'])[1]//li");

    public static WebElement raporlarAltMenu(String text) {
        WebElement element = driver.findElement(By.xpath("(//ul[@class='menu-content'])[1]//a[contains(.,'" + text + "')]"));
        return element;
    }

    public void mov_12_changeColor(String text) {
        String beforeColor =raporlarAltMenu(text).getCssValue("background-color");
        bekle(200);
        click(raporlarAltMenu(text));
        String afterColor = raporlarAltMenu(text).getCssValue("color");
        Assert.assertNotEquals(beforeColor,afterColor);


    }

    public  String xPath(String xpath,String text){
        // "(//ul[@class='menu-content'])[1]//a[contains(.,'" + text + "')]"))
        driver.findElement(By.xpath(String.format("%s,%s",xpath,text)));

        return null;
    }
}