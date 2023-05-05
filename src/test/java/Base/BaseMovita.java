package Base;

import Locators.Locator;
import Utilities.Driver;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import readers.MyPojo;

import java.io.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BaseMovita implements Locator {
    protected WebDriver driver;
    protected WebDriverWait wait;

    {
        driver =Driver.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    public void open() {
        driver.get(url);
    }

    public void click(By locator){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        click(element);

    }
    public void click(WebElement element) {
        wait.until(driver -> {
            try {
                element.click();
                return true;
            } catch (Exception e1) {
                try {
                    new Actions(driver).moveToElement(element).click().perform();
                    return true;
                } catch (Exception e2) {
                    try {
                        ((JavascriptExecutor) driver).executeScript("argument[0].click", element);
                        return true;
                    } catch (Exception e3) {
                        return false;
                    }

                }


            }

        });
    }

        public void visible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void visible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void assertElement(By locator, String str) {

        WebElement element = driver.findElement(locator);
        String text = element.getText();
        System.out.println(text);
        //bekle(1000);
        Assert.assertEquals(text, str);


    }

    public void bekle(long milis) {
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public void getScreenshot(String name) {

        String isim = "test-output/screenShots/" + name + " " + LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("dd_MM_yyyy HH-mm-ss")) + ".png";

        TakesScreenshot takesScreenshot = ((TakesScreenshot) driver);

        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File target = new File(isim);

        try {
            FileUtils.copyFile(source, target);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void hoverOver(WebElement element) {
        new Actions(driver)
                .moveToElement(element)
               .build()
                .perform();
    }

    public void hoverAll(By locator) {
        List<WebElement> list = driver.findElements(locator);

        for (WebElement element : list) {
            new Actions(driver)
                    .moveToElement(element)
                    .build()
                    .perform();
        }
    }


    @Override
    public WebElement homePageMenu(String text) {
        WebElement element = driver.findElement(By.xpath("//div[@class='header-row']//div[text()='" + text + "']"));

        return element;
    }


    public void assertChangeColor(WebElement element, String color) {
        String bgColorRGB = element.getCssValue("color");
        String bgColorHex = Color.fromString(bgColorRGB).asHex();
        Assert.assertEquals(bgColorHex, color);
    }

    public void assertChangeColor(By locator, String color) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        assertChangeColor(element, color);
    }

    public void hoverOverByAction(WebElement element) {
        new Actions(driver)
                .moveToElement(element)
                .pause(500)
                .build()
                .perform();
    }

    public void hoverOverByAction(By locator) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        hoverOverByAction(element);
    }

    public By xpath(String locator, String text) {
        return By.xpath(String.format(locator, text));
    }

    public void sendKeys(WebElement element, String text) {
        //wait.until(ExpectedConditions.elementToBeClickable(element)).click();

        wait.until(driver1 -> {
            try {
                element.clear();
                element.sendKeys(text);
                return true;
            } catch (java.lang.Exception e1) {
                try {
                    element.clear();
                    new Actions(driver1).moveToElement(element).sendKeys(text).perform();
                    return true;
                } catch (java.lang.Exception e2) {
                    try {
                        element.clear();
                        ((JavascriptExecutor) driver1).executeScript("arguments[0].value='" + text + "'", element);
                        return true;
                    } catch (java.lang.Exception e3) {
                        return false;
                    }
                }
            }
        });
    }

    public void sendKeys(By locator, String text) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        sendKeys(element, text);
    }

    public List<String> getExcelColValuesOf(String fileName, int page, int colNumber) {
        try {
            List<String> myList = new ArrayList<>();
            FileInputStream fileInputStream = new FileInputStream(fileName);
            Workbook workbook = WorkbookFactory.create(fileInputStream);
            Sheet sheet = workbook.getSheetAt(0);
            int lastRow = sheet.getPhysicalNumberOfRows();

            int index = colNumber - 1;
            if (index < 0) index = 0;
            if (index > 2) index = 2;

            for (int i = 0; i < lastRow; i++) {
                Row row = sheet.getRow(i);
                Cell cell = row.getCell(index);
                String val = cell == null ? "" : cell.toString();
                myList.add(val);
            }

            workbook.close();
            fileInputStream.close();
            myList.remove(0);
            return myList;

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public MyPojo getPojo(String file, MyPojo pojo) {
        String[] arr = file.split("[.]");
        String fileType = arr[arr.length - 1].toLowerCase();
        try {
            switch (fileType) {
                case "json" -> {
                    ObjectMapper mapperJson = new ObjectMapper();
                    return mapperJson.readValue(new FileReader(file), pojo.getClass());
                }
                case "yaml" -> {
                    ObjectMapper mapperYaml = new ObjectMapper(new YAMLFactory());
                    return mapperYaml.readValue(new FileReader(file), pojo.getClass());
                }
                default -> throw new RuntimeException(file + " is not .yaml or .json file");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
    public WebElement MainSubtitle(String text) {
        WebElement element = driver.findElement(By.xpath("//ul[@class='sub-menu-container']//div[text()='" + text + "']"));
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }
    public void assertChangeColorMainTitle(String text) {

        String beforeColorMainTitle=homePageMenu(text).getCssValue("color");
        System.out.println(beforeColorMainTitle);
        hoverOver(homePageMenu(text));
        String afterColorMainTitle=homePageMenu(text).getCssValue("color");
        System.out.println(afterColorMainTitle);
        Assert.assertNotEquals(beforeColorMainTitle,afterColorMainTitle);
    }

    public void assertChangeColorSubTitle(String text) {
        String beforeColorMainTitle=MainSubtitle(text).getCssValue("color");
        hoverOver(MainSubtitle(text));
        String afterColorMainTitle=MainSubtitle(text).getCssValue("color");
        Assert.assertNotEquals(beforeColorMainTitle,afterColorMainTitle);
    }
    public void visibleVerifyWithSubtitleKurumsal(String text) {
        By lSubTitleVerify=By.xpath("//div//h1[contains(.,'"+text+"')]");
        wait.until(ExpectedConditions.presenceOfElementLocated(lSubTitleVerify));
    }
    public void visibleVerifyWithSubtitleUrunler(String text) {
        By lSubTitleVerify=By.xpath("//div//h3[contains(.,'"+text+"')]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(lSubTitleVerify));
    }
    public void visibleVerifyWithSubtitleCozumler(String text) {

        By lSubTitleVerify=By.xpath("//h2[@class='d-flex'][contains(.,' "+text+"')]");
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(lSubTitleVerify));


    }
    public By loginFormİnput(String text){
        By lLoginForm = By.xpath("//form[@class='needs-validation mb-2 mt-10']//input[@id='"+text+"']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(lLoginForm));
        // WebElement element = driver.findElement(lLoginForm);
        return lLoginForm;

    }
}

