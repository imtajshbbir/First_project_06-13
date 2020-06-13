package Automation_day3;

public class Multiple_condition
{
    public static void main(String[] args)
    {
        int a,b,c;
        a = 3;
        b = 4;
        c = 6;

        //write multiple if else condition

        if (a+b > c)
        {
            System.out.println("a and b is greater than c");
        }else if(a+b < c)
        {
            System.out.println("a and b is less than c");
        }else {
            System.out.println("a and b is equal to c");
        }

    }

}
