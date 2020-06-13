package MetLife_page_object;

import CustomReuseable.Abstract_Class;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class MetLife_PageHandels extends Abstract_Class {


    ExtentTest MetLifeLogger;

    public MetLife_PageHandels(WebDriver driver){

        super();
        PageFactory.initElements(driver, this);
        this.MetLifeLogger = super.logger;

    }//end of constructor

    public MetLife_PageHandels metLife_pageHandels(int UserValue){

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());//declaring array list for handling tabs
        driver.switchTo().window(tabs.get(UserValue));//switching the tabs to second tab
        return new MetLife_PageHandels(driver);
    }

}
