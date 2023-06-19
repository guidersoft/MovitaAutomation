package stepdefs;

import Base.BaseMovita;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.Move_20;

import java.util.List;

public class Mov_20ST extends BaseMovita {
    @When("user hover over the kurumsal title")
    public void userHoverOverTheKurumsalTitle() {
        hoverOver(homePageMenu("Kurumsal"));

    }

    @And("user clicks to hakkımızda subtitle")
    public void userClicksToHakkımızdaSubtitle() {
        bekle(500);
        click(MainSubtitle("Hakkımızda"));
    }

    @And("user verify to heading blocks")
    public void userVerifyToHeadingBlocks(DataTable table) {
        bekle(500);
        List<String> list = table.asList();
        for (String s : list) {
            visible(Move_20.headingBlocks(s));
        }

    }
    @And("user hover over the arrow icons color should be changables")
    public void userHoverOverTheArrowIconsColorShouldBeChangables() {
        bekle(500);
        scroll();
        String beforeColor = driver.findElement(Move_20.lIcon).getCssValue("backgroun-color");
        hoverOver(driver.findElement(Move_20.lIcon));
        String afterColor = driver.findElement(Move_20.lIcon).getCssValue("color");
        Assert.assertNotEquals(beforeColor,afterColor);


    }
}
