package practice;

import CustomReuseable.Abstract_Class;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class ListPrint extends Abstract_Class {

    @Test
    public void ListVowel(){

        String[] Letters = new String[5];
        Letters[0] = "a";
        Letters[1] = "b";
        Letters[2] = "c";
        Letters[3] = "d";
        Letters[4] = "e";



        for(int i = 0; i <Letters.length; i++){
            if (Letters[i]=="a" || Letters[i] == "e"){
                System.out.println("The Letter matches Vowel");
                logger.log(LogStatus.INFO,"The Letter matches Vowel");
            }else{
                System.out.println("The letter matches Non-Vowel");
                logger.log(LogStatus.INFO,"The letter matches Non-Vowel");
            }
        }

    }

}
