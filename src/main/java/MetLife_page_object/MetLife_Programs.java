package MetLife_page_object;

import CustomReuseable.Abstract_Class;
import CustomReuseable.CustoRereusable_libraryLogger;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MetLife_Programs extends Abstract_Class {

    ExtentTest loggerMetLife;

    public MetLife_Programs(WebDriver driver){// webdriver name has to match with the one in Abstract class
        super();
        PageFactory.initElements(driver, this);
        this.loggerMetLife = super.logger;//super is the Abstract class logger
    }//end of constructor

    public MetLife_Programs metLife_dentalPrograms(String UserValue){

        CustoRereusable_libraryLogger.MouseClick(driver,"//*[@class = '" + UserValue + "']", "First dental", logger);
        return new MetLife_Programs(driver);
    }

    public MetLife_Programs metLife_programNow(){

        CustoRereusable_libraryLogger.MouseClick(driver,"//*[@id ='topenrolltab']", "Program option", logger);
        return new MetLife_Programs(driver);
    }

    public MetLife_Programs metLife_referralCode(String UserValue){

        CustoRereusable_libraryLogger.userKeys(driver,"//*[@id = 'txtBxPromocode']",UserValue, "Promotion code", logger );
        return new MetLife_Programs(driver);
    }

    public MetLife_Programs metLife_referralClick(){

        CustoRereusable_libraryLogger.MouseClick(driver,"//*[@name='btnEnroll']", "Enroll with code", logger);
        return new MetLife_Programs(driver);

    }

    public MetLife_Programs metLife_captureError(){

        CustoRereusable_libraryLogger.captureText(driver,"//*[@id ='lblRefCodeError']", "error message", logger);
        return new MetLife_Programs(driver);
    }

    public MetLife_Programs metLife_withoutCode(){

        CustoRereusable_libraryLogger.MouseClick(driver,"//*[@id='withoutrefcode']", "Without referall code", logger);
        return new MetLife_Programs(driver);
    }


}
