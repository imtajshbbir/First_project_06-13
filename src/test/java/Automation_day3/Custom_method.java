package Automation_day3;

public class Custom_method {

    public static void main(String[] args) {
        voidAdd(100, 200);

        int result = returned(200, 300);
        System.out.println("New result is " + (result - 25));
        System.out.println("One extra result is " + (result * 2));
        voidAdd(200, 300);
        extra(5, 10);
        total();



    }

    public static void total ()
    {
        double [] citySize = new double [5];
        citySize[0] = 2345;
        citySize[1] = 4567;
        citySize[2] = 5768;

        double[] townSize = new double[5];
        townSize[0]= 6788;
        townSize[1]= 7890;
        townSize[2]= 2356;

        String[] town = new String[10];
        town[0] = "Brooklyn";
        town[1] = "Queens";
        town[2] = "Manhattan";
        town[3] = "Bronx";


        for (int i = 0; i <= 5; i++) {
            //if ((town[i] == "Brooklyn") || (town[i] == "Queens"))

                double stateSize = stateSize(citySize[i], townSize[i]);;
                System.out.println("My city is " + town[i] + " & City size is " + stateSize);

            //else ;
        }

    }

    public static void voidAdd(int a, int b) {
        int result = a + b;
        {
            System.out.println("My addition result is " + result);
        }
    }

    public static void extra(int a, int b) {
        int extra = a * b;
        {
            System.out.println("the second extra score is " + extra);
        }
    }



    public static double stateSize(double citySize, double townSize)

    {
        //System.out.println("The state size is " + (citySize + townSize));
        return citySize + townSize;

    }





    public static int returned(int a, int b)
    {
        int c = a + b;
        {
            System.out.println("My addition result is " + c);
        }
        return c;
    }


    /*public String County()
    {
        String[] town = new String[10];

        for (int i = 0; i <= 5; i++) {
            if ((town[i] == "Brooklyn") || (town[i] == "Queens")) {
                System.out.println("My city is " + town[i]);
            } else ;*/
}










