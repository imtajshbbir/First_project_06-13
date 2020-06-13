package Automation_day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class locate_by_xpath
{
    public static void main(String[] args) throws InterruptedException {

        //define property or if you defiend it previously then you dont have to define it anymore.
        System.setProperty("webdriver.chrome.driver","src//Resource//chromedriver1.exe");

        WebDriver driver = new ChromeDriver();

        String imagePath = "//img[contains(@class, 's-image')]";

        driver.navigate().to("https://www.amazon.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id = 'twotabsearchtextbox' and @name = 'field-keywords']")).sendKeys("laptop");
        driver.findElement(By.xpath("//*[@id = 'twotabsearchtextbox' and @name = 'field-keywords']")).submit();

        Thread.sleep(3000);
        //click on first image item of the same //findelements// within that page using index number

        driver.findElements(By.xpath("//*[@class = 's-image']")).get(3).click();

        Thread.sleep(4000);

        driver.navigate().to("https://www.amazon.com/");
        driver.manage().window().maximize();
        Thread.sleep(4000);

        driver.findElement(By.xpath("//*[@id = 'twotabsearchtextbox' and @name = 'field-keywords']")).sendKeys("laptop");
        driver.findElement(By.xpath("//*[@id = 'twotabsearchtextbox' and @name = 'field-keywords']")).submit();

        Thread.sleep(3000);
        driver.findElements(By.xpath(imagePath)).get(2).click();

        Thread.sleep(6000);


        driver.quit();

    }//end of main\

}

