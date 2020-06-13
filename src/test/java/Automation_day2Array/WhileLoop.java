package Automation_day2Array;

public class WhileLoop
{
    public static void main(String[] args)
    {
        String[] states = new String[4];
        states [0] = "New york";
        states [1] = "California";
        states [2] = "ohio";
        states [3] = "Arizona";

        //While loop is more broken down into statements

        int i = 0;
        while (i <=3)
        {                                       //print all value for states
            System.out.println("My state is " + states[i]);
            i = i+1;//incrementation and you put this at the end of your statements
        }
    }
}
