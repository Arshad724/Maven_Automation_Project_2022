package Day7_102222;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class T1_Select_Statement {
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

        driver.findElement(By.xpath("//*[text() = 'Show advanced options']")).click();
        Thread.sleep(2000);

        //use select command for month drop down
        WebElement strtMonth = driver.findElement(By.xpath("//*[@name = 'sm']"));
        Select startMonthDropdown = new Select(strtMonth);
        //select by visible text
        startMonthDropdown.selectByVisibleText("Nov");

        //use select command for year drop down
        WebElement strtyear = driver.findElement(By.xpath("//*[@name = 'sy']"));
        Select startYearDropdown = new Select(strtyear);
        //select by visible text
        startYearDropdown.selectByVisibleText("2023");

        //if you cannot use the select command
//      driver.findElement(By.xpath("//*[@name='sy']")).click();
//     driver.findElement(By.xpath("//*[text()='2023']")).click();

        driver.quit();



    }//end of main
}//end of java class
