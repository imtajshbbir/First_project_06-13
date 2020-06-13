package MetLife_page_object;

import CustomReuseable.Abstract_Class;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MetLife_BaseClass extends Abstract_Class {

    public MetLife_BaseClass(WebDriver driver){
        super();
        PageFactory.initElements(driver,this);
    }

    public static MetLife_homePage metLife_homePage(){

        MetLife_homePage metLife_homePage = new MetLife_homePage(driver);
        return metLife_homePage;

    }

    public static MetLife_Enroll_Now metLife_enroll_now(){

        MetLife_Enroll_Now metLife_enroll_now = new MetLife_Enroll_Now(driver);
        return metLife_enroll_now;
    }

    public static MetLife_zipcode metLife_zipcode(){

        MetLife_zipcode metLife_zipcode = new MetLife_zipcode(driver);
        return metLife_zipcode;

    }
    public static MetLife_Programs metLife_programs(){

        MetLife_Programs metLife_programs = new MetLife_Programs(driver);
        return metLife_programs;
    }

    public static MetLife_PageHandels metLife_pageHandels(){

        MetLife_PageHandels metLife_pageHandels = new MetLife_PageHandels(driver);
        return metLife_pageHandels;

    }

}
