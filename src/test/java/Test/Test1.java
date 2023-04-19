package Test;

import Base.BaseMovita;
import org.testng.annotations.*;

public class Test1 extends BaseMovita {


    @Test(priority = 0)
    public void openMovita(){
        open();
    }

    @Test(priority = 1,dependsOnMethods = "openMovita")
    public void logo(){
        click(llogo);
        bekle(3000);
        visible(lMobilVasita);

        //assertElement(lMobilVasıta,str);

        getScreenshot("MobilVasıta");
    }
    @Test(priority = 3)
    public void enterButton(){
        click(lEnterButton);
        click(lTurkishLang);
        bekle(500);
        getScreenshot("login");
        bekle(500);

    }
    @Test(priority = 2)
    public void enterButton2(){
        click(lEnterButton);
        click(lEnglishLang);
        bekle(500);
        getScreenshot("Giris");


    }
    @Test(priority = 4,dependsOnMethods = "openMovita")
    public void homePage(){
        hoverOver(homePageMenu("Ana Sayfa"),"Ana Sayfa");
        visible(lMobilVasita);

    }
    @Test(priority = 5,dependsOnMethods = "openMovita")
    public void kurumsal(){
        hoverOver(homePageMenu("Kurumsal"),"Kurumsal");
        hoverAll(lSubMenuKurumsal);

    }


}
