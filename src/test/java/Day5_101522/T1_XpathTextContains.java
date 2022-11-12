package Day5_101522;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_XpathTextContains {
    public static void main(String[] args) throws InterruptedException {

        //setup your chromedriver with webdriver
        WebDriverManager.chromedriver().setup();

        //define the webdriver
        WebDriver driver = new ChromeDriver();

        //go to yahoo.com
        driver.navigate().to("https://www.yahoo.com");

        //maximize the browser
        driver.manage().window().fullscreen();

        //click the Sign in button
        driver.findElement(By.xpath("//*[text() = 'Sign in']")).click();

        //wait 2 sec
        Thread.sleep(2000);

        //go to yahoo page again
        driver.navigate().to("https://www.yahoo.com");
        Thread.sleep(2000);

        //click on bell icon
        driver.findElement(By.xpath("//*[contains(@class,'rapid-nonanchor')]")).click();

        //wait 2 sec
        Thread.sleep(2000);

        //quit Chrome
        driver.quit();

    }//end of main
}//end of java class
