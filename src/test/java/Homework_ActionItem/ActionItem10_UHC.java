package Homework_ActionItem;

import Reusable_Library.ReusableActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class ActionItem10_UHC {

    WebDriver driver;
    @BeforeSuite
    public void SetChromeDriver(){
        driver = ReusableActions.setUpDriver();
    }//end of set driver method

    @AfterSuite
    public void quitTheSession(){
        driver.quit();
    }//end of after suite

    @Test()
    public void FindADentist() throws InterruptedException {
        driver.navigate().to("https://www.uhc.com/");
        Thread.sleep(2000);
        ReusableActions.clickAction(driver, "//a[text()='Find a doctor']","clicking on find a doctor");
        ReusableActions.scrollByViewElement(driver, "//*[@class='component heading aem-GridColumn aem-GridColumn--default--12']", "scroll to view find a dentist");
        ReusableActions.clickAction(driver, "//*[text()='Find a dentist']","clicking on find a dentist");
        Thread.sleep(3000);
        driver.navigate().refresh();
        Thread.sleep(3000);
        ReusableActions.switchToTabByIndex(driver,1,"switching to new tab");
        ReusableActions.clickActionByIndex(driver,"//*[@class='copy']",0,"clicking on employer and individual plans");
    }//end of test

    @Test(dependsOnMethods = "FindADentist")
    public void zipCode() throws InterruptedException {
        ReusableActions.sendKeysAction(driver,"//*[@name='input']", "11218","enter zipCode on address bar");
        Thread.sleep(2000);
        ReusableActions.clickAction(driver, "//*[@type='submit']", "clicking continue");
        ReusableActions.clickAction(driver, "//*[text()='*National Options PPO 30']", "clicking on National Options PPO");
        Thread.sleep(3000);
        driver.navigate().refresh();
        Thread.sleep(3000);
        ReusableActions.clickActionByIndex(driver, "//*[@class='sc-gSYDnn fslDuO']", 0,"clicking on General Dentist");
    }//end of test

    @Test(dependsOnMethods = "zipCode")
    public void captureDoctorDetails() throws InterruptedException {
        ReusableActions.selectByText(driver, "//*[@id='distance']", "Within 5 Miles", "selecting 5 mile in dropDown");
        Thread.sleep(3000);
        driver.navigate().refresh();
        Thread.sleep(3000);
        ReusableActions.selectByText(driver, "//*[@id='distance']", "Within 5 Miles", "selecting 5 mile in dropDown");
        ReusableActions.clickActionByIndex(driver, "//*[@class='sc-bXmHAB ITGjV providerName']/a",0,"clicking on first doctor link");
        ReusableActions.clickAction(driver,"//*[@class='cta-header-button action-btn saved-provider-button negative']","clicking on save");
        String addressValue = ReusableActions.getTextActionByIndex(driver, "//*[@class='td c-4-dt-tbl']",0,"capturing address");
        //splitting address by line
        String[] addressValueSplit = addressValue.split("\\R");
        String milesValue = ReusableActions.getTextActionByIndex(driver,"//*[@data-test-id='distance-away']",1,"capture miles value");
        String networkValue = ReusableActions.getTextActionByIndex(driver,"//*[@class='networkStatus icon-txt fwMed ']",1,"capturing network");

        System.out.println("Address: " + addressValueSplit[1]+ "\n" + addressValueSplit[2] + "\n" + " Miles: " + milesValue + "\n" + " Network: " + networkValue);
        //closing 2nd tab
        driver.close();
    }//end of test

    @Test(dependsOnMethods = "captureDoctorDetails")
    public void captureSearchResult(){
        ReusableActions.switchToTabByIndex(driver,0,"switching back to old tab");
        ReusableActions.clickAction(driver,"//*[@id='search-desktop']","clicking search field");
        ReusableActions.sendKeysAction(driver,"//*[@id='search-desktop']","doctor","typing doctor on search field");
        driver.findElement(By.xpath("//*[@id='search-desktop']")).submit();
        String result = ReusableActions.getTextAction(driver,"//*[@id='search-results-count__header']","capturing result");
        //splitting result to print only the first part
        String[] resultSplit = result.split("results");
        System.out.println("Search result: " + resultSplit[0]);

    }//end of test
}//end of java class
