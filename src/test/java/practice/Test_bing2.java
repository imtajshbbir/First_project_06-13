package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test_bing2
{
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src//Resource//chromedriver1.exe");

        WebDriver driver = new ChromeDriver();

        String[] state = new String[5];
        state[0] = "Chittagong";
        state[1] = "New york";
        state[2] = "Austin";
        state[3] = "London";
        state[4] = "vancouver";

        String[] places = new String[5];
        places[0] = "Cox's Bazaar";
        places[1] = "Niagara falls";
        places[2] = "Lyndon B. Johnson State Park";
        places[3] = "Tower of London";
        places[4] = "Stanley Park";


        for(int i = 0; i<state.length; i++)
        {
            driver.navigate().to("https://www.bing.com/");
            driver.manage().window().maximize();
            Thread.sleep(2000);

            driver.findElement(By.id("sb_form_q")).sendKeys(state[i]);
            driver.findElement(By.id("sb_form_q")).submit();
            Thread.sleep(4000);


            driver.navigate().to("https://www.bing.com/");
            driver.manage().window().maximize();
            Thread.sleep(2000);

            driver.findElement(By.id("sb_form_q")).sendKeys(places[i]);
            driver.findElement(By.id("sb_form_q")).submit();
            Thread.sleep(4000);

            String searchResult = driver.findElement(By.id("b_tween")).getText();
            String[] totalResult = searchResult.split(" ");

            System.out.println("My total search result is " + totalResult[0]);

        }
        driver.quit();


    }
}
