package Reusable_Library;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.ArrayList;

public class ReusableActions_Loggers {

    static int timeout = 10;

    //reusable method to define and launch webdriver
    public static WebDriver setUpDriver() {
        //define the webdriver manager setup for chromedriver
        WebDriverManager.chromedriver().setup();
        //initialize chrome options
        ChromeOptions options = new ChromeOptions();
        //add argument to chrome options
        //options.addArguments("start-maximized");
        //for mac use "start-fullscreen"
        options.addArguments("start-fullscreen");
        //if above does not work on mac, then try --kiosk
        //options.addArguments("--kiosk");
        //initialize driver with chrome options
        WebDriver driver = new ChromeDriver(options);
        return driver;
    }//end of setup driver method

    public static void clickAction(WebDriver driver, String xpath, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.click();
            logger.log(LogStatus.PASS, "Successfully clicked on: " +elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element: " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL,"Unable to click on element: " + elementName + " for reason: " + e);
            //add this to your click action. THIS LINE OF CODE NEEDS TO BE ADDED TO ALL METHODS IN CATCH
            getScreenShot(driver, elementName, logger);
        }
    }//end of clickAction method

    public static void clickActionByIndex(WebDriver driver, String xpath, int index, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))).get(index).click();
        } catch (Exception e) {
            System.out.println("Unable to click on element: " + elementName + " for reason: " + e);
        }
    }//end of clickActionByIndex method

    public static void submitAction(WebDriver driver, String xpath, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.submit();
            logger.log(LogStatus.PASS, "Successfully click submit on: " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to submit on element: " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL, "Unable to submit on element: " + elementName + " for reason: " + e);
        }
    }//end of submit action

    public static void mouseHover (WebDriver driver, String xpath,ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        //declare mouse actions
        Actions actions = new Actions(driver);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            actions.moveToElement(element).perform();
            logger.log(LogStatus.PASS, "Successfully hovered mouse on: " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to hover to element: " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL,"Unable to hover to element: " + elementName + " for reason: " + e );
        }
    }//end of mouseHover method


    public static void mouseHoverClick (WebDriver driver, String xpath,ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        //declare mouse actions
        Actions actions = new Actions(driver);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            actions.moveToElement(element).click().perform();
            logger.log(LogStatus.PASS, "Successfully hovered mouse on: " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to hover to element: " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL,"Unable to hover to element: " + elementName + " for reason: " + e );
        }
    }//end of mouseHover method

    public static void sendKeysAction(WebDriver driver, String xpath, String userInput,ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.sendKeys(userInput);
            logger.log(LogStatus.PASS, "Successfully send keys to: " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to send keys to : " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL, "Unable to send keys to : " + elementName + " for reason: " + e);
        }
    }//end of sendKeysAction method

    public static String getTextAction(WebDriver driver, String xpath, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        String textOutput = "";
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            textOutput = element.getText();
            logger.log(LogStatus.PASS,"Successfully got text on" + elementName);
        } catch (Exception e) {
            System.out.println("Unable to get text for : " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL, "Unable to get text for : " + elementName + " for reason: " + e);
        }
        return textOutput;
    }//end of getTextAction method


    public static String getTextActionByIndex(WebDriver driver, String xpath,int index,ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        String textOutput = "";
        try {
           ArrayList<WebElement> element = new ArrayList<>(wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))));
            textOutput = element.get(index).getText();
            logger.log(LogStatus.PASS,"Successfully got text by index on" + elementName);
        } catch (Exception e) {
            System.out.println("Unable to get text for : " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL, "Unable to get text for : " + elementName + " for reason: " + e);
        }
        return textOutput;
    }//end of getTextAction method

    public static void selectByText (WebDriver driver, String xpath, String visibleText, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try{
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            Select dropDown = new Select(element);
            dropDown.selectByVisibleText(visibleText);
        }catch (Exception e){
            System.out.println(("Unable to select text for : "+ elementName + " for reason: " + e));
        }
    }//end of selectByTextAction method


    public static void switchToTabByIndex (WebDriver driver, int index,ExtentTest logger, String elementName) {
        try{
            ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(index));
            logger.log(LogStatus.PASS,"Successfully switched tab for:" + elementName);
        } catch (Exception e){
            System.out.println("Unable to switch tabs for: " + elementName + " for reason " + e);
            logger.log(LogStatus.FAIL, "Unable to switch tabs for: " + elementName + " for reason " + e);
        }
    }//end of switch tab method

    public static void scrollByViewElement (WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        try{
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            jse.executeScript("arguments[0].scrollIntoView(true);", element);
        }catch (Exception e){
            System.out.println("Unable to scroll for: " + elementName + " for reason " + e);
        }
    }//end of scroll by element method


    public static void selectByValue (WebDriver driver, String xpath, String value, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try{
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            Select dropDown = new Select(element);
            dropDown.selectByValue(value);
        }catch (Exception e){
            System.out.println(("Unable to select value for : "+ elementName + " for reason: " + e));
        }
    }//end of selectByValue method


    public static void selectByIndex (WebDriver driver, String xpath, int index, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try{
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            Select dropDown = new Select(element);
            dropDown.selectByIndex(index);
        }catch (Exception e){
            System.out.println(("Unable to select index for : "+ elementName + " for reason: " + e));
        }
    }//end of selectByIndex method

    public static void scrollByViewPixel(WebDriver driver, String scrollCoordinate, String elementName){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript(scrollCoordinate);
    }


    public static void getScreenShot(WebDriver driver, String imageName, ExtentTest logger) {
        try {
            String fileName = imageName + ".png";
            String directory = null;
            String snPath = null;
            directory = "src/main/java/HTML_Report/Screenshots/";
            snPath = "Screenshots//";
            File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(sourceFile, new File(directory + fileName));
            //String imgPath = directory + fileName;
            String image = logger.addScreenCapture(snPath + fileName);
            logger.log(LogStatus.FAIL, "", image);
        } catch (Exception e) {
            logger.log(LogStatus.FAIL, "Error Occured while taking SCREENSHOT!!!");
            e.printStackTrace();
        }
    }//end of getScreenshot method


    public static void compareExpectedAndActualText(String expectedText, String actualText, ExtentTest logger) {
        if (actualText.equals(expectedText)) {
            logger.log(LogStatus.PASS, "Expected Text: " + expectedText + " and Actual Text: " + actualText + " match");
        }
        else{
            logger.log(LogStatus.FAIL, "Expected Text: " + expectedText + " and Actual Text: " + actualText + " does not match");
        }
    }//end of compareExpectedAndActualText

}//end of class