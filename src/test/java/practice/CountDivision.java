package practice;

import CustomReuseable.Abstract_Class;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class CountDivision extends Abstract_Class {

    @Test
    public void CountDivision(){

        int i;
        for(i = 1; i<=100; i++){
            if ((i %5) ==0){
                continue;
            }else{
                System.out.println("The numbers are "+ i);
                logger.log(LogStatus.INFO,"The numbers are "+ i);
            }
        }

    }
}
