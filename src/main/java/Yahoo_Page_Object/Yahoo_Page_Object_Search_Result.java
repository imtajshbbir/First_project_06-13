package Yahoo_Page_Object;

import CustomReuseable.Abstract_Class;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class Yahoo_Page_Object_Search_Result extends Abstract_Class {
    @Test
    public void Yahoo_Search_Result() throws InterruptedException {

        logger.log(LogStatus.INFO,"Navigating to Yahoo");
        driver. navigate().to("https://www.yahoo.com/");
        Thread.sleep(3000);
        Yahoo_Base_Class.yahoo_homePages().SearchField("Cars");



    }

}
