package Automation_Day9;


import CustomReuseable.CustoRereusable_library;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.ArrayList;

public class StateFarm_Test
{
    public static void main(String[] args) throws InterruptedException, IOException {
//        System.setProperty("webdriver.chrome.driver", "src//Resource//chromedriver1.exe");
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("start-maximized", "incognito");
//        WebDriver driver = new ChromeDriver(options);

        ArrayList<String> product = new ArrayList<>();
        product.add("Auto");
        product.add("Homeowners");
        product.add("Renters");

        ArrayList<String> ZipCode = new ArrayList<>();
        ZipCode.add("11230");
        ZipCode.add("11223");
        ZipCode.add("11216");

        WebDriver driver = CustoRereusable_library.setDriver();

        for (int i = 0; i < product.size(); i++) {

            driver.navigate().to("https://www.statefarm.com/");
            Thread.sleep(3000);

            CustoRereusable_library.Title(driver, "Auto, Life Insurance, Banking, & More. Get a Free Quote - State Farm®");
            //call my customReusable method
            CustoRereusable_library.dropdownText(driver, "//*[@id = 'popDropdown']",product.get(i), "product");

            CustoRereusable_library.userKeys(driver, "//*[@id = 'quote-main-zip-code-input']", ZipCode.get(i), "Zipcode");

            CustoRereusable_library.click(driver, "//*[@id = 'quote-main-zip-btn']", "Start Quote");

            CustoRereusable_library.captureText(driver, "//*[contains(text(),'Get your quote in a few minutes')]", "Get Quote");


        }

    }

}
