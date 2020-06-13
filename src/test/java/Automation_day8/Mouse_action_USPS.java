package Automation_day8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Mouse_action_USPS
{
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src//Resource//chromedriver1.exe");

        ChromeOptions options = new ChromeOptions();    //set some pre conditions chrome options
        options.addArguments("start-maximized","incognito");    //set the arguments you want for the driver
        WebDriver driver = new ChromeDriver(options);   //define the chrome driver

        driver.navigate().to("https://www.usps.com/"); //navigate to USPS
        Thread.sleep(3000);

        //call your mouse action
        Actions mouse = new Actions(driver);
        //hover to mail & ship tab
        try{
            WebElement mailAndShip = driver.findElement(By.xpath("//*[text() ='Mail & Ship']"));
            mouse.moveToElement(mailAndShip).perform();
        }catch (Exception e){
            System.out.println("Mail and ship doesn`t work" + e);
        }

        Thread.sleep(3000);
        //click on click-n-ship
        try{
            //WebElement clickAndShip = driver.findElement(By.xpath("//*[@class ='tool-cns']"));
            WebElement clickAndShip = driver.findElement(By.xpath("//*[@class ='tool-cns']/a[text()='Click-N-Ship']"));
            //WebElement clickAndShip = driver.findElement(By.xpath("//a[text()='Click-N-Ship']/preseding::li[@class ='tool-cns']/"));
            mouse.moveToElement(clickAndShip).click().perform();
            //mouse.moveToElement(clickAndShip).sendKeys(Keys.ENTER).perform();
        }catch (Exception e){
            System.out.println("click and ship doesn`t work" + e);
        }



        Thread.sleep(4000);
        driver.quit();

    }
}
