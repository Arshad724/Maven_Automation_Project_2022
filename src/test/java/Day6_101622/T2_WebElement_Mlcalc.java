package Day6_101622;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class T2_WebElement_Mlcalc {
    public static void main(String[] args) throws InterruptedException {

        //setup your chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();

        //initialize chrome options
        ChromeOptions options = new ChromeOptions();

        //add options for maximizing the chrome window for windows is "start-maximize"
        options.addArguments("start-fullscreen");

        //define the webdriver and pass the options into the method
        //creating an instance for chrome driver to use for automation
        WebDriver driver = new ChromeDriver(options);

        //go to google page
        driver.navigate().to("https://www.mlcalc.com");

        //wait few seconds
        Thread.sleep(3000);


        //store a locator into a webelement so you dont have to keep on typing the locator
        //clear and enter a new value on purchase price field
        WebElement pPrice = driver.findElement(By.xpath("//*[@name = 'ma']"));
        //clear the purchase price
        pPrice.clear();
        //type new value on the purchase price
        pPrice.sendKeys("450000");

        //clear and enter a new value on purchase price field
        WebElement dPayment = driver.findElement(By.xpath("//*[@name = 'dp']"));
        //clear the down payment percentage field
        dPayment.clear();
        //type new value on the down payment field
        dPayment.sendKeys("25");

        Thread.sleep(3000);

        driver.quit();

    }//end of main
}//end of java class
