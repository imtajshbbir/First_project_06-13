package practice;

import CustomReuseable.Abstract_Class;
import CustomReuseable.CustoRereusable_libraryLogger;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class YahooQAWikipedia extends Abstract_Class {

    @Test
    public void YahooQA() throws InterruptedException {

        driver.navigate().to("https://www.yahoo.com/");
        Thread.sleep(3000);
        CustoRereusable_libraryLogger.userTypeAndHitEnter(driver, "//*[@name = 'p']", "QA", "Searching QA", logger);
        Thread.sleep(3000);
        CustoRereusable_libraryLogger.MouseClick(driver, "//*[contains(text(),'Quality assurance - Wikipedia')]","Wikipedia", logger);
        Thread.sleep(3000);

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        CustoRereusable_libraryLogger.captureText(driver,"//*[contains(text(),'Middle Ages')]", "Text from QA site",logger);
        driver.close();
        driver.switchTo().window(tabs.get(0));
        Thread.sleep(3000);

    }

}
