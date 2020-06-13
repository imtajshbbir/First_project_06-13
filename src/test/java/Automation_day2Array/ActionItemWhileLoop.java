package Automation_day2Array;

public class ActionItemWhileLoop
{
    public static void main(String[] args)
    {
        String[]zipCode = new String[10]; //declaring the zip code string variable
        zipCode[0] = "11230";
        zipCode[1] = "11226";
        zipCode[2] = "14213";
        zipCode[3] = "14068";
        zipCode[4] = "14215";

        String[]streetNumber = new String[10]; //declaring streetNumber strings variable
        streetNumber[0] = "2";
        streetNumber[1] = "4";
        streetNumber[2] = "9";
        streetNumber[3] = "5";
        streetNumber[4] = "12";

        int i = 0;
        while (i <= 5)
        {
            System.out.println("My zip code is " + zipCode[i] + " and my street number is " + streetNumber[i]);
            i++;
        }
    }
}
