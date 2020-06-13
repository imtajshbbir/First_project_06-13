package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;

public class Atena_Practice_Test {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src//Resource//chromedriver1.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized", "incognito");
        WebDriver driver = new ChromeDriver(options);

        ArrayList<String> ZipCOde = new ArrayList<>();
        ZipCOde.add("11230");
        ZipCOde.add("11226");
        ZipCOde.add("11235");


        driver.navigate().to("https://www.aetna.com/");

        String HealthTitle = driver.getTitle();

        Actions mouse = new Actions(driver);

        if (HealthTitle.equals("Health Insurance Plans | Aetna")) {
            System.out.println("Page title is " + HealthTitle);
        } else {
            System.out.println("The title does not match");
        }
        Thread.sleep(3000);

        try {
            driver.findElement(By.xpath("//*[@class='megamenu__primary--item--btn']")).click();
        } catch (Exception e) {
            System.out.println("Unable to click on shop for plan" + e);
        }
        Thread.sleep(3000);

        try {
            WebElement medicare = driver.findElement(By.xpath("//button[text()='Medicare']"));
            mouse.moveToElement(medicare).perform();
        } catch (Exception e) {
            System.out.println("Unable to hover over medicare" + e);
        }
        Thread.sleep(3000);

        try {
            driver.findElement(By.xpath("//*[contains(text(),'Find a doctor')]")).click();
        } catch (Exception e) {
            System.out.println("Unable to click on find a doctor " + e);
        }
        Thread.sleep(3000);

        for (int i =0; i < ZipCOde.size();i++) {
            try {
                driver.findElement(By.xpath("//*[contains(text(),'2020 Medicare plans you purchase yourself')]")).click();
            } catch (Exception e) {
                System.out.println("unable to click on medicare for yourself " + e);
            }
            Thread.sleep(3000);

            try {
                WebElement enterZip = driver.findElement(By.xpath("//*[@id = 'medZip']"));
                enterZip.clear();
                enterZip.sendKeys(ZipCOde.get(i));
            } catch (Exception e) {
                System.out.println("unable to enter zipCode " + e);
            }
            Thread.sleep(3000);

            try {
                driver.findElement(By.xpath("//*[@class = 'typeahead_grouping active']")).click();
            } catch (Exception e) {
                System.out.println("unable to select/click Zipcode " + e);
            }
            Thread.sleep(3000);


            try {
                WebElement SlidBar = driver.findElement(By.xpath("//*[@class= 'sliderMiles']"));
                mouse.dragAndDropBy(SlidBar, 17, 0).build().perform();
            } catch (Exception e) {
                System.out.println("unable to select/move slidebar " + e);
            }
            Thread.sleep(3000);

            try {
                driver.findElement(By.xpath("//*[contains(text(),'Skip plan selection*')]")).click();
            } catch (Exception e) {
                System.out.println("Unable to click on Skip plan " + e);
            }
            Thread.sleep(3000);


            String imagePath = "//img[contains(@class, 'tile-icon')]";

            try {
                driver.findElements(By.xpath(imagePath)).get(0).click();
            } catch (Exception e) {
                System.out.println("Unable to click on medical doctor " + e);
            }
            Thread.sleep(3000);

            try {
                driver.findElements(By.xpath(imagePath)).get(0).click();
            } catch (Exception e) {
                System.out.println("Unable to click on doctors(primary doctors " + e);
            }
            Thread.sleep(3000);

            try {
                driver.findElement(By.xpath("//*[contains(text(),'All Primary Care Physicians')]")).click();
            } catch (Exception e) {
                System.out.println("unable to click on All Primary Care Physicians " + e);
            }
            Thread.sleep(6000);

            try {
                String CaptureText = driver.findElement(By.xpath("//*[@header='grid-hdr-name']")).getText();
                System.out.println("\n" + CaptureText);
            } catch (Exception e) {
                System.out.println("Unable to capture the information " + e);
            }
            Thread.sleep(6000);

            driver.navigate().to("https://www.aetna.com/dsepublic/#/contentPage?page=providerSearchLanding&site_id=medicare&language=en");
            Thread.sleep(4000);
        }

        Thread.sleep(4000);

        driver.quit();
    }
}
