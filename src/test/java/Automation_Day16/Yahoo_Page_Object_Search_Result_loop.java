package Automation_Day16;

import CustomReuseable.Abstract_Class;
import Yahoo_Page_Object.Yahoo_Base_Class;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class Yahoo_Page_Object_Search_Result_loop extends Abstract_Class {
    @Test
    public void Yahoo_Search_Result() throws InterruptedException {

        ArrayList<String> Cars = new ArrayList<>();
        Cars.add("Alfa Romeo");
        Cars.add("BMW");
        Cars.add("Lexus");



        for (int i = 0; i<Cars.size(); i++) {
            logger.log(LogStatus.INFO, "Navigating to Yahoo");
            driver.navigate().to("https://www.yahoo.com/");
            Thread.sleep(3000);
            Yahoo_Base_Class.yahoo_homePages().SearchField(Cars.get(i));
            Yahoo_Base_Class.yahoo_homePages().SearIcon();
            Yahoo_Base_Class.yahooResult().ScrollToBottom();
            Yahoo_Base_Class.yahooResult().SearchNumber();

        }//end loop

    }

}
