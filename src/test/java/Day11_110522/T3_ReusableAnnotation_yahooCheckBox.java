package Day11_110522;

import Reusable_Library.ReusableActions;
import Reusable_Library.Reusable_Annotations;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class T3_ReusableAnnotation_yahooCheckBox extends Reusable_Annotations {

    /*
       THE REUSABLE ANNOTATION WAS SET UP ON main FILE
       NOW WE DON'T HAVE TO WRITE BEFORE SUITE & AFTER SUITE ANYMORE FOR ALL OUR TEST
       WE JUST CONTINUE WITH @TEST FROM NOW
     */

    //verify that by default signed in option should be checked
    @Test(priority = 1)
    public void tc001_verifySignedInOptionIsChecked(){
        //navigate to yahoo.cm
        driver.navigate().to("https://www.yahoo.com");
        //next click on sign in button
        ReusableActions.clickAction(driver, "//*[@class = '_yb_1933e']", "sing in button");
        boolean isSignInChecked = driver.findElement(By.xpath("//*[@id = 'persistent']")).isSelected();
        System.out.println("The checkbox check condition is: " + isSignInChecked);
    }//end of test case 1

    //unchecking the checkbox and verifying if boolean captured it & using depends on method
    @Test(dependsOnMethods = "tc001_verifySignedInOptionIsChecked")
    public void tc002_verifySignedInOptionIsUnchecked(){
        //click on checkbox to uncheck
        ReusableActions.clickAction(driver,"//*[@class = 'stay-signed-in checkbox-container']", "SignedInCheckBox");
        //we need to verify if signed in option is checked
        boolean isSignInChecked = driver.findElement(By.xpath("//*[@id = 'persistent']")).isSelected();
        System.out.println("The checkbox check condition is: " + isSignInChecked);
    }//end of test case 2

}//end of java class
