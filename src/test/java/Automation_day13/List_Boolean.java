package Automation_day13;

import CustomReuseable.CustoRereusable_library;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class List_Boolean {

    WebDriver driver;

    @BeforeSuite
    public void defineDriver() throws IOException, InterruptedException {
        driver = CustoRereusable_library.setDriver();

    }//end of before method

    @AfterSuite
    public void CloseDriver(){
        //driver.quit();
    }
    @Test
    public void yahoo_verification() throws InterruptedException {
        driver.navigate().to("https://www.yahoo.com/");
        Thread.sleep(4000);

        List<WebElement>CountLink = driver.findElements(By.xpath("//*[contains(@class,'D(ib) Mstart(21px) Mend(17px)')]"));
        //System.out.println("The link number matches");
        if(CountLink.size() == 12){
            System.out.println("My yahoo page link count match which is " + CountLink.size());
        }else{
            System.out.println("The page links number doesn't match");
        }

        CustoRereusable_library.click(driver,"//*[@id = 'header-signin-link']", "Sign In");
        Thread.sleep(2000);

        boolean CheckboxState = driver.findElement(By.xpath("//*[@id = 'persistent']")).isSelected();
        if(CheckboxState == true){
            System.out.println("Checkbox is selected by default");
        }else{
            System.out.println("Checkbox is not selected by default");
        }

    }//end of test















}//end of java class
