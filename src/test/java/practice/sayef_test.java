package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class sayef_test {


    public static class MetLab_Insurance {

        public static void main(String[] args) throws InterruptedException {


            System.setProperty("webdriver.chrome.driver", "src//Resource//chromedriver1.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized", "incognito");
            WebDriver driver = new ChromeDriver(options);


            ArrayList<String> zipcodes = new ArrayList<>();

            zipcodes.add("11219");
            zipcodes.add("11218");
            zipcodes.add("11230");

            ArrayList<String> dentalPrograms = new ArrayList<>();
            dentalPrograms.add("PPO-LOW");
            dentalPrograms.add("PPO-MEDIUM");
            dentalPrograms.add("PPO-HIGH");

            ArrayList<String> referralCode = new ArrayList<>();
            referralCode.add("");
            referralCode.add("");
            referralCode.add("");


            driver.navigate().to("https://www.metlife.com");
            Thread.sleep(2000);

            String Actualtitle = driver.getTitle();
            if (Actualtitle.equals("Insurance & Employee Benefit | Metlife")) {

                System.out.println("Main Title matches with the given title ");

            } else {
                System.out.println("Main Title doesn't match with given title");
            }

            try {


                driver.findElement(By.xpath("//*[contains(text(),'SOLUTIONS')]")).click();

            } catch (Exception e) {

                System.out.println("Unable to click on the Solutions tab ");

            }
            Thread.sleep(2000);
            try {

                driver.findElement(By.xpath("//*[contains(text(),'MetLife TakeAlong Dental')]")).click();
            } catch (Exception e) {

                System.out.println("Unable to Click on MetLife TakeAlong Dental" + e);

            }
            Thread.sleep(2000);

            String PageTitle = driver.getTitle();
            if (PageTitle.equals("MetLife TakeAlong Dental | MetLife")) {

                System.out.println("Title of this pages matches with the expected ");

            } else {

                System.out.println("Title of this page doesn't match with the expected ");

            }


            Thread.sleep(2000);


            for (int i = 0; i < zipcodes.size(); i++) {

                try {

                    driver.findElement(By.xpath("//*[contains(text(),'Enroll Now')]")).click();
                } catch (Exception e) {

                    System.out.println("Unable to click on Enroll button" + e);
                }

                Thread.sleep(2000);

                ArrayList<String> Tabs = new ArrayList<>(driver.getWindowHandles());
                driver.switchTo().window(Tabs.get(1));

                try {
                    driver.findElement(By.xpath("//*[@id='txtZipCode']")).clear();
                    driver.findElement(By.xpath("//*[@id='txtZipCode']")).sendKeys(zipcodes.get(i));
                } catch (Exception e) {

                    System.out.println("Unable to enter zipcodes" + e);
                }
                Thread.sleep(2000);

                try {


                    driver.findElement(By.xpath("//*[@id='txtZipCodetxt']")).click();
                } catch (Exception e) {

                    System.out.println("Unable to click on go button");

                }
                Thread.sleep(2000);

    /*ArrayList<String> dentalProgrames = new ArrayList<>();
    dentalProgrames.add("PPO-LOW");
    dentalProgrames.add("PPO-MEDIUM");
    dentalProgrames.add("PPO-HIGH");*/

                try {

                    driver.findElement(By.xpath("//*[@class='" + dentalPrograms.get(i) + "']")).click();

                } catch (Exception e) {

                    System.out.println("Unable to choose programes " + e);

                }
                Thread.sleep(2000);
                try {


                    driver.findElement(By.xpath("//*[@id='topenrolltab']")).click();

                } catch (Exception e) {

                    System.out.println("Unable to click on enroll " + e);
                }

                Thread.sleep(2000);


    /*ArrayList<String> referralCode = new ArrayList<>();
    referralCode.add("775");
    referralCode.add("770");
    referralCode.add("800");*/

                driver.findElement(By.xpath("//*[@id='txtBxPromocode']")).sendKeys(referralCode.get(i));

                Thread.sleep(2000);
                try {


                    driver.findElement(By.xpath("//*[@name='btnEnroll']")).click();
                } catch (Exception e) {

                    System.out.println("Unable to click " + e);

                }
                Thread.sleep(2000);

                String error = driver.findElement(By.xpath("//*[@id='lblRefCodeError']")).getText();
                System.out.println(error);
                Thread.sleep(2000);


                try {

                    driver.findElement(By.xpath("//*[@id='withoutrefcode']")).click();

                } catch (Exception e) {
                    System.out.println("Unable to go to without referal code page " + e);
                }
                Thread.sleep(2000);

                if (i == 0) {

                    String captureText = driver.findElement(By.xpath("//*[contains(text(),'PPO-LOW')]")).getText();
                    System.out.println(captureText + " Matches with " + dentalPrograms.get(i));
                }

                if (i == 1) {

                    String captureText = driver.findElement(By.xpath("//*[contains(text(),'PPO-MEDIUM')]")).getText();

                    System.out.println(captureText + " Matches with " + dentalPrograms.get(i));
                }
                if (i == 2) {

                    String captureText = driver.findElement(By.xpath("//*[contains(text(),'PPO-HIGH')]")).getText();
                    System.out.println(captureText + " Matches with " + dentalPrograms.get(i));
                }


//                ArrayList<String> Tabs = new ArrayList<>(driver.getWindowHandles());
//                driver.switchTo().window(Tabs.get(1));

                driver.close();
                driver.switchTo().window(Tabs.get(0));
                Thread.sleep(3000);


                // System.out.println(captureText + " Matches with " + dentalProgrames.get(0));

            }//// for loop ends

            driver.quit();
        }//main method ends

    }//main class

}
