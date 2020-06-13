package practice;

import CustomReuseable.Abstract_Class;
import CustomReuseable.CustoRereusable_libraryLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class WeightWatchersAbstract extends Abstract_Class {

    @Test
    public void weightWatcher() throws InterruptedException {

        ArrayList<String> ZipCode = new ArrayList<>();
        ZipCode.add("11209");
        ZipCode.add("14213");
        ZipCode.add("11238");

        driver.navigate().to("https://www.weightwatchers.com/us/");
        Thread.sleep(3000);
        CustoRereusable_libraryLogger.Title(driver, "WW (Weight Watchers): Weight Loss & Wellness Help | WW USA", logger);
        Thread.sleep(3000);

        for (int i = 0; i < ZipCode.size(); i++) {

            CustoRereusable_libraryLogger.MouseClick(driver, "//*[contains(text(),'Find a Workshop')]", "Find workshop", logger);
            Thread.sleep(3000);

            CustoRereusable_libraryLogger.userTypeAndHitEnter(driver, "//*[@name = 'meetingSearch']", ZipCode.get(i), "Zipcode", logger);
            Thread.sleep(3000);

            if (i == 0) {
                CustoRereusable_libraryLogger.clickByIndex(driver, "//div[contains(@class, 'location__name')]", 1, "Location 1", logger);
                Thread.sleep(3000);
            } else if (i == 1) {
                CustoRereusable_libraryLogger.clickByIndex(driver, "//div[contains(@class, 'location__name')]", 2, "Location 2", logger);
                Thread.sleep(3000);
            } else if (i == 2) {
                CustoRereusable_libraryLogger.clickByIndex(driver, "//div[contains(@class, 'location__name')]", 0, "Location 3", logger);
                Thread.sleep(3000);
            }
            CustoRereusable_libraryLogger.captureText(driver, "//*[@class = 'location__container']", "Capture location", logger);
            CustoRereusable_libraryLogger.captureText(driver, "//*[@class = 'meeting-schedule meeting-detail-bottom-section']", "Capturing Schedule", logger);
            Thread.sleep(2000);

        }

    }

}
