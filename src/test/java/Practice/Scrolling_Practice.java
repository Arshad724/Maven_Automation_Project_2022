package Practice;

import Reusable_Library.ReusableActions;
import org.openqa.selenium.WebDriver;

public class Scrolling_Practice {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
       driver = ReusableActions.setUpDriver();

        driver.navigate().to("https://www.uhc.com/");
        Thread.sleep(5000);

//        WebElement popUp = driver.findElement(By.xpath("//*[@id = 'logoContainer']"));
//        if (popUp.isDisplayed()){
//            driver.findElement(By.xpath("//*[@id='ip-no']")).click();
//        }

        ReusableActions.scrollByViewElement(driver, "//h2[text() = 'Explore our many insurance options']", "scroll to view find a dentist");


   //            ReusableActions.scrollByViewPixel(driver, "scroll(0,200)","scrolling");

//        JavascriptExecutor jse = (JavascriptExecutor) driver;
//        jse.executeScript("scroll(0,2000)");

//        JavascriptExecutor jse = (JavascriptExecutor) driver;
//
//        WebElement findADoctor = driver.findElement(By.xpath("//*[text()='Find a dentist']"));
//        //scroll into view of calculate button
//        jse.executeScript("arguments[0].scrollIntoView(true);", findADoctor);
//        //wait 2 secs
        Thread.sleep(2000);

        driver.quit();
    }//end of main
}//end of java class
