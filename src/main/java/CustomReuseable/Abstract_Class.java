package CustomReuseable;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.lang.reflect.Method;

public class Abstract_Class {

    //set the global variables as public static order
    //to be used on your @test classes
    //new changes

    public static WebDriver driver;
    public static ExtentReports reports;
    public static ExtentTest logger;

    @BeforeSuite
    public void defineDriver() throws IOException, InterruptedException {
        driver = CustoRereusable_libraryLogger.setDriver();
        //define the report path
        reports = new ExtentReports("src//main//java//html_report//TestReports.html",true);
    }//end of before suites

    @BeforeMethod
    public void getMethodName(Method methodName){
        //start the logger here to capture the specific @test method name
        logger = reports.startTest(methodName.getName());
    }//end of before method

    @AfterMethod
    public void endMethod(){
        reports.endTest(logger);
    }//end of after Method

    @AfterSuite
    public void CloseDriver(){
        driver.quit();
        reports.flush();
    }//end of after suites




}//end of java
