package Automation_day4;

public class split_command
{

    public static void main(String[] args)
    {
        String message ="Welcome to_selenium automation class";

        String[] arrayResult = message.split(" ");
        //System.out.println("My final message is " + arrayResult[2]);

        String[] array2 = arrayResult[1].split("_");
        System.out.println("My second massage is " + array2[1]);

        //String[] array3 = arrayResult[1].split(",");
        //System.out.println("My third massage is " + array3[2]);



    }
}
