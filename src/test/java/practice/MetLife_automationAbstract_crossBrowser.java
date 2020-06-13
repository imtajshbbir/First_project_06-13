package practice;

import CustomReuseable.Abstract_Class;
import CustomReuseable.Abstract_Class_Parameter;
import CustomReuseable.CustoRereusable_libraryLogger;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class MetLife_automationAbstract_crossBrowser extends Abstract_Class_Parameter//Class start from here
{   //main  method where loops and variables are stored.

    @Test
    public void MetLife() throws InterruptedException {

        ArrayList<String> Zipcode = new ArrayList<>();//declare arraylist for zipCode
        Zipcode.add("11230");
        Zipcode.add("11226");
        Zipcode.add("11241");

        ArrayList<String> dentalProgram = new ArrayList<>();//declare arraylist for dentalProgram
        dentalProgram.add("PPO-LOW");
        dentalProgram.add("PPO-MEDIUM");
        dentalProgram.add("PPO-HIGH");

        ArrayList<String> referralCode = new ArrayList<>();//declare arrayList for referralcode
        referralCode.add("3256");
        referralCode.add("8974");
        referralCode.add("9420");


        driver.navigate().to("https://www.metlife.com/");//navigate to MetLife.com
        Thread.sleep(2000);

        CustoRereusable_libraryLogger.Title(driver, "Insurance and Employee Benefits | MetLife", logger);
        CustoRereusable_libraryLogger.MouseHover(driver,"//*[contains(text(),'SOLUTIONS')]","Solution", logger);
        Thread.sleep(3000);
        CustoRereusable_libraryLogger.MouseClick(driver,"//*[contains(text(),'MetLife TakeAlong Dental')]","TakeAlong Dental", logger );
        Thread.sleep(3000);
        CustoRereusable_libraryLogger.Title(driver, "MetLife TakeAlong Dental | MetLife",logger);
        Thread.sleep(3000);

        for (int i =0; i<Zipcode.size(); i++) {//starting for loop

            CustoRereusable_libraryLogger.MouseClick(driver,"//*[contains(text(),'Enroll Now')]", "Enroll now Button", logger);
            Thread.sleep(3000);

            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());//declaring array list for handling tabs
            driver.switchTo().window(tabs.get(1));//switching the tabs to second tab
            Thread.sleep(3000);
            CustoRereusable_libraryLogger.userKeys(driver,"//*[@id='txtZipCode']", Zipcode.get(i), "Entering Zip", logger);
            Thread.sleep(3000);
            CustoRereusable_libraryLogger.MouseClick(driver,"//*[@id = 'txtZipCodetxt']","Go Button", logger);
            Thread.sleep(3000);
            CustoRereusable_libraryLogger.MouseClick(driver,"//*[@class = '" + dentalProgram.get(i) + "']", "First dental", logger);
            Thread.sleep(3000);
            CustoRereusable_libraryLogger.MouseClick(driver,"//*[@id ='topenrolltab']", "Program option", logger);
            Thread.sleep(3000);
            CustoRereusable_libraryLogger.userKeys(driver,"//*[@id = 'txtBxPromocode']",referralCode.get(i), "Promotion code", logger );
            Thread.sleep(3000);
            CustoRereusable_libraryLogger.MouseClick(driver,"//*[@name='btnEnroll']", "Enroll without code", logger);
            Thread.sleep(3000);
            CustoRereusable_libraryLogger.captureText(driver,"//*[@id ='lblRefCodeError']", "error message", logger);
            Thread.sleep(3000);
            CustoRereusable_libraryLogger.MouseClick(driver,"//*[@id='withoutrefcode']", "Without referall code", logger);
            Thread.sleep(3000);

            String capture = CustoRereusable_libraryLogger.captureText(driver,"//*[@class='col-sm-8']", "Result", logger);//matching the capture text with array text
            if (capture.contains(dentalProgram.get(i))){
                System.out.println("The result matches");
                logger.log(LogStatus.PASS,"The result matches");
            }else{
                System.out.println("The result did not match " + capture);
                logger.log(LogStatus.FAIL,"The result did not match " + capture);
            }
            driver.close();//closing the tab/current page
            driver.switchTo().window(tabs.get(0));//switching back to first page
            Thread.sleep(3000);
        }

        //driver.quit();//Quit the page
    }
}
