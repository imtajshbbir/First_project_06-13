package Automation_day10;


import CustomReuseable.CustoRereusable_library;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Excel_google_search
{
    public static void main(String[] args) throws IOException, BiffException, InterruptedException, WriteException {



        //Step 1:
        //locate the readable file path
        Workbook readableFile = Workbook.getWorkbook(new File("src//main//java//Excel files//Google search.xls"));

        //Step 2:
        //locate the readable worksheet by index
        Sheet readableSheet = readableFile.getSheet(0);

        //Step 3:
        //We need to create a writable workbook to mimic readable file because we shouldn`t be writing on readable file
        //writing writeable workbook to replicate the readable
        WritableWorkbook writableFile = Workbook.createWorkbook(new File("src//main//java//Excel files//Google_search_Result.xls"),readableFile);

        //create writable sheet
        WritableSheet writableSheet = writableFile.getSheet(0);
        //get the total rows that are not empty
        int rows = writableSheet.getRows();             //define the row as i

        //define the webDriver using Custom Reusable
        WebDriver driver = CustoRereusable_library.setDriver();

        //define the for loop
        //the loop start from one since excel 0 is the top tab/header
        for(int i = 1; i <rows; i++){

            //Step 4:
            //Store the cars column values as a String variable
            //columns are always hard coded where the row are dynamic based on your i
            String cars = writableSheet.getCell(0,i).getContents();

            //navigate to google page
            driver.navigate().to("https://www.google.com/");
            Thread.sleep(3000);

            CustoRereusable_library.userKeys(driver, "//*[@name = 'q']", cars, "Search Field");

            CustoRereusable_library.submit(driver,"//*[@name='btnK']", "Google search");
            Thread.sleep(3000);

            String result = CustoRereusable_library.captureText(driver, "//*[@id = 'result-stats']","search Result");
            String[] resultArray = result.split(" ");
            System.out.println("My search result is "+ resultArray[1]);

            //Step 5:
            //write the search number result back to writable sheet
            Label label = new Label(1,i,resultArray[1]);// 1 before i is the result box
            //adding back to writable cell
            writableSheet.addCell(label);



        }//end of loop

        //outside of the loop we need to write and close the excel
        writableFile.write();
        writableFile.close();
        readableFile.close();

        driver.quit();

    }//end of main method
}
