package CustomReuseable;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.io.IOException;

public class CustoRereusable_library
{
    static int timeout = 20;

    //method to re use chrome driver and chrome options
    public static WebDriver setDriver() throws IOException, InterruptedException {
        //way to kill the driver instead of using driver.quit
        Runtime.getRuntime().exec("taskkill / F / IM chromedriver1.exe /T");
        Thread.sleep(2000);
        //set the chrome path
        System.setProperty("webdriver.chrome.driver", "src//main//resources//chromedriver1.exe");
        //set some pre conditions using ChromeOptions
        Thread.sleep(2000);
        ChromeOptions options = new ChromeOptions();
        //set the arguments you want for the driver
        options.addArguments("start-maximized","incognito");
        //now simply define your chrome driver
        WebDriver driver = new ChromeDriver(options);

        return driver;
    }


    public  static  void Title(WebDriver driver, String expectedTitle){
        String pageTitle = driver.getTitle();
        if (pageTitle.equals(expectedTitle)){
            System.out.println("Expected title matches with the actual " + expectedTitle);
        }else {
            System.out.println("The title doesn`t match" + pageTitle);
        }


    }
    public static void dropdownText(WebDriver driver,String locator, String userValue, String elementName){

        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try{
            System.out.println("Selecting a value on element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            Select dDown = new Select(element);
            dDown.selectByVisibleText(userValue);
        }catch (Exception e){
            System.out.println("unable to select the value " + e);
        }

    }

    //method to enter user input on send keys
    public static void userKeys(WebDriver driver,String locator, String userInput, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try{
            System.out.println("Entering a value "+ userInput +" on element " + elementName);
            Reporter.log("Entering a value on element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            element.click();
            element.clear();
            element.sendKeys(userInput);
        } catch (Exception e) {
            System.out.println("Unable to enter element " + elementName + " " + e);
            Reporter.log("Entering a value on element " + elementName);
        }
    }//end of sendkeys method

    //method to click on an element
    public static void click(WebDriver driver,String locator,String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);

        try{
            System.out.println("Clicking a value on element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            element.click();
        } catch (Exception e) {
            System.out.println("Unable to click element " + elementName + " " + e);
        }
    }//end of click method

    //method to submit on an element
    public static void submit(WebDriver driver,String locator,String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try{
            System.out.println("Submitting a value on element " + elementName);
            Reporter.log("Entering a value on element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            element.submit();
        } catch (Exception e) {
            System.out.println("Unable to submit element " + elementName + " " + e);
            Reporter.log("Entering a value on element " + elementName);
        }
    }//end of click method

    //method to return text from an element
    public static String captureText(WebDriver driver,String locator,String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        String result = null;
        try{
            System.out.println("Capturing a text from element " + elementName);
            Reporter.log("Entering a value on element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            result = element.getText();
            System.out.println("My Text result is " + result);
        } catch (Exception e) {
            System.out.println("Unable to capture text on element " + elementName + " " + e);
            Reporter.log("Entering a value on element " + elementName);
        }

        return result;
    }
    //MouseClick method
    public static void MouseClick(WebDriver driver, String locator, String ElementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        Actions mouse = new Actions(driver);
        try{
            System.out.println("Clicking a value on element " + ElementName);
            WebElement Element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            mouse.moveToElement(Element).click().perform();
        }catch (Exception e){
            System.out.println("unable to mouseclick on element" + e);
        }

    }//end of mouse method

    //mouse Hover method
    public static void MouseHover(WebDriver driver, String locator, String ElementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        Actions mouse = new Actions(driver);
        try
        {
            System.out.println("Hovering the mouse over " + ElementName);
            WebElement Element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            mouse.moveToElement(Element).perform();
        }catch (Exception e){
            System.out.println("unable to hover mouse" + e);
        }
    }

    //Click by Index Method
    public static void clickByIndex(WebDriver driver,String locator,int index, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try{
            System.out.println("Clicking a value by index " + index + " on element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(locator))).get(index);
            element.click();
        } catch (Exception e) {
            System.out.println("Unable to click by index " + index +  " on element " + elementName + " " + e);
        }
    }//end of click method

    //UserType and enter Method
    public static void userTypeAndHitEnter(WebDriver driver,String locator, String userInput, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try{
            System.out.println("Entering a value on element " + elementName);
            Reporter.log("Entering a value on element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            element.clear();
            element.sendKeys(userInput);
            element.sendKeys(Keys.ENTER);
        } catch (Exception e) {
            System.out.println("Unable to enter element " + elementName + " " + e);
            Reporter.log("Unable to enter element " + elementName + " " + e);
        }
    }//end of userTypeAndHitEnter method

}
