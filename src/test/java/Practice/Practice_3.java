package Practice;

import Reusable_Library.ReusableActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Practice_3 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = ReusableActions.setUpDriver();
        driver.navigate().to("https://www.uhc.com/");

        ReusableActions.clickActionByIndex(driver, "//*[@class = 'nav-item-parent list-none my-0 ml-0 flex lg-flex lg-items-center']", 2, "selecting other sites");

        ReusableActions.clickActionByIndex(driver, "//*[@class = 'display-block ']",1, "selecting medicare plans to go to another tab");

        ReusableActions.switchToTabByIndex(driver,1,"Switching tab");

        ReusableActions.clickAction(driver, "//*[@name='zipSearch-1907232265']", "clicking the search box");
        driver.findElement(By.xpath("//*[@name='zipSearch-1907232265']")).clear();
        Thread.sleep(1000);

        ReusableActions.sendKeysAction(driver,"//*[@name='zipSearch-1907232265']","11208", "inputting zip");
        Thread.sleep(2000);

        ReusableActions.scrollByViewElement(driver,"//*[@class='unity-type-h1 u-text-bold u-d-block ttMiddle']", "scrolling to middle");
    }//end of main
}//end of java class
