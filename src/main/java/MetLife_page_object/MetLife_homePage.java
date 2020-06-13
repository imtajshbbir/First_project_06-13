package MetLife_page_object;

import CustomReuseable.Abstract_Class;
import CustomReuseable.CustoRereusable_libraryLogger;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MetLife_homePage extends Abstract_Class {

    ExtentTest MetLifeLogger;

    public MetLife_homePage(WebDriver driver){

        super();
        PageFactory.initElements(driver, this);
        this.MetLifeLogger = super.logger;

    }//end of constructor

    public MetLife_homePage title(){

        CustoRereusable_libraryLogger.Title(driver, "Insurance and Employee Benefits | MetLife", logger);

        return new MetLife_homePage(driver);
    }

    public MetLife_homePage Solution(){

        CustoRereusable_libraryLogger.MouseHover(driver,"//*[contains(text(),'SOLUTIONS')]","Solution", logger);
        return new MetLife_homePage(driver);

    }
    public  MetLife_homePage Dental(){

        CustoRereusable_libraryLogger.MouseClick(driver,"//*[contains(text(),'MetLife TakeAlong Dental')]","TakeAlong Dental", logger );
        return new MetLife_homePage(driver);
    }

}
