package CustomReuseable;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class Abstract_Class_Parameter {

    //set the global variables as public static order
    //to be used on your @test classes

    public static WebDriver driver;
    public static ExtentReports reports;
    public static ExtentTest logger;

    @BeforeSuite
    public void defineDriver() throws IOException, InterruptedException {
        //driver = CustoRereusable_libraryLogger.setDriver();
        //define the report path
        reports = new ExtentReports("src//main//java//html_report//TestReports.html",true);
    }//end of before suites

    @Parameters("Browser")
    @BeforeMethod
    public void getMethodName(Method testName,String Browser) throws IOException, InterruptedException {
        if (Browser.equalsIgnoreCase("Chrome")){
            driver = CustoRereusable_libraryLogger.setDriver();
        }else if (Browser.equalsIgnoreCase("Firefox")){
            System.setProperty("webdriver.gecko.driver","src//main//resources//geckodriver.exe");
            driver = new FirefoxDriver();
            //Firefox comes with maximize windows
            //driver.manage().window().maximize(); //Firefox comes with maximize windows
        }
        //start the logger here to capture the specific @test method name
        logger = reports.startTest(testName.getName() + "_" + Browser);
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
