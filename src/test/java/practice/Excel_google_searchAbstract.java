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
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class Excel_google_searchAbstract extends Abstract_Class
{
    Workbook ReadFile;
    Sheet ReadSheet;
    WritableWorkbook writeFile;
    WritableSheet writeSheet;

    @Test
    public void GoogleSearch() throws IOException, BiffException, InterruptedException, WriteException {

        ReadFile = Workbook.getWorkbook(new File("src//main//java//Excel files//Google search.xls"));
        ReadSheet = ReadFile.getSheet(0);
        writeFile = Workbook.createWorkbook(new File("src//main//java//Excel files//Google_search_Result.xls"),ReadFile);
        writeSheet = writeFile.getSheet(0);
        //get the total rows that are not empty
        int rows = writeSheet.getRows();             //define the row as i

        //define the for loop
        //the loop start from one since excel 0 is the top tab/header
        for(int i = 1; i <rows; i++){

            //Step 4:
            //Store the cars column values as a String variable
            //columns are always hard coded where the row are dynamic based on your i
            String cars = writeSheet.getCell(0,i).getContents();

            //navigate to google page
            driver.navigate().to("https://www.google.com/");
            Thread.sleep(3000);

            CustoRereusable_libraryLogger.userKeys(driver, "//*[@name = 'q']", cars, "Search Field",logger);

            CustoRereusable_libraryLogger.submit(driver,"//*[@name='btnK']", "Google search", logger);
            Thread.sleep(3000);

            String result = CustoRereusable_libraryLogger.captureText(driver, "//*[@id = 'result-stats']","search Result", logger);
            String[] resultArray = result.split(" ");
            System.out.println("My search result is "+ resultArray[1]);
            logger.log(LogStatus.PASS,"My search result is "+ resultArray[1]);

            //Step 5:
            //write the search number result back to writable sheet
            Label label = new Label(1,i,resultArray[1]);// 1 before i is the result box
            //adding back to writable cell
            writeSheet.addCell(label);

        }//end of loop

        //outside of the loop we need to write and close the excel
        writeFile.write();
        writeFile.close();
        ReadFile.close();


    }//end of main method
}
