package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Automation_test//
{
    public static void main(String[] args) throws InterruptedException
    {
        System.setProperty("webdriver.chrome.driver","src//Resource//chromedriver1.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized","incognito");
        WebDriver driver = new ChromeDriver(options);

        String[] zipCode = new String[3];
        zipCode[0]= "11209";
        zipCode[1]= "14213";
        zipCode[2]= "11238";


        driver.navigate().to("https://www.weightwatchers.com/us/");
        Thread.sleep(5000);
                                        //String Title = driver.getTitle(); // you can use different string name.
        showMassage(driver.getTitle()); // getting the title from the driver and directly passing to the method.


        for(int i = 0; i<zipCode.length; i++) {

            driver.findElement(By.id("ela-menu-visitor-desktop-supplementa_find-a-workshop")).click();
            Thread.sleep(4000);

            driver.findElement(By.xpath("//*[@name = 'meetingSearch']")).sendKeys(zipCode[i]);
            driver.findElement(By.xpath("//*[@name = 'meetingSearch']")).submit();
            Thread.sleep(4000);

            if(i == 0)
            {
                driver.findElements(By.xpath("//div[contains(@class, 'location__name')]")).get(1).click();
                //Thread.sleep(3000);
                //String location = driver.findElement(By.xpath("//*[@class = 'location__container']")).getText();
                //System.out.println(location);
                //String schedule = driver.findElement(By.xpath("//*[@class = 'meeting-schedule meeting-detail-bottom-section']")).getText();
                //System.out.println(schedule);
            }else if (i == 1)
            {
                driver.findElements(By.xpath("//div[contains(@class, 'location__name')]")).get(2).click();
                //Thread.sleep(3000);
                //String location = driver.findElement(By.xpath("//*[@class = 'location__container']")).getText();
                //System.out.println(location);
                //String schedule = driver.findElement(By.xpath("//*[@class = 'meeting-schedule meeting-detail-bottom-section']")).getText();
                //System.out.println(schedule);
            }else if (i == 2) {
                driver.findElements(By.xpath("//div[contains(@class, 'location__name')]")).get(0).click();
                //Thread.sleep(3000);
                //String location = driver.findElement(By.xpath("//*[@class = 'location__container']")).getText();
                //System.out.println(location);
                //String schedule = driver.findElement(By.xpath("//*[@class = 'meeting-schedule meeting-detail-bottom-section']")).getText();
                //System.out.println(schedule);
            }
            String location = driver.findElement(By.xpath("//*[@class = 'location__container']")).getText();
            String schedule = driver.findElement(By.xpath("//*[@class = 'meeting-schedule meeting-detail-bottom-section']")).getText();
            System.out.println(location);
            System.out.println(schedule);

            Thread.sleep(2000);

        }
        driver.quit();

    }
    public static void showMassage(String Title)
    {
        if(Title.equals ("WW (Weight Watchers): Weight Loss & Wellness Help"))
        {
            System.out.println("Title of this website is " + Title);
        }else
        {
            System.out.println("The title doesn't match.");
        }

    }

}
