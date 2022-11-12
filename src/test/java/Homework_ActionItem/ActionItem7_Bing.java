package Homework_ActionItem;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class ActionItem7_Bing {
    public static void main(String[] args) throws InterruptedException {

        //declaring arrayList and defining sports
        ArrayList<String> sport = new ArrayList<>();
        sport.add("cricket");
        sport.add("basketball");
        sport.add("tennis");
        sport.add("hockey");

        //defining and setting up webdriver manager for chromedriver, and creating an instance on chrome
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //for loop around the search commands from arrayList
        for(int i = 0; i < sport.size(); i++) {

            //navigating to bing
            driver.navigate().to("https://www.bing.com/");

            //wait after landing on bing page
            Thread.sleep(3000);

            //typing sport commands from arrayList
            driver.findElement(By.xpath("//*[@name='q']")).sendKeys(sport.get(i));

            //clicking search icon
            driver.findElement(By.xpath("//*[@viewBox = '0 0 25 25']")).click();

            //wait after landing on search result page
            Thread.sleep(3000);

            //extracting search number from search result and splitting out the search number only
            String message = driver.findElement(By.xpath("//*[@class = 'sb_count']")).getText();
            String[] splitMessage = message.split(" ");
            //printing the search number
            System.out.println("My sport is: " + sport.get(i) + " and it's search number in bing is: " + splitMessage[0]);
        }//end of for loop

            //Quiting the instance on chrome
            driver.quit();

    }//end of main
}//end of java class
