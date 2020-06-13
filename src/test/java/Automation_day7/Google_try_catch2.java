package Automation_day7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Google_try_catch2 {
        public static void main(String[] args) throws InterruptedException {
            System.setProperty("webdriver.chrome.driver", "src//Resource//chromedriver1.exe");

            WebDriver driver = new ChromeDriver(); //declare and define the web driver

            //create a dynamic array for city to loop through certain values from the array
            String[] city = new String[4];
            city[0] = "Brooklyn";
            city[1] = "Queens";
            city[2] = "Manhattan";
            city[3] = "Bronx";


            for (int i = 0; i < city.length; i++) {

                //opening the browser automatically
                driver.get("http://www.google.com");
                driver.manage().window().maximize();            //this will maximize the google drive

                Thread.sleep(3000);

                driver.findElement(By.name("q")).sendKeys(city[i]);  // find the element and send the key words.

                //driver.findElement(By.name("btnK")).click();
                driver.findElement(By.name("q")).submit();

                Thread.sleep(2000);
                //System.out.println("My city is " + city[i]);

                String message = driver.findElement(By.id("result-stats")).getText();

                String[] arrayResult = message.split(" ");
                System.out.println("My city is " + city[i] + " & My result is " + arrayResult[1]);
            }
            Thread.sleep(2000);                    // wait few second before close or quite.
            driver.quit();                //driver will kill the driver from your task memory
            //driver.close();                 //close will only close the driver but not from your memory



        }

}

