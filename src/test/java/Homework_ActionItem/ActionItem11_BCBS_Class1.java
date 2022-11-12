package Homework_ActionItem;

import Reusable_Library.ReusableActions_Loggers;
import Reusable_Library.Reusable_Annotations_Loggers;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ActionItem11_BCBS_Class1 extends Reusable_Annotations_Loggers {

    @Test
    public void Class1_US01_G4_16() throws InterruptedException {
        driver.navigate().to("https://www.bcbs.com/find-a-doctor");
        Thread.sleep(2000);
        ReusableActions_Loggers.mouseHover(driver,"//strong[text()='Outside the United States']",logger,"Global doctor link");
        Thread.sleep(3000);
//        String isElementUnderlined = driver.findElement(By.xpath("//strong[text()='Outside the United States']")).getCssValue("background-color");
//        logger.log(LogStatus.INFO,"The text looks like:"+isElementUnderlined);
    }//end of test 1

     @Test
    public void Class1_US02_G4_28() throws InterruptedException {
         driver.navigate().to("https://www.bcbs.com/find-a-doctor");
         Thread.sleep(2000);
        ReusableActions_Loggers.clickAction(driver,"//strong[text()='Outside the United States']",logger,"Global doctor link");
        Thread.sleep(3000);
        ReusableActions_Loggers.switchToTabByIndex(driver,1,logger,"switch to new tab");
        String tabName = driver.getTitle();
        logger.log(LogStatus.INFO,"Tab nam: " + tabName);
     }//end of test 2

    @Test
    public void Class1_US03_G4_05() throws InterruptedException {
        driver.navigate().to("https://www.bcbs.com/find-a-doctor");
        Thread.sleep(3000);
        ReusableActions_Loggers.clickAction(driver,"//strong[text()='Outside the United States']", logger, "Global doctor link");
        ReusableActions_Loggers.switchToTabByIndex(driver,2,logger,"switch to new tab");
        ReusableActions_Loggers.clickAction(driver, "//*[@name='AlphaPrefix']",logger,"click id field");
        ReusableActions_Loggers.sendKeysAction(driver,"//*[@name='AlphaPrefix']","236",logger,"input 3 character");
        ReusableActions_Loggers.clickAction(driver,"//*[@class='btn btn-success btn-lg pad20']",logger,"clicking submit");

    }//end of test 3

}//end of java class
