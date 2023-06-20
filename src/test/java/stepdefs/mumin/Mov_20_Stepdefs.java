package stepdefs.mümin;


import Base.BaseMovita;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pageObjects.Move_20;
import java.util.List;


public class Mov_20_Stepdefs extends BaseMovita {


    @When("user hover over the ınstituonal title")
    public void userHoverOverTheInstituonalTitle() {

        hoverOver(homePageMenu("Kurumsal"));

    }

    @And("user clicks to about us title")
    public void userClicksToAboutUsTitle() {
        click( MainSubtitle("Hakkımızda"));
    }

    @And("user verify to heading block")
    public void userVerifyToHeadingBlock(DataTable table) {
        scroll();

        /*List<WebElement> elements = driver.findElements(By.xpath("//section[@id='content']//h4"));
        for (WebElement element : elements) {
            visible(element);


        }*/

        List<String> list = table.asList();
        for (String s : list) {
            visible(Move_20.headingBlocks(s));

        }
        // visible(Move_20_smokeTest.headingBlocks(headingBlock));

    }

    @And("user hover over the arrow icons color should be changable")
    public void userHoverOverTheArrowIconsColorShouldBeChangable() {
        bekle(500);
        // scroll();
        changeColor("click","background-color",Move_20.lIcon);
        /*String beforeColor =driver.findElement(Move_20_smokeTest.lIcon).getCssValue("background-color");
        bekle(200);
        hoverOver(driver.findElement(Move_20_smokeTest.lIcon));
        String afterColor = driver.findElement(Move_20_smokeTest.lIcon).getCssValue("color");
        Assert.assertNotEquals(beforeColor,afterColor);*/

    }

    @And("user click to arrow icons the turn back to about us page")
    public void userClickToArrowIconsTheTurnBackToAboutUsPage() {
        // scroll();
        /*JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollBy(500, 500)");*/
        click(Move_20.lIcon);
        visible(llogo);
    }


}