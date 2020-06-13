package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test_being      //Class start from here
{
    //main  method where loops and variables are stored.
    public static void main(String[] args) throws InterruptedException
    {
        //locate where the source of chromedriver and connect with the selenium web driver.
        System.setProperty("webdriver.chrome.driver","src//Resource//chromedriver1.exe");

        //define the webdriver.
        WebDriver driver = new ChromeDriver();

        //Creating two strings variable and each have 5 data storage.
        String[] Country = new String[5];
        Country[0] = "Bangladesh";
        Country[1] = "United states of America";
        Country[2] = "Canada";
        Country[3] = "Japan";
        Country[4] = "Australia";

        //For loop starting point which will run until the string length
        for(int i = 0; i<=4; i++) //conditions inside the for loop
        {   //staring of loop

            driver.get("https://www.bing.com/");// driver will open chrome & get to the bing.com site
            driver.manage().window().maximize();// driver will manage to maximize the window

            Thread.sleep(2000);// system will wait 2 sec before move on to next step

            driver.findElement(By.name("q")).sendKeys(Country[i]);// driver will find the web page element by specific name and will input country string data.
            driver.findElement(By.name("q")).submit();// driver will submit/press enter after getting the data.

            Thread.sleep(4000);

            String SearchNumber = driver.findElement(By.id("b_tween")).getText();//creating a string and storing the text inside the array
            String[] actualNumber = SearchNumber.split(" ");// creating an array string and spliting the text by Space to get the actual number

            //Printing out the result for both variables and the actual search number in the page.
            System.out.println("I am Searching for country " +Country[i] + ". My search result is " + actualNumber[0]);

            Thread.sleep(4000);
        }//ending of the loop
        driver.quit();//system will quite the page


    }// ending of main method.

}//ending of the class.
