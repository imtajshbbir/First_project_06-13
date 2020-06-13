package practice;


import CustomReuseable.CustoRereusable_library;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;

public class Express_Automation
{
    public static void main(String[] args) throws IOException, BiffException, InterruptedException, WriteException {

        //locating readable file
        Workbook readFile = Workbook.getWorkbook(new File("src/Resource/Express_info.xls"));

        //locating the sheet
        Sheet readSheet = readFile.getSheet(0);

        //creating a writeable workbook too replicate the readFile
        WritableWorkbook WriteableFile = Workbook.createWorkbook(new File("src/Resource/Express_info_details.xls"),readFile);

        //creating writeable sheet
        WritableSheet writeSheet = WriteableFile.getSheet(0);

        //getting the total not empty rows
        int rows = writeSheet.getRows();

        //define the WebDriver using custom Reusable method
        WebDriver driver = CustoRereusable_library.setDriver();


        for (int i =1; i<rows;i++) {//for loop start

            //navigating to Express.com
            driver.navigate().to("https://www.express.com/");
            Thread.sleep(3000);


            CustoRereusable_library.MouseHover(driver,"//*[@class = '_399XX MegaMenu_primaryNav__label__1s3d1']","women");
            Thread.sleep(3000);

            CustoRereusable_library.MouseClick(driver, "//*[contains(text(),'Dresses')]","Dresses");
            Thread.sleep(3000);

            CustoRereusable_library.MouseClick(driver,"//*[@class = '_1ddDj _136PD']", "First Dress");
            Thread.sleep(3000);

            //getting the Size values from excel
            String Size = writeSheet.getCell(0,i).getContents();
            CustoRereusable_library.MouseClick(driver, "//*[text()='"+ Size +"']", "Sizes");
            Thread.sleep(2000);

            CustoRereusable_library.MouseClick(driver, "//*[contains(text(),'Add to Bag')]", "Add to bag");

            CustoRereusable_library.MouseHover(driver, "//div[3]/div[1]/button[1]", "Shopping bag");

            CustoRereusable_library.MouseClick(driver, "//a[contains(text(),'View Bag & Check Out')]", "View bag &check out");

            //getting the Quantity values from excel
            String Quantity = writeSheet.getCell(1, i).getContents();

            CustoRereusable_library.dropdownText(driver,"//*[@id = 'qdd-0-quantity']", Quantity, "Quantity dropdown");

            CustoRereusable_library.MouseClick(driver,"//*[@id = 'continue-to-checkout']", "Checkout");

            CustoRereusable_library.MouseClick(driver,"//button[contains(text(),'Continue as Guest')]", "Guest");

            //getting the first name
            String FirstName = writeSheet.getCell(2,i).getContents();

            CustoRereusable_library.userKeys(driver,"//*[@name = 'firstname']", FirstName, "First Name");

            //getting the first name
            String LastName = writeSheet.getCell(3,i).getContents();

            CustoRereusable_library.userKeys(driver,"//*[@name = 'lastname']", LastName, "Last Name");

            //getting the value of Email from excel
            String Email = writeSheet.getCell(4,i).getContents();

            CustoRereusable_library.userKeys(driver,"//*[@name = 'email']", Email, "Email Address");
            //Thread.sleep(4000);

            CustoRereusable_library.userKeys(driver,"//*[@name = 'confirmEmail']",Email, "Confirm Email Address");

            //getting the value of Phone Number from excel
            String PhoneNumber = writeSheet.getCell(5,i).getContents();


            CustoRereusable_library.userKeys(driver,"//*[@name = 'phone']",PhoneNumber, "Phone Number");

            CustoRereusable_library.MouseClick(driver,"//*[contains(text(),'Continue')]", "Continue");

            //getting the street address from excel
            String StreetAddress = writeSheet.getCell(6,i).getContents();

            CustoRereusable_library.userKeys(driver,"//*[@name = 'shipping.line1']",StreetAddress, "Phone Number");

            //getting the postal code from excel
            String PostalCode = writeSheet.getCell(7,i).getContents();

            CustoRereusable_library.userKeys(driver,"//*[@name = 'shipping.postalCode']",PostalCode, "Phone Number");

            //getting city from excel
            String City = writeSheet.getCell(8,i).getContents();

            CustoRereusable_library.userKeys(driver,"//*[@name = 'shipping.city']",City, "City Name");

            //getting State from excel
            String State = writeSheet.getCell(9,i).getContents();

            CustoRereusable_library.dropdownText(driver,"//*[@name = 'shipping.state']",State, "State");
            Thread.sleep(2000);

            CustoRereusable_library.MouseClick(driver,"//*[contains(text(),'Continue')]", "Continue");
            Thread.sleep(2000);

            CustoRereusable_library.MouseClick(driver,"//span[contains(text(),'Continue')]", "Continue");
            Thread.sleep(2000);

            String CardNumber = writeSheet.getCell(10,i).getContents();

            CustoRereusable_library.userKeys(driver,"//*[@id = 'creditCardNumberInput']",CardNumber, "Credit card number");
            Thread.sleep(2000);

            String ExpireMonth = writeSheet.getCell(11,i).getContents();

            CustoRereusable_library.dropdownText(driver,"//*[@name='expMonth']",ExpireMonth,"Card Expire Month");

            String ExpireYear = writeSheet.getCell(12,i).getContents();

            CustoRereusable_library.dropdownText(driver,"//*[@name='expYear']",ExpireYear,"Card Expire Year");

            String CVV = writeSheet.getCell(13,i).getContents();

            CustoRereusable_library.userKeys(driver, "//*[@name='cvv']", CVV,"Card Security code");
            Thread.sleep(2000);

            CustoRereusable_library.MouseClick(driver,"//*[contains(text(),'Place Order')]", "Place Order");

            String ErroMsg = CustoRereusable_library.captureText(driver,"//*[@id = 'rvn-note-NaN']", "Error Message");
            System.out.println(ErroMsg);

            Label Text = new Label(14,i,ErroMsg); //14 is the column and 1 is the row

            writeSheet.addCell(Text);

            driver.manage().deleteAllCookies();

        }//end of for loop

        Thread.sleep(4000);

        WriteableFile.write();
        WriteableFile.close();
        readFile.close();

        driver.quit();
    }//end of the main method
}
