package our.best.university;

import our.best.university.logic.Core;

public class Starter {

    public static void main(String[] args) {
        String greeting = "Hello! Its \"University\" application\n" +
                "Now we have three department in our database: Gryffindor, Slytherin and Ravenclaw\n" +
                "You may type next command:\n\n" +

                "1)Who is head of department {department_name}\n" +
                "2)Show {department_name} statistic\n" +
                "3)Show the average salary for department {department_name}\n" +
                "4)Show count of employee for {department_name}\n" +
                "5)Global search by {template}\n" +
                "6)END - to ending this program";

        System.out.println(greeting);
        Core core = new Core();
        core.start();

    }
}
