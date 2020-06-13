package MetLife_page_object;

import CustomReuseable.Abstract_Class;
import CustomReuseable.CustoRereusable_libraryLogger;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MetLife_Enroll_Now extends Abstract_Class {

    ExtentTest MetLifeLogger;

    public MetLife_Enroll_Now(WebDriver driver){

        super();
        PageFactory.initElements(driver, this);
        this.MetLifeLogger = super.logger;

    }//end of constructor

    public MetLife_Enroll_Now dentalTitle(){

        CustoRereusable_libraryLogger.Title(driver, "MetLife TakeAlong Dental | MetLife",logger);
        return new MetLife_Enroll_Now(driver);
    }

    public MetLife_Enroll_Now enroll_now(){

        CustoRereusable_libraryLogger.MouseClick(driver,"//*[contains(text(),'Enroll Now')]", "Enroll now Button", logger);
        return new MetLife_Enroll_Now(driver);
    }

}
