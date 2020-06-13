package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;

public class MetLife_automation//Class start from here
{   //main  method where loops and variables are stored.
    public static void main(String[] args) throws InterruptedException {
        //locate where the source of chromedriver and connect with the selenium web driver.
        System.setProperty("webdriver.chrome.driver","src//Resource//chromedriver1.exe");
        ChromeOptions options = new ChromeOptions();//define chrome options
        options.addArguments("start-maximized","incognito");//adding arguments in ChromeOptions
        WebDriver driver = new ChromeDriver(options);//define the webdriver.


        ArrayList<String> Zipcode = new ArrayList<>();//declare arraylist for zipCode
        Zipcode.add("11230");
        Zipcode.add("11226");
        Zipcode.add("11241");

        ArrayList<String> dentalProgram = new ArrayList<>();//declare arraylist for dentalProgram
        dentalProgram.add("PPO-LOW");
        dentalProgram.add("PPO-MEDIUM");
        dentalProgram.add("PPO-HIGH");

        ArrayList<String> referralCode = new ArrayList<>();//declare arrayList for referralcode
        referralCode.add("3256");
        referralCode.add("8974");
        referralCode.add("9420");


        driver.navigate().to("https://www.metlife.com/");//navigate to MetLife.com
        Thread.sleep(3000);//system will wait 3 sec before move on to next step

        Actions mouse = new Actions(driver);//define the actions
        String MetLife_title = driver.getTitle();//getting the title from website and declaring as string variable

        if (MetLife_title.equals("Insurance and Employee Benefits | MetLife")){//matching the WebTitle with actual title
            System.out.println("Page title is " + MetLife_title);//printing the matched title
        } else{
            System.out.println("The page title doesn`t match");//print statment if the title doesn`t match
        }
        Thread.sleep(3000);

        try{            //using try catch to find error. if the code have missing attributes
            WebElement solutions = driver.findElement(By.xpath("//*[contains(text(),'SOLUTIONS')]"));//declaring the solution tab as WebElement
            mouse.moveToElement(solutions).perform();//mouse hover over the solution tabs
        } catch (Exception e){
            System.out.println("Unable to click hover on solution" + e);//printing the alert if there is any issues inside try
        }
        Thread.sleep(3000);

        try{
            driver.findElement(By.xpath("//*[contains(text(),'MetLife TakeAlong Dental')]")).click();
            //clicking the MetLife takealong dental option
        }catch (Exception e){
            System.out.println("Unable to click on Take along dental "+ e);
        }
        Thread.sleep(3000);

        String takeAlongDental = driver.getTitle();//capturing title from takeAlongDental page
        if (takeAlongDental.equals("MetLife TakeAlong Dental | MetLife")){
            System.out.println("The dental title is " + takeAlongDental);
        }else{
            System.out.println("The dental title does not match");
        }
        Thread.sleep(3000);


        for (int i =0; i<Zipcode.size(); i++) {//starting for loop

            try{
                driver.findElement(By.xpath("//*[contains(text(),'Enroll Now')]")).click();//clicking Enroll now button
            }catch (Exception e){
                System.out.println("The enroll button is not clicking" + e);
            }
            Thread.sleep(2000);

            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());//declaring array list for handling tabs
            driver.switchTo().window(tabs.get(1));//switching the tabs to second tab
            Thread.sleep(2000);

            try {
                WebElement FindZipcode = driver.findElement(By.xpath("//*[@id='txtZipCode']"));//declaring WebElement
                FindZipcode.clear();
                FindZipcode.sendKeys(Zipcode.get(i));
                driver.findElement(By.xpath("//*[@id = 'txtZipCodetxt']")).click();//clicking on go button
            } catch (Exception e) {
                System.out.println("unable to work with zipcode " + e);
            }
            Thread.sleep(3000);

            try{
                driver.findElement(By.xpath("//*[@class = '" + dentalProgram.get(i) + "']")).click();
            } catch (Exception e){
                System.out.println("First dental program is not selecting "+ e);
            }
            Thread.sleep(3000);

            try{
                driver.findElement(By.xpath("//*[@id ='topenrolltab']")).click();//clicking on dental program option
            }catch (Exception e){
                System.out.println("unable to click on Enroll in program now " + e);
            }
            Thread.sleep(3000);

            try{
                driver.findElement(By.xpath("//*[@id = 'txtBxPromocode']")).sendKeys(referralCode.get(i));//sending array value to the promotion code
            }catch (Exception e){
                System.out.println("unable to input the referral" + e);
            }
            Thread.sleep(3000);

            try{
                driver.findElement(By.xpath("//*[@name='btnEnroll']")).click();//clicking on the enroll without code button
            }catch (Exception e){
                System.out.println("unable to click the go button" + e );
            }
            Thread.sleep(3000);

            try{
                String errormsg = driver.findElement(By.xpath("//*[@id ='lblRefCodeError']")).getText();//printing the error message
                System.out.println(errormsg);
            }catch (Exception e){
                System.out.println("unable to print the error message " + e);
            }
            Thread.sleep(2000);

            try{
                driver.findElement(By.xpath("//*[@id='withoutrefcode']")).click();
            }catch(Exception e){
                System.out.println("Unable to click on Enroll without Referral code "+ e);
            }
            Thread.sleep(4000);

            try{
            String capture = driver.findElement(By.xpath("//*[@class='col-sm-8']")).getText();//matching the capture text with array text
            if (capture.contains(dentalProgram.get(i))){
                System.out.println("The result matches");
            }else{
                System.out.println("The result did not match " + capture);
            }
            }catch (Exception e){
                System.out.println("Unable to match" + e);
            }

            driver.close();//closing the tab/current page
            driver.switchTo().window(tabs.get(0));//switching back to first page
            Thread.sleep(3000);

        }

        driver.quit();//Quit the page
    }
}
