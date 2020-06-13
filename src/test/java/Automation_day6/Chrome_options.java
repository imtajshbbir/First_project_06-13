package Automation_day6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Chrome_options
{
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src//Resource//chromedriver1.exe");

        ChromeOptions options = new ChromeOptions();    //set some pre conditions chrome options
        options.addArguments("start-maximized","incognito");    //set the arguments you want for the driver
        WebDriver driver = new ChromeDriver(options);   //define the chrome driver

        driver.navigate().to("https://www.mlcalc.com"); //navigate to the website (mlcalc.com)
        Thread.sleep(6000);

        //System.out.println("My title is " + driver.getTitle());//i want to capture the title
        String TheTitle = driver.getTitle();
        if(TheTitle.equals ("MORTGAGE CALCULATOR & LOAN CALCULATOR"))
        {
            System.out.println("Title matches with expected");
        }else{
            System.out.println("Title does not match " + TheTitle);
        }

        //if same locator use more than once then store it as a WebElement variable
        WebElement pPrice = driver.findElement(By.xpath("//*[@name='ma']"));
        pPrice.clear();
        pPrice.sendKeys("40,000");

        Thread.sleep(4000);

        WebElement dPayment = driver.findElement(By.xpath("//*[@name='dp']"));
        dPayment.clear();
        dPayment.sendKeys("20");

        Thread.sleep(4000);

        WebElement mTerm = driver.findElement(By.xpath("//*[@name='mt']"));
        mTerm.clear();
        mTerm.sendKeys("20");

        Thread.sleep(4000);

        //store your start month in Webelement variable and call it on your select command
        WebElement sMonth = driver.findElement(By.xpath("//*[@name='sm']"));
        //call my select command and it only works when your dropdown locator is under select tag
        Select sMothList = new Select(sMonth);
        sMothList.selectByVisibleText("May");

        Thread.sleep(4000);

        WebElement sYear = driver.findElement(By.xpath("//*[@name='sy']"));
        Select sYearList = new Select(sYear);
        sYearList.selectByVisibleText("2018");

        Thread.sleep(4000);

        //This is other way to write if the value is not under //select\\ tag/

        //whenever drop down is not under select tag then we must click on the dropdown and then
        //click on the value of the dropdown
        driver.findElement(By.xpath("//*[@name='sy']")).click();
        Thread.sleep(4000);
        driver.findElements(By.xpath("//*[text()='2019']"));

        Thread.sleep(4000);

        //verify some of the start year to make sure its matching on the drop down
        String[] yearArray = new String[]{"2010","2014","2016","2026"};
        for(int i =0; i<yearArray.length; i++){
            driver.findElement(By.xpath("//*[@name='sy']")).click();
            Thread.sleep(4000);
            driver.findElement(By.xpath("//*[text()='"+ yearArray[i] +"']")).click();
        }

        Thread.sleep(4000);

        driver.quit();
    }

}
