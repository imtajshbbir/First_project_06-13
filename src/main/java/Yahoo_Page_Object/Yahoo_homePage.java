package Yahoo_Page_Object;

import CustomReuseable.Abstract_Class;
import CustomReuseable.CustoRereusable_libraryLogger;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Yahoo_homePage extends Abstract_Class {


    ExtentTest loggerYahoo; //you can declare local logger even tho logger declared in Abstract class
    //we need to create a constructor method that defines
    //driver and logger to be reuse localy to this page class

    public Yahoo_homePage(WebDriver driver){// webdriver name has to match with the one in Abstract class
        super();
        PageFactory.initElements(driver, this);
        //local page gets set to abstract class logger when you use it in
        //page object concept
        this.loggerYahoo = super.logger;//super is the Abstract class logger
    }//end of constructor

    //method for SearchField
    public Yahoo_homePage SearchField(String userValue){
        CustoRereusable_libraryLogger.userKeys(driver, "//*[@id='header-search-input']", userValue, "Search Field", loggerYahoo);

        return new Yahoo_homePage(driver);//
    }

    public Yahoo_homePage SearIcon(){
        CustoRereusable_libraryLogger.click(driver, "//*[@id='header-desktop-search-button']", "Search Field", loggerYahoo);

        return new Yahoo_homePage(driver);//
    }


}
