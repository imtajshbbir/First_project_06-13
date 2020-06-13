package Automation_day13;

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

public class List_Boolean_htmlReport {
    //declaring the driver
    WebDriver driver;
    //declare the report variable outside
    ExtentReports htmlReports;
    //declare the logger(extent test)
    ExtentTest logger;

    @BeforeSuite
    public void defineDriver() throws IOException, InterruptedException {
        driver = CustoRereusable_library.setDriver();
        //define the report path here as a before path
        Thread.sleep(1500);
        htmlReports = new ExtentReports("src//main//java//html_report//AutomationReport.html",true);

    }//end of before method

    @Test
    public void yahoo_verification() throws InterruptedException {

        //define and start the test
        logger = htmlReports.startTest("Yahoo Verification");
        //navigate to Yahoo home page
        logger.log(LogStatus.INFO,"Getting the list count for all links");
        driver.navigate().to("https://www.yahoo.com/");
        Thread.sleep(4000);
        List<WebElement> CountLink = driver.findElements(By.xpath("//*[contains(@class,'D(ib) Mstart(21px) Mend(17px)')]"));
        System.out.println("The link number matches");
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
        htmlReports.endTest(logger);
    }//end of test method


    @AfterSuite
    public void CloseDriver() {
        //driver.quit();
        //flushing == writing the logs (logger) back to your automation report that you defined
        htmlReports.flush();
    }//end of after suites
}//end of class
