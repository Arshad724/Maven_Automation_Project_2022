package Day11_110522;

import Reusable_Library.ReusableActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class T2_Boolean {
    WebDriver driver;
    @BeforeSuite
    public void SetChromeDriver() {
        driver = ReusableActions.setUpDriver();
    }//end of set driver method
    @AfterSuite
    public void quitTheSession() {
        driver.quit();
    }//end of after suite

    //verify that by default signed in option should be checked
    @Test(priority = 1)
    public void tc001_verifySignedInOptionIsChecked(){
        //navigate to yahoo.cm
        driver.navigate().to("https://www.yahoo.com");
        //next click on sign in button
        ReusableActions.clickAction(driver, "//*[@class = '_yb_1933e']", "sing in button");
        boolean isSignInChecked = driver.findElement(By.xpath("//*[@id = 'persistent']")).isSelected();
        System.out.println("The checkbox check condition is: " + isSignInChecked);
    }//end of test case 1

    //unchecking the checkbox and verifying if boolean captured it & using depends on method
    @Test(dependsOnMethods = "tc001_verifySignedInOptionIsChecked")
    public void tc002_verifySignedInOptionIsUnchecked(){
        //click on checkbox to uncheck
        ReusableActions.clickAction(driver,"//*[@class = 'stay-signed-in checkbox-container']", "SignedInCheckBox");
        //we need to verify if signed in option is checked
        boolean isSignInChecked = driver.findElement(By.xpath("//*[@id = 'persistent']")).isSelected();
        System.out.println("The checkbox check condition is: " + isSignInChecked);
    }//end of test case 2

}//end of class
