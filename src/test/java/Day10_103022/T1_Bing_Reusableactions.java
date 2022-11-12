package Day10_103022;

import Reusable_Library.ReusableActions;
import org.openqa.selenium.WebDriver;

public class T1_Bing_Reusableactions {
    public static void main(String[] args) {
        //calling reusable method for set driver
        WebDriver driver = ReusableActions.setUpDriver();

        //navigate
        driver.navigate().to("https://www.bing.com");

        //enter a keyword in search field using reusable method
        ReusableActions.sendKeysAction(driver,"//*[@name='q']","soccer","Search Field");

        //click on search icon using reusable method
        ReusableActions.clickAction(driver,"//*[@id='search_icon']","Search Icon");

        //capture the result and extract out the number
        String result = ReusableActions.getTextAction(driver,"//*[@class='sb_count']","Search Results");
        System.out.println("Result is " + result);
    }//end of main method
}//end of java class
