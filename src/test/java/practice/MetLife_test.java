package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;


public class MetLife_test {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src//Resource//chromedriver1.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized","incognito");
        WebDriver driver = new ChromeDriver(options);

        driver.navigate().to("https://www.metlife.com/");
        /*try {
            //driver.findElement(By.xpath("//div[contains(@class,'header__navigation-container-menu-item')]")).click();
            driver.findElement(By.xpath("//*[contains(text(),'SUPPORT')]")).click();
        }catch (Exception e){
            System.out.println("This is support " + e);
        }

        try{
            driver.findElement(By.xpath("//div[contains(text(),'Find a Vision Provider')]")).click();
        }catch (Exception e){
            System.out.println("This is find the doc " + e);
        }*/

        try{
            driver.findElement(By.xpath("//*[contains(text(),'SOLUTIONS')]")).click();
        } catch (Exception e){
            System.out.println("Unable to submit on search Icon" + e);
        }

        Thread.sleep(4000);

        try{
            driver.findElement(By.xpath("//*[contains(text(),'MetLife TakeAlong Dental')]")).click();
            driver.findElement(By.xpath("//*[contains(text(),'MetLife TakeAlong Dental')]")).click();
        } catch (Exception e){
            System.out.println("Unable to get to MetLife takeAlong dental Icon" + e);
        }
        Thread.sleep(3000);
        try{
            driver.findElement(By.xpath("//*[contains(text(),'Enroll Now')]")).click();
        } catch (Exception e){
            System.out.println("Unable to get to enroll now" + e);
        }

        Thread.sleep(3000);
        //now define the arraylist to handle all current window tabs that are open
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        //switch to new tabs
        driver.switchTo().window(tabs.get(1));
        Thread.sleep(5000);

        Thread.sleep(3000);

        driver.quit();

    }
}
