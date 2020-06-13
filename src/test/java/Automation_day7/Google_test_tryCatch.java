package Automation_day7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Google_test_tryCatch
{
        public static void main(String[] args) throws InterruptedException {
            System.setProperty("webdriver.chrome.driver","src//Resource//chromedriver1.exe");

            WebDriver driver = new ChromeDriver(); //declare and define the web driver

            //opening the browser automatically
            driver.navigate().to("http://www.google.com");
            driver.manage().window().maximize();            //this will maximize the google drive

            Thread.sleep(3000);
            try {
                driver.findElement(By.name("q")).sendKeys("cars"); // find the element and send the key words.
            } catch (Exception e) {
                System.out.println("Unable to enter data on search Field" + e);
                //driver.findElement(By.name("btnK")).click();
            }
            try{
                driver.findElement(By.name("q")).submit();
            } catch (Exception e){
                System.out.println("Unable to submit on search Icon" + e);
            }

            Thread.sleep(2000);
            /*try{
                driver.findElement(By.xpath("//*[@name= 'btnK'")).submit();
            } catch (Exception e){
                System.out.println("Unable to ebter data on search Icon" + e);
            }//end of search field exception*/

            try{
                String message = driver.findElement(By.id("result-stats")).getText();
                String[] arrayResult = message.split(" ");
                System.out.println("My search result is " + arrayResult[1]);
            } catch (Exception e){
                System.out.println("unable to capture on search Result " + e);
            }


            ArrayList<String> countries = new ArrayList<>();//this array you don`t have to declare array size, you can keep add values without
            countries.add("Bangladesh");
            countries.add("England");

            System.out.println("My country is " + countries.get(0));

            for(int i = 1; i < countries.size(); i++)









            //Thread.sleep(20000);                    // wait few second before close or quite.

            driver.quit();                //driver will kill the driver from your task memory
            //driver.close();                 //close will only close the driver but not from your memory


        }

}

