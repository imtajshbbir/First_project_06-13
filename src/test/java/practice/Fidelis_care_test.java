package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Fidelis_care_test
{
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src//Resource//chromedriver1.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized","incognito");
        WebDriver driver = new ChromeDriver(options);

        driver.navigate().to("https://www.fideliscare.org/");
        Thread.sleep(2500);

        try{
            driver.findElement(By.xpath("//*[@id = 'root-2']")).click();
        } catch (Exception e){
            System.out.println("provider is not working" + e );
        }

        Thread.sleep(3000);

        try{
            driver.navigate().to("https://www.fideliscare.org/Find-A-Doctor");
        } catch (Exception e){
            System.out.println("This is find doctor " + e );
        }

        try{
            driver.findElement(By.xpath("//*[@id = 'searchLocation'")).sendKeys("14213");

        }catch(Exception e){
            System.out.println("The location does not work" + e);
        }


        Thread.sleep(4000);

        driver.quit();

    }
}
