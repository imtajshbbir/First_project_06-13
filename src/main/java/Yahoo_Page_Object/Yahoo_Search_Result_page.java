package Yahoo_Page_Object;

import CustomReuseable.Abstract_Class;
import CustomReuseable.CustoRereusable_libraryLogger;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Yahoo_Search_Result_page extends Abstract_Class {

    ExtentTest loggerYahoo;

    public Yahoo_Search_Result_page(WebDriver driver){// webdriver name has to match with the one in Abstract class
        super();
        PageFactory.initElements(driver, this);
        //local page gets set to abstract class logger when you use it in
        //page object concept
        this.loggerYahoo = super.logger;//super is the Abstract class logger
    }//end of constructor

    public Yahoo_Search_Result_page ScrollToBottom(){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        logger.log(LogStatus.INFO,"Scrolling to the bottom of yahoo Search result page");
        jse.executeScript("scroll(0,10000)");
        return new Yahoo_Search_Result_page(driver);
    }

    public Yahoo_Search_Result_page SearchNumber(){

        String SearchResult = CustoRereusable_libraryLogger.captureText(driver, "//*[@class='compPagination']", "Search Result", loggerYahoo);
        String[] SearchNumber = SearchResult.split("Next");
        logger.log(LogStatus.INFO,"The Search number is" + SearchNumber[1]);
        return new Yahoo_Search_Result_page(driver);
    }

}
