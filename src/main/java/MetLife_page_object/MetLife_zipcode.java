package MetLife_page_object;

import CustomReuseable.Abstract_Class;
import CustomReuseable.CustoRereusable_libraryLogger;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MetLife_zipcode extends Abstract_Class {

    ExtentTest MetLifeLogger;

    public MetLife_zipcode(WebDriver driver){

        super();
        PageFactory.initElements(driver, this);
        this.MetLifeLogger = super.logger;

    }//end of constructor

    public MetLife_zipcode enterZipcode(String UserValue){

        CustoRereusable_libraryLogger.userKeys(driver,"//*[@id='txtZipCode']",UserValue, "Entering Zip", logger);

        return new MetLife_zipcode(driver);
    }

    public MetLife_zipcode ZipcodeClick(){

        CustoRereusable_libraryLogger.MouseClick(driver,"//*[@id = 'txtZipCodetxt']","Go Button", logger);

        return new MetLife_zipcode(driver);
    }

}
