package Automation_day11;

import CustomReuseable.CustoRereusable_library;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.ArrayList;

public class Google_search_TestNG_Suites
{
    //When using annotation method your local driver
    //must be declared outside so i can call it
    //on all my annotation method
    WebDriver driver;
    String getURL;
    ArrayList cars = new ArrayList();

    @Test(priority = 1)
    public void googleSearch_01() throws InterruptedException
    {
        for (int i = 0; i<cars.size(); i++) {
            //navigate to google.com
            driver.navigate().to("https://www.google.com/");
            Thread.sleep(2000);
            CustoRereusable_library.userKeys(driver, "//*[@name = 'q']", "Cars", "Search Field");

            CustoRereusable_library.submit(driver, "//*[@name = 'btnK']", "Google Search Button");
            Thread.sleep(3000);
            getURL = driver.getCurrentUrl();
        }

    }//end of test priority 1

    //when you use dependsOnMethod in your @Test that means your second test is dependent
    //on your first test if first test fails second test will be skipped
    //if all test has priorities they might or might not be dependent on each other

    @Test(dependsOnMethods = "googleSearch_01") // OR  @Test(priority = 2)
    public void captureResult() throws InterruptedException {
        driver.navigate().to(getURL);
        Thread.sleep(2000);
        //capture text and print out the search number
        String SearchResult = CustoRereusable_library.captureText(driver,"//*[@id = 'result-stats']", "Search Result");
        //split the text and print the number
        String[] arraySearch = SearchResult.split(" ");
        Reporter.log("My search number is " + arraySearch);
        System.out.println("The search Result is " + arraySearch[1]);

    }//end of test priority 2

    @BeforeSuite
    public void callDriver() throws IOException, InterruptedException
    {
        //make sure the reusable file inside a package
        driver = CustoRereusable_library.setDriver();
        cars.add("Audi");
        cars.add("Alfa romeo");
    }//end of beforeMethod

    @AfterSuite
    public void quiteDriver(){
        driver.quit();
    }//end of AfterMethod

}//end of java class
