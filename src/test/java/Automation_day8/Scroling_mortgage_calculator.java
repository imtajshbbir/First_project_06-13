package Automation_day8;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class  Scroling_mortgage_calculator
{
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src//Resource//chromedriver1.exe");

        ChromeOptions options = new ChromeOptions();    //set some pre conditions chrome options
        options.addArguments("start-maximized","incognito");    //set the arguments you want for the driver
        WebDriver driver = new ChromeDriver(options);   //define the chrome driver

        driver.navigate().to("https://www.mortgagecalculator.org/");

        Thread.sleep(3000);

        //declare and define javascript
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        //scroll all the way to the bottom of the page
        jse.executeScript("scroll(0,2500)");
        Thread.sleep(2000);
        jse.executeScript("scroll(0,-2500)");

        Thread.sleep(3000);

        try{
            WebElement loanTerm = driver.findElement(By.xpath("//*[@id ='loanterm']"));
            jse.executeScript("arguments[0].scrollIntoView(true);",loanTerm);
        }catch (Exception e){
            System.out.println("unable too locate Loan term " + e);
        }
        Thread.sleep(3000);

        try{
            WebElement homValue = driver.findElement(By.xpath("//*[@id= 'homeval'"));
            jse.executeScript("arguments[0].scrollIntoView(true);",homValue);
        }catch (Exception e){
            System.out.println("unable to locate home value " + e);
        }

        Thread.sleep(3000);
        try{
            driver.findElement(By.xpath("//*[@id ='loanterm']")).clear();
            driver.findElement(By.xpath("//*[@id ='loanterm']")).sendKeys("20");
        } catch (Exception e){
            System.out.println("The loan term is not working" + e);
        }




        Thread.sleep(4000);

        driver.quit();

    }
}
