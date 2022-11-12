package Homework_ActionItem;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class ActionItem8_WeightWatchers {
    public static void main(String[] args) throws InterruptedException {
        //declaring and describing arraylist for zipCode
        ArrayList<String> zipCode = new ArrayList<>();
        zipCode.add("11208");
        zipCode.add("11218");
        zipCode.add("10312");
        //setting up webDriver
        WebDriverManager.chromedriver().setup();
        //declaring chrome options and describing chrome options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");

        //passing chrome options through chromedriver
        WebDriver driver = new ChromeDriver(options);
        //running for loop for all the zipCodes in arraylist
    for(int i=0; i< zipCode.size();i++) {
        //navigating to weightWatchers website
        driver.navigate().to("https://www.weightwatchers.com/us/Find-a-workshop/");
        //wait 2 sec
        Thread.sleep(2000);
        //fullscreen
        driver.manage().window().fullscreen();
        //wait 2sec
        Thread.sleep(2000);

        //click Find a workshop
        driver.findElement(By.xpath("//*[text()='Find a Workshop']")).click();
        Thread.sleep(2000);
        //click In-Person
        driver.findElements(By.xpath("//*[@class='toggleButton-2ikVW']")).get(0).click();
        Thread.sleep(2000);
        //clear zipcode field and enter zipcode. Then click search arrow
        WebElement enterZipCode = driver.findElement(By.xpath("//*[@id = 'location-search']"));
        enterZipCode.clear();
        enterZipCode.sendKeys(zipCode.get(i));
        driver.findElement(By.xpath("//*[@id = 'location-search-cta']")).click();
        Thread.sleep(3000);

        //storing findElements into an arraylist to call in the if else condition
        ArrayList<WebElement> link = new ArrayList<>(driver.findElements(By.xpath("//*[contains(@class,'linkUnderline')]")));
        if(i==0) {
            //Click second studio link for first zipCode
            link.get(1).click();
        }else if(i==1){
            //Click third studio link for second zipCode
            link.get(2).click();
        }else if(i==2){
            //Click first studio link for third zipCode
            link.get(0).click();
        }//end of if else

        //Capture workshop location into a string
        String location = driver.findElement(By.xpath("//*[@class='address-2PZwW']")).getText();
        //split location by each line
        String[] splitAddress = location.split("\\R");
        //print location address of studio
        System.out.println("The studio address and schedule for zipcode "+ zipCode.get(i) +" is: "+splitAddress[0]+ " " + splitAddress[1]);
        //wait 3 sec
        Thread.sleep(3000);

        //Scrolling into view studio schedule
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement studioSchedule = driver.findElement(By.xpath("//*[@class = 'title-bEfSM']"));
        jse.executeScript("arguments[0].scrollIntoView(true);", studioSchedule);
        //wait 3 sec
        Thread.sleep(3000);

        //storing each days schedule in an arraylist and then calling a for loop to extract and print all the schedule info in the table
        ArrayList<WebElement> schedule = new ArrayList<>(driver.findElements(By.xpath("//*[contains(@class,'day-NhBOb')]")));
        for (int j = 0; j < schedule.size(); j++) {
            String hours = schedule.get(j).getText();
            System.out.println(hours);
        }//end of second for loop
    }//end of first for loop
        Thread.sleep(3000);
        //quiting the browser
        driver.quit();

    }//end of main
}//end of java class
