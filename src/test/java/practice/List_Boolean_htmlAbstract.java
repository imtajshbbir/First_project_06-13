package practice;

import CustomReuseable.Abstract_Class;
import CustomReuseable.CustoRereusable_library;
import CustomReuseable.CustoRereusable_libraryLogger;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class List_Boolean_htmlAbstract extends Abstract_Class {


    @Test
    public void yahoo_verification() throws InterruptedException {

        //navigate to Yahoo home page
        logger.log(LogStatus.INFO,"Getting the list count for all links");
        driver.navigate().to("https://www.yahoo.com/");
        Thread.sleep(4000);
        List<WebElement> CountLink = driver.findElements(By.xpath("//*[contains(@class,'D(ib) Mstart(21px) Mend(17px)')]"));
        System.out.println("The link number matches" + CountLink.size());
        if (CountLink.size() == 12) {
            System.out.println("My yahoo page link count match which is " + CountLink.size());
            logger.log(LogStatus.PASS,"My yahoo page link count match which is " + CountLink.size());
        } else {
            System.out.println("The page links number doesn't match");
            logger.log(LogStatus.FAIL,"The page links number doesn't match");
        }

        CustoRereusable_libraryLogger.click(driver, "//*[@id = 'header-signin-link']", "Sign In", logger);
        Thread.sleep(2000);

        boolean CheckboxState = driver.findElement(By.xpath("//*[@id = 'persistent']")).isSelected();
        if (CheckboxState == true) {
            System.out.println("Checkbox is selected by default");
            logger.log(LogStatus.PASS,"Checkbox is selected by default");
        } else {
            System.out.println("Checkbox is not selected by default");
            logger.log(LogStatus.FAIL,"Checkbox is not selected by default");
        }
        //end the test for specific @test
    }//end of test method

}//end of class
