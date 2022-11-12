package Day4_100922;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T2_WebDriverExample {
    public static void main(String[] args) throws InterruptedException {

        //define the webdriver manager setup for chromedriver
        WebDriverManager.chromedriver().setup();
        //define the chrome driver to use for your test
        //creating an instance for a chrome driver(browser) to use for automation
        WebDriver driver = new ChromeDriver();

        //navigate to the google site. From now it will all be driver.__
        driver.navigate().to("https://www.google.com");

        //wait for few second. This is in milli second so 3000 = 3 sec.
        //Also "sleep" might have red underline so hover over it and click exception
        Thread.sleep(3000);

        //quit the chrome session
        driver.quit();

    }//end of main
}//end of java class
