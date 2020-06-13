package Yahoo_Page_Object;

import CustomReuseable.Abstract_Class;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Yahoo_Base_Class extends Abstract_Class {

    public Yahoo_Base_Class(WebDriver driver){// webDriver name has to match with the one in Abstract class
        super();
        PageFactory.initElements(driver, this);
    }//end of constructor

    //create a new name to refer to the actual page class
    public static Yahoo_homePage yahoo_homePages(){

        Yahoo_homePage yahoo_homePage = new Yahoo_homePage(driver);
        return yahoo_homePage;
    }
    public static Yahoo_Search_Result_page yahooResult(){
        Yahoo_Search_Result_page yahooResult = new Yahoo_Search_Result_page(driver);
        return yahooResult;
    }

}
