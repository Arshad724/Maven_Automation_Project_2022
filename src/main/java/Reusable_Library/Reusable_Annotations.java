package Reusable_Library;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Reusable_Annotations {
    /*
    WebDriver variable needs to get inherited to your test class but in order to do that
    it must be public static
     */
    public static WebDriver driver;
    @BeforeSuite
    public void SetChromeDriver() {
        driver = ReusableActions.setUpDriver();
    }//end of set driver method

    @AfterSuite
    public void quitTheSession() {
        driver.quit();
    }//end of after suite

}//end of class
