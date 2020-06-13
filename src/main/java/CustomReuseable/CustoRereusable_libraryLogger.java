package CustomReuseable;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;

public class CustoRereusable_libraryLogger
{
    static int timeout = 20;

    //method to re use chrome driver and chrome options
    public static WebDriver setDriver() throws IOException, InterruptedException {
        //way to kill the driver instead of using driver.quit
        Runtime.getRuntime().exec("taskkill /F /IM chromedriver83.exe /T");
        Thread.sleep(2000);
        //set the chrome path
        System.setProperty("webdriver.chrome.driver", "src//main//resources//chromedriver83.exe");
        //set some pre conditions using ChromeOptions
        Thread.sleep(2000);
        ChromeOptions options = new ChromeOptions();
        //set the arguments you want for the driver
        options.addArguments("start-maximized","incognito");
        //now simply define your chrome driver
        WebDriver driver = new ChromeDriver(options);
        return driver;
    }


    public  static  void Title(WebDriver driver, String expectedTitle, ExtentTest logger){
        String pageTitle = driver.getTitle();
        if (pageTitle.equals(expectedTitle)){
            System.out.println("Expected title matches with the actual " + expectedTitle);
            logger.log(LogStatus.INFO,"Expected title matches with the actual " + expectedTitle);
        }else {
            System.out.println("The title doesn`t match" + pageTitle);
            logger.log(LogStatus.FAIL,"The title doesn`t match" + pageTitle);
            getScreenShot(driver, logger,pageTitle);
        }


    }
    public static void dropdownText(WebDriver driver,String locator, String userValue, String elementName, ExtentTest logger){

        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try{
            System.out.println("Selecting a value on element " + elementName);
            logger.log(LogStatus.INFO,"Selecting a value on element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            Select dDown = new Select(element);
            dDown.selectByVisibleText(userValue);
        }catch (Exception e){
            System.out.println("unable to select the value " + e);
            logger.log(LogStatus.FAIL,"unable to select the value " + e);
        }

    }

    //method to enter user input on send keys
    public static void userKeys(WebDriver driver,String locator, String userInput, String elementName, ExtentTest logger){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try{
            System.out.println("Entering a value "+ userInput +" on element " + elementName);
            Reporter.log("Entering a value on element " + elementName);
            logger.log(LogStatus.INFO,"Entering a value on element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            element.click();
            element.clear();
            element.sendKeys(userInput);
        } catch (Exception e) {
            System.out.println("Unable to enter element " + elementName + " " + e);
            Reporter.log("Entering a value on element " + elementName);
            logger.log(LogStatus.FAIL,"Unable to enter element " + elementName + " " + e);
            getScreenShot(driver,logger,elementName);
        }
    }//end of sendkeys method

    //method to click on an element
    public static void click(WebDriver driver, String locator, String elementName, ExtentTest logger){
        WebDriverWait wait = new WebDriverWait(driver,timeout);

        try{
            System.out.println("Clicking a value on element " + elementName);
            logger.log(LogStatus.INFO,"Clicking a value on element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            element.click();
        } catch (Exception e) {
            System.out.println("Unable to click element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to click element " + elementName + " " + e);
            getScreenShot(driver,logger,elementName);
        }
    }//end of click method

    //method to submit on an element
    public static void submit(WebDriver driver,String locator,String elementName, ExtentTest logger){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try{
            System.out.println("Submitting a value on element " + elementName);
            Reporter.log("Entering a value on element " + elementName);
            logger.log(LogStatus.INFO,"Submitting a value on element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            element.submit();
        } catch (Exception e) {
            System.out.println("Unable to submit element " + elementName + " " + e);
            Reporter.log("Entering a value on element " + elementName);
            logger.log(LogStatus.FAIL,"Unable to submit element " + elementName + " " + e);
            getScreenShot(driver,logger,elementName);
        }
    }//end of click method

    //method to return text from an element
    public static String captureText(WebDriver driver,String locator,String elementName, ExtentTest logger){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        String result = null;
        try{
            System.out.println("Capturing a text from element " + elementName);
            Reporter.log("Entering a value on element " + elementName);
            logger.log(LogStatus.INFO,"Capturing a text from element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            result = element.getText();
            System.out.println("My Text result is " + result);
        } catch (Exception e) {
            System.out.println("Unable to capture text on element " + elementName + " " + e);
            Reporter.log("Entering a value on element " + elementName);
            logger.log(LogStatus.FAIL,"Unable to capture text on element " + elementName + " " + e);
            getScreenShot(driver,logger,elementName);
        }

        return result;
    }
    //MouseClick method
    public static void MouseClick(WebDriver driver, String locator, String ElementName, ExtentTest logger){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        Actions mouse = new Actions(driver);
        try{
            System.out.println("Clicking a value on element " + ElementName);
            logger.log(LogStatus.INFO,"Clicking a value on element " + ElementName);
            WebElement Element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            mouse.moveToElement(Element).click().perform();
        }catch (Exception e){
            System.out.println("unable to mouseclick on element" + e);
            logger.log(LogStatus.FAIL,"unable to mouseclick on element" + e);
            getScreenShot(driver,logger,ElementName);
        }

    }//end of mouse method

    //mouse Hover method
    public static void MouseHover(WebDriver driver, String locator, String ElementName, ExtentTest logger){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        Actions mouse = new Actions(driver);
        try
        {
            System.out.println("Hovering the mouse over " + ElementName);
            logger.log(LogStatus.INFO,"Hovering the mouse over " + ElementName);
            WebElement Element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            mouse.moveToElement(Element).perform();
        }catch (Exception e){
            System.out.println("unable to hover mouse" + e);
            logger.log(LogStatus.FAIL,"unable to hover mouse" + e);
            getScreenShot(driver,logger,ElementName);
        }
    }

    //Click by Index Method
    public static void clickByIndex(WebDriver driver,String locator,int index, String elementName, ExtentTest logger){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try{
            System.out.println("Clicking a value by index " + index + " on element " + elementName);
            logger.log(LogStatus.INFO,"Clicking a value by index " + index + " on element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(locator))).get(index);
            element.click();
        } catch (Exception e) {
            System.out.println("Unable to click by index " + index +  " on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to click by index " + index + " on element " + elementName + " " + e);
            getScreenShot(driver,logger,elementName);
        }
    }//end of click method

    //UserType and enter Method
    public static void userTypeAndHitEnter(WebDriver driver,String locator, String userInput, String elementName,ExtentTest logger){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try{
            System.out.println("Entering a value on element " + elementName);
            Reporter.log("Entering a value on element " + elementName);
            logger.log(LogStatus.INFO,"Entering a value on element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            element.clear();
            element.sendKeys(userInput);
            element.sendKeys(Keys.ENTER);
        } catch (Exception e) {
            System.out.println("Unable to enter element " + elementName + " " + e);
            Reporter.log("Unable to enter element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to enter element " + elementName + " " + e);
            getScreenShot(driver, logger, elementName);
        }
    }//end of userTypeAndHitEnter method



    public static void getScreenShot(WebDriver wDriver,ExtentTest logger, String imageName) {
        try {
            String fileName = imageName + ".png";
            String directory = "src//main//java//html_report//Screenshots//";
            File sourceFile = ((TakesScreenshot) wDriver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(sourceFile, new File(directory + fileName));
            String image = logger.addScreenCapture("Screenshots//" + fileName);
            logger.log(LogStatus.FAIL, "", image);
        } catch (Exception e) {
            logger.log(LogStatus.FAIL, "Error Occured while taking SCREENSHOT!!!");
            e.printStackTrace();
        }
    }

}
