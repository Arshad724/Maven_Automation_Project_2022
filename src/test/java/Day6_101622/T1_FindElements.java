package Day6_101622;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class T1_FindElements {
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
        driver.navigate().to("https://www.yahoo.com");

        //wait few seconds
        Thread.sleep(3000);

        //using find elements i want to click on second link within the group which is News
        driver.findElements(By.xpath("//*[contains(@class,'_yb_sc88r')]")).get(1).click();

        Thread.sleep(2000);

        driver.quit();
    }//end of main
}//end of java class
