package MetLife_page_object;

import CustomReuseable.Abstract_Class;
import CustomReuseable.CustoRereusable_libraryLogger;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MetLife_CaptureText extends Abstract_Class {

    ExtentTest MetLifeLogger;

    public MetLife_CaptureText(WebDriver driver){

        super();
        PageFactory.initElements(driver, this);
        this.MetLifeLogger = super.logger;

    }//end of constructor

    public MetLife_CaptureText metLife_captureText(){

        CustoRereusable_libraryLogger.captureText(driver,"//*[@class='col-sm-8']", "Result", logger);//matching the capture text with array text
        return new MetLife_CaptureText(driver);
    }

}
