package Automation_day3;

public class method_exicution {
    public static void main(String[] args) {
        Custom_method.voidAdd(100, 200);

        int result = Custom_method.returned(200, 200);
        System.out.println("New result is " + (result - 25));
    }
}
