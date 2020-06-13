package Automation_Day12;

import CustomReuseable.CustoRereusable_library;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class Kayak_TestNG
{

    WebDriver driver;

    @BeforeSuite
    public void defineDriver() throws IOException, InterruptedException {
        driver = CustoRereusable_library.setDriver();

    }//end of before suite


    @AfterSuite
    public void close(){
        driver.quit();
    }//end of after suite


    @Test
    public  void KayakTestCase() throws InterruptedException {
        driver.navigate().to("https://www.kayak.com/");
        Thread.sleep(3000);
        //verify the title
        //using hardAssert
        //Assert.assertEquals(driver.getTitle(),"search Hotels, Cars");
                    //OR other one
        //using softAssert
        SoftAssert sAssert = new SoftAssert();
        sAssert.assertEquals(driver.getTitle(),"Search Hotels, Cars");
        //click airport or city
        CustoRereusable_library.click(driver, "//*[text()= 'Enter an airport or city']","Search Field");
        Thread.sleep(3000);
        //enter the airport
        CustoRereusable_library.userKeys(driver,"//*[@name = 'pickup']", "JFK","Search Field");
        //pass assertAll that way it doesn't skip all your test steps
        Thread.sleep(3000);
        sAssert.assertAll();

    }//end of Test


}
