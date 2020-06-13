package Automation_day3;

public class Loop_conditional_statements
{
    public static void main(String[] args)
    {
        String[] city  = new String[10];
        city [0] = "Brooklyn";
        city [1] = "Queens";
        city [2] = "Manhattan";
        city [3] = "Bronx";


        for (int i = 0; i < 5; i++){

           /*if(city[i] == city[0])
                //or another way to write it if (city[i].equal city[0])
            {
                System.out.println("My city is " + city[i]);
            }else if (city [i] == city [1]){
                System.out.println("My city is " + city[i]);
            }else if (city [i] == city[2]){
                System.out.println("My city is " + city [i]);
            }else{
                System.out.println("My city is " + city [i]);
            }*/

            if (city[i] == ("Brooklyn") || city [i] == ("Queens"))
            {
                System.out.println("My city is " + city[i]);
            }else if (city[i] == city[2] || city [i] == city [3])
            {
                System.out.println("My city is " + city [i]);
            }else{
                System.out.println("Your city is not listed");
            }
        }
    }
}
