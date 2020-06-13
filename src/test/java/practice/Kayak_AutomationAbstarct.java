package practice;

import CustomReuseable.Abstract_Class;
import CustomReuseable.CustoRereusable_library;
import CustomReuseable.CustoRereusable_libraryLogger;
import com.relevantcodes.extentreports.LogStatus;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Kayak_AutomationAbstarct extends Abstract_Class    //have to add extends Abstract class
{

    Workbook ReadFile;
    Sheet ReadSheet;
    WritableWorkbook writeFile;
    WritableSheet writeSheet;


    @Test //the test Began here
    public void MainTest() throws InterruptedException, WriteException, IOException, BiffException {

        //define the path of readFile
        ReadFile = Workbook.getWorkbook(new File("src//main//java//Excel files//Kayak_info.xls"));
        //Readable Sheet
        ReadSheet = ReadFile.getSheet(0);
        //Creating the writeable file
        writeFile = Workbook.createWorkbook(new File("src//main//java//Excel files//Kayak_info_details.xls"),ReadFile);
        //writeable sheet
        writeSheet = writeFile.getSheet(0);
        int rows = writeSheet.getRows();
        logger.log(LogStatus.INFO,"Navigating on kayak");
        for (int i = 1; i<rows; i++ ) {

            //navigating to the Kayak site
            driver.navigate().to("https://www.kayak.com/");
            Thread.sleep(3000);

            CustoRereusable_libraryLogger.click(driver, "//*[text()='Enter an airport or city']", "Airport",logger);

            String AirPort = writeSheet.getCell(0,i).getContents();

            CustoRereusable_libraryLogger.userKeys(driver, "//*[@name = 'pickup']", AirPort, " Location",logger);

            CustoRereusable_libraryLogger.click(driver, "//*[@class='smarty-icon-wrapper']", "Specific Airport",logger);

            CustoRereusable_libraryLogger.MouseClick(driver, "//*[contains(@id,'dateRangeInput-display-end')]", "End Calender",logger);
            Thread.sleep(3000);

            String EndDate = writeSheet.getCell(3,i).getContents();

            CustoRereusable_library.userTypeAndHitEnter(driver, "//*[contains(@id,'dropoff-date-input')]", EndDate, " End date");
            Thread.sleep(2000);

            CustoRereusable_library.MouseClick(driver, "//*[contains(@id,'dateRangeInput-end-time-select-display-status')]", "End Time");
            Thread.sleep(3000);

            String EndTime = writeSheet.getCell(4,i).getContents();

            CustoRereusable_library.MouseClick(driver, "//*[contains(@id,'dateRangeInput-end-time-select') and @data-title='" +EndTime +"']", " Specific End Time");
            Thread.sleep(3000);

            CustoRereusable_library.MouseClick(driver, "//*[contains(@id,'dateRangeInput-display-start')]", "Start Calender");
            Thread.sleep(3000);

            String StartDate = writeSheet.getCell(1,i).getContents();

            CustoRereusable_library.userTypeAndHitEnter(driver, "//*[contains(@id,'pickup-date-input')]", StartDate, "Start Date");
            Thread.sleep(3000);

            CustoRereusable_library.MouseClick(driver, "//*[contains(@id,'compareTo-title-row')]", "Outside");
            Thread.sleep(3000);

            CustoRereusable_library.MouseClick(driver, "//*[contains(@id,'dateRangeInput-start-time-select-display-status')]", "Start Time");
            Thread.sleep(3000);

            String StartTime = writeSheet.getCell(2,i).getContents();

            CustoRereusable_library.MouseClick(driver, "//*[contains(@id,'dateRangeInput-start-time-select-option') and @aria-label='" +StartTime +"']", " Specific Start Time");
            //dateRangeInput-start-time-select-option-14
            Thread.sleep(3000);

            CustoRereusable_library.MouseClick(driver, "//*[@class = '_h-2 _ivP _iv1']", "Search Button");
            Thread.sleep(3000);

            String Size = writeSheet.getCell(5,i).getContents();

            CustoRereusable_library.MouseClick(driver, "//*[contains(text(),'"+Size + "')]", " Vehicle Size");
            Thread.sleep(4000);

            CustoRereusable_library.clickByIndex(driver, "//*[contains(text(),'View Deal')]",1,"View Deal");
            Thread.sleep(6000);

            ArrayList<String> Tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(Tabs.get(1));
            Thread.sleep(3000);

            String summary = CustoRereusable_library.captureText(driver, "(//*[@class = 'card-body p-2']) [33] or //div[@class='__-a']//div[@class='summarySection'] or @class = 'widgets']", "Summary");
            Label Stext = new Label(6,i,summary);
            writeSheet.addCell(Stext);
            Thread.sleep(3000);

            driver.close();//closing the tab/current page
            driver.switchTo().window(Tabs.get(0));//switching back to first page
            Thread.sleep(2000);
            driver.manage().deleteAllCookies();

        }
        writeFile.write();
        writeFile.close();
        ReadFile.close();


    }//end of test


}//end of class
