package Homework_ActionItem;

import Reusable_Library.ReusableActions_Loggers;
import Reusable_Library.Reusable_Annotations_Loggers;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionItem11_BCBS_Class2 extends Reusable_Annotations_Loggers {

    @Test
    public void Class2_US01_G4_74() throws InterruptedException {
        driver.navigate().to("https://www.bcbs.com/find-a-doctor");
        ReusableActions_Loggers.clickActionByIndex(driver,"//*[text() = 'In the United States, Puerto Rico and U.S. Virgin Islands']",1,"doctor search link");
        Thread.sleep(2000);
        ReusableActions_Loggers.clickAction(driver,"//*[@id='button-welcome']",logger,"click choose a destination");
        ReusableActions_Loggers.sendKeysAction(driver,"//*[@id='input-location']","11218",logger,"input zipcode");
        Thread.sleep(2000);
        ReusableActions_Loggers.clickAction(driver,"//*[@id='CONFIRM_LOCATION_TRIGGER']",logger,"Confirm address");
        Thread.sleep(2000);
        ReusableActions_Loggers.clickAction(driver,"//*[@id='CONFIRM_LOCATION_TRIGGER']",logger,"Confirm address");
        Thread.sleep(2000);
    }//end of test1

    @Test
    public void Class2_US02_G4_75() throws InterruptedException {
        ReusableActions_Loggers.mouseHoverClick(driver,"//*[text()='Browse a list of plans']",logger,"Click browse plan");
        Thread.sleep(2000);
        ReusableActions_Loggers.mouseHoverClick(driver,"//*[@class='h4 line-height-custom mb-0 flex-grow-1']",logger,"Click browse plan");
        Thread.sleep(2000);
        ReusableActions_Loggers.mouseHoverClick(driver,"//*[@class='rad-button btn btn-success ember-view btn-lg w-100 mt-4']",logger,"Click browse plan");
        Thread.sleep(2000);
    }//end of test 2

    @Test()
    public void Class2_US03_G4_112() throws InterruptedException {
        ReusableActions_Loggers.mouseHover(driver,"//*[text()='Doctors by name']",logger,"hover over doctors by name");
        Thread.sleep(2000);
        String doctorsByName = ReusableActions_Loggers.getTextActionByIndex(driver,"//*[@class='category-description ws-normal']",0,logger,"capture doctors by name description");
        logger.log(LogStatus.INFO,"Doctors by name description: " + doctorsByName);

        ReusableActions_Loggers.mouseHover(driver,"//*[text()='Doctors by name']",logger,"hover over doctors by name");
        Thread.sleep(2000);
        String doctorsBySpecialty = ReusableActions_Loggers.getTextActionByIndex(driver,"//*[@class='category-description ws-normal']",1,logger,"capture doctors by name description");
        logger.log(LogStatus.INFO,"Doctors by specialty description: " + doctorsBySpecialty);

        ReusableActions_Loggers.mouseHover(driver,"//*[text()='Doctors by name']",logger,"hover over doctors by name");
        Thread.sleep(2000);
        String placesByName = ReusableActions_Loggers.getTextActionByIndex(driver,"//*[@class='category-description ws-normal']",2,logger,"capture doctors by name description");
        logger.log(LogStatus.INFO,"Places by name description: " + placesByName);

        ReusableActions_Loggers.mouseHover(driver,"//*[text()='Doctors by name']",logger,"hover over doctors by name");
        Thread.sleep(2000);
        String placesByType = ReusableActions_Loggers.getTextActionByIndex(driver,"//*[@class='category-description ws-normal']",3,logger,"capture doctors by name description");
        logger.log(LogStatus.INFO,"Places by type description: " + placesByType);

    }//end of test 2


}//end of java class
