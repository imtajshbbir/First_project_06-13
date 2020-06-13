package Automation_day2Array;

public class DynamicArray
{
    public static void main(String[] args)
    {
        //declare string dynamic array variables
        String[] locations, countries;
        //declare integer dynamic array variables
        int [] number, houseAddress;

        //declare the dynamic array with the length(size) of that variable
        countries = new String[10];
        countries[0] = "USA";
        countries[1] = "Canada";
        countries[2] = "Russia";
        countries[3] = "Bangladesh";
        countries[4] = "England";
        countries[5] = "Australia";

        houseAddress = new int[6];
        houseAddress[0] = 234556677;
        houseAddress[1] = 25353567;
        houseAddress[2] = 367;


        System.out.println("I am a citizen of " + countries[3] + " & " + countries[0]);

        //define the int dynamic array
        number  = new int [5];
        number[0] = 1;
        number[1] = 2;

    }
}
