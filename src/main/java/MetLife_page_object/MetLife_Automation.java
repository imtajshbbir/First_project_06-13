package MetLife_page_object;

import CustomReuseable.Abstract_Class;
import CustomReuseable.CustoRereusable_libraryLogger;
import com.relevantcodes.extentreports.LogStatus;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class MetLife_Automation extends Abstract_Class {
    Workbook ReadFile;
    Sheet ReadSheet;
    WritableWorkbook writeFile;
    WritableSheet writeSheet;

    @Test
    public void MetLifePlan() throws InterruptedException, IOException, BiffException {
        ReadFile = Workbook.getWorkbook(new File("src//main//java//Excel files//MetLife.xls"));
        ReadSheet = ReadFile.getSheet(0);
        writeFile = Workbook.createWorkbook(new File("src//main//java//Excel files//MetLife_Result.xls"),ReadFile);
        writeSheet = writeFile.getSheet(0);

        int rows = writeSheet.getRows();

        logger.log(LogStatus.INFO, "Navigating to MetLife");
        driver.navigate().to("https://www.metlife.com/");
        Thread.sleep(3000);

        MetLife_BaseClass.metLife_homePage().title();
        MetLife_BaseClass.metLife_homePage().Solution();
        MetLife_BaseClass.metLife_homePage().Dental();
        MetLife_BaseClass.metLife_enroll_now().dentalTitle();
        Thread.sleep(3000);
        for (int i = 1; i < rows; i++) {
            MetLife_BaseClass.metLife_enroll_now().enroll_now();
            Thread.sleep(3000);
            MetLife_BaseClass.metLife_pageHandels().metLife_pageHandels(1);
            Thread.sleep(3000);
            String Zipcode = writeSheet.getCell(0,i).getContents();
            MetLife_BaseClass.metLife_zipcode().enterZipcode(Zipcode);
            Thread.sleep(2000);
            MetLife_BaseClass.metLife_zipcode().ZipcodeClick();
            Thread.sleep(3000);
            String DentalPrograms = writeSheet.getCell(1,i).getContents();
            MetLife_BaseClass.metLife_programs().metLife_dentalPrograms(DentalPrograms);
            MetLife_BaseClass.metLife_programs().metLife_programNow();
            Thread.sleep(3000);
            String ReferralCode = writeSheet.getCell(2,i).getContents();
            MetLife_BaseClass.metLife_programs().metLife_referralCode(ReferralCode);
            Thread.sleep(3000);
            MetLife_BaseClass.metLife_programs().metLife_referralClick();
            Thread.sleep(3000);
            MetLife_BaseClass.metLife_programs().metLife_captureError();
            Thread.sleep(3000);
            MetLife_BaseClass.metLife_programs().metLife_withoutCode();
            Thread.sleep(3000);

            String capture = CustoRereusable_libraryLogger.captureText(driver,"//*[@class='col-sm-8']", "Result", logger);
            //matching the capture text with array text
            if (capture.contains(DentalPrograms)){
                System.out.println("The result matches");
                logger.log(LogStatus.PASS,"The result matches");
            }else{
                System.out.println("The result did not match " + capture);
                logger.log(LogStatus.FAIL,"The result did not match " + capture);
            }
            Thread.sleep(3000);
            driver.close();
            MetLife_BaseClass.metLife_pageHandels().metLife_pageHandels(0);
            Thread.sleep(3000);

        }
    }

}
