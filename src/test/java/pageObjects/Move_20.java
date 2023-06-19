package pageObjects;

import Base.BaseMovita;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class Move_20 extends BaseMovita {
    public static final By lHeadingBlock=By.xpath("//span[contains(.,'Misyonumuz')]");

    public static final By lHeadingBlock2=By.xpath("//section[@id='content']//h4");

    public static final By lIcon=By.xpath("//div[@id='gotoTop']");


    public static WebElement headingBlocks(String text){
        WebElement element = driver.findElement(By.xpath("//span[contains(.,'"+text+"')]"));
        return element;
    }

    public  void changeColor(By locator,String color){
        String beforeColor =driver.findElement(locator).getCssValue(color);

        hoverOver(driver.findElement(locator));
        String afterColor = driver.findElement(locator).getCssValue(color);
        Assert.assertNotEquals(beforeColor,afterColor);
    }
    public  void clickChangeColor(By locator, String color){
        String beforeColor =driver.findElement(locator).getCssValue(color);
        click(driver.findElement(locator));
        String afterColor = driver.findElement(locator).getCssValue(color);
        Assert.assertNotEquals(beforeColor,afterColor);

    }

}