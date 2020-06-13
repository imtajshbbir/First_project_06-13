package Automation_Day12;

import CustomReuseable.CustoRereusable_library;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Google_search_TestNG_Excel
{
    //When using annotation method your local driver
    //must be declared outside so i can call it
    //on all my annotation method
    WebDriver driver;
    Workbook readable;
    Sheet readableSheet;
    WritableWorkbook writeable;
    WritableSheet wSheet;



    //ArrayList<String> cars = new ArrayList();

    @Test
    public void googleSearch() throws InterruptedException {
        //navigate to google.com

        int row = wSheet.getRows();
        for (int i = 0; i<row; i++) {
            String cars = wSheet.getCell(0,i).getContents();
            driver.navigate().to("https://www.google.com/");
            CustoRereusable_library.userKeys(driver, "//*[@name = 'q']", cars, "Search Field");

            CustoRereusable_library.submit(driver, "//*[@name = 'btnK']", "Google Search Button");
            Thread.sleep(3000);
            //capture text and print out the search number
            String SearchResult = CustoRereusable_library.captureText(driver, "//*[@id = 'result-stats']", "Search Result");
            //split the text and print the number
            String[] arraySearch = SearchResult.split(" ");
            Reporter.log("The search Result is " + arraySearch[1]);
            System.out.println("The search Result is " + arraySearch[1]);
        }

    }//end of google test

    @BeforeMethod
    public void callDriver() throws IOException, InterruptedException, BiffException {
        //make sure the reusable file inside a package
        driver = CustoRereusable_library.setDriver();
        readable = Workbook.getWorkbook(new File("src//main//Google search.xls"));

//        cars.add("Audi");
//        cars.add("Alfa romeo");
//        cars.add("Tesla");

    }//end of beforeMethod

    @AfterMethod
    public void quiteDriver(){
        driver.quit();
    }//end of AfterMethod

}//end of java class
