package stepdefs;

import Base.BaseMovita;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pageObjects.Move_124;

import java.util.List;

public class Mov_124_Stepdefs extends BaseMovita {
    @And("user clicks to alarm operations and verify")
    public void userClicksToAlarmOperationsAndVerify() {
        click(Move_124.lAlarmButton);
        visible(Move_124.lVerifyAlarmPage);
    }

    @And("user clicks the detailed filters and verify of the subtitle")
    public void userClicksTheDetailedFiltersAndVerifyOfTheSubtitle(DataTable table) {
        click(Move_124.lDetaylıFiltre);
        List<String> list1 = table.asList();
        for (String list : list1) {
            visible(Move_124.subtitlesOfDetailedFilter(list));
        }
    }
/*
    @And("user click to add alarm button")
    public void userClickToAddAlarmButton() {
        click(Move_124.lAddAlarm);
    }*/

    @And("user verify  to attention warning")
    public void userVerifyToAttentionWarning() {
        bekle(500);
        click(Move_124.lAddAlarm);
        visible(Move_124.lAttentionInf);
    }

    @And("user verify to alarm information and subtitles")
    public void userVerifyToAlarmInformationAndSubtitles(DataTable table) {
        List<String> list = table.asList();
        List<WebElement> elements = driver.findElements(Move_124.alarmInformationAndSubtitles());

        for (WebElement element : elements) {
            visible(element);

        }
    }

    @And("user verify alarm type of subtitles")
    public void userVerifyAlarmTypeOfSubtitles(DataTable table) {
        List<String> list = table.asList();
        Select select = new Select(driver.findElement(Move_124.alarmTipeOfSubtitle()));
        for (String s : list) {
            select.selectByVisibleText(s);
        }
    }

    @And("user verify to sms notification")
    public void userVerifyToSmsNotification(DataTable table) {
        List<String> list = table.asList();
        Select select = new Select(driver.findElement(Move_124.smsNotificiation()));
        for (String sms : list) {
            select.selectByVisibleText(sms);
        }
    }

    @And("user select content of subtitle")
    public void userSelectContentOfSubtitle(DataTable table) {
        List<String> list = table.asList();
        for (String s : list) {
            click(Move_124.contentOfSubtitle(s));
        }
    }

    @And("user select  based of group and verify to group and dropdown menu titles")
    public void userSelectBasedOfGroupAndVerifyToGroupAndDropdownMenuTitles(DataTable table) {
        click(Move_124.lBasedGroup);
        List<String> list = table.asList();
        Select select = new Select(driver.findElement(Move_124.basedOfGroupAndVerifyToGroupAndDropdownMenuTitles()));
        for (String s : list) {
            select.selectByVisibleText(s);

        }
    }

    @And("user select  based of vehicle and verify to vehicle  and dropdown menu titles")
    public void userSelectBasedOfVehicleAndVerifyToVehicleAndDropdownMenuTitles() {
        click(Move_124.lVechileBased);
        Select select = new Select(driver.findElement(Move_124.BasedOfVehicleAndVerifyToVehicleAndDropdownMenuTitle()));
        List<WebElement> elements = driver.findElements(Move_124.BasedOfVehicleAndVerifyToVehicleAndDropdownMenuTitles());
        for (int i = 0; i < elements.size(); i++) {
            select.selectByIndex(i);
        }
    }

    @And("user select to active days of week of {string}")
    public void userSelectToActiveDaysOfWeekOf(String text) {
        //click(driver.findElement(Move_124.activeDaysOfWeek(text)));
        Select select = new Select(driver.findElement(By.xpath("//select[@id='kural_gun']")));
        select.selectByVisibleText(text);
    }

    @And("user clicks and verify the save button")
    public void userClicksAndVerifyTheSaveButton() {
        scroll();
        bekle(500);
        click(Move_124.lsaveButton1);
        visible(Move_124.lVerifyAlarmPageOfAlarmType);

    }

    @And("alarm should be arrangeable and erasable")
    public void alarmShouldBeArrangeableAndErasable() {
        click(Move_124.larrangeable);
        Select select = new Select(driver.findElement(By.xpath("//select[@id='kural_gun']")));
        select.selectByVisibleText("Çarşamba");
        scroll();
        click(Move_124.lsaveButton1);
        click(Move_124.leraseble);
        inVisible(Move_124.lverifyOfEraseble);


    }
}