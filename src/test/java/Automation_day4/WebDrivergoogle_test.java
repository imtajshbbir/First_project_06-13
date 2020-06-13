package Automation_day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDrivergoogle_test
{
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src//Resource//chromedriver1.exe");

        WebDriver driver = new ChromeDriver(); //declare and define the web driver

        //opening the browser automatically
        driver.navigate().to("http://www.google.com");
        driver.manage().window().maximize();            //this will maximize the google drive

        Thread.sleep(3000);

        driver.findElement(By.name("q")).sendKeys("cars");  // find the element and send the key words.

        //driver.findElement(By.name("btnK")).click();
        driver.findElement(By.name("q")).submit();

        Thread.sleep(2000);

        String message = driver.findElement(By.id("result-stats")).getText();

        String[] arrayResult = message.split(" ");
        System.out.println("My search result is " + arrayResult[1]);


        //Thread.sleep(20000);                    // wait few second before close or quite.

        driver.quit();                //driver will kill the driver from your task memory
        //driver.close();                 //close will only close the driver but not from your memory


    }

}
