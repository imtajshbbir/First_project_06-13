package Automation_day2Array;

public class LinearArray {

    public static void main(String[] args)
    {
                //declare the array variable

        String[] locations, countries, places;
        //declare the empty int array variable first
        int [] number, homeAddress;

        //define the variable
        locations = new String[]{"Sixflag", "Disney", "Beach"};
        countries = new String[]{"Bangladesh", "USA", "Canada", "England"};

        //define the int array variables
        number = new int[]{1,2,3,4};
        homeAddress = new int[]{222,333,444,555,666,777};
        places = new String[5];
        places[0] = "a";
        places[1] = "b";
        places[3] = "e";



        //print the last value from locations variable
        System.out.println("My location is " + locations[1] + " Located in " + countries[2]);
        System.out.println("My house address is " + homeAddress[2] + " Block number " + number[1]);
        for (int i =0; i<places.length; i++)
        if (places[i] == ("a") || places[i] == ("e")){

        }


    }

}
