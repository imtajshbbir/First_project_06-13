package Automation_day3;

public class If_else_with_operators
{
    public static void main(String[] args)
    {


        int grade = 100;

        if(grade >= 90)
        {
            System.out.println("Students grade is A");
        } else if (grade >=80 && grade <90){
            System.out.println("Students grade is B");
        } else if (grade >=70 && grade <80){
            System.out.println("Student grade is C");
        }else {
            System.out.println("Students grade is F");
        }

    }
}
