package Cognizant_DN.UpSkilling.Module_3_CoreJava.Exercise_08_OperatorPrecedence;

public class OperatorPrecedence {

    public static void main(String[] args) {

        int result1 = 10 + 5 * 2;
        int result2 = (10 + 5) * 2;
        int result3 = 20 - 4 / 2;
        int result4 = (20 - 4) / 2;

        System.out.println("Expression: 10 + 5 * 2");
        System.out.println("Result = " + result1);
        System.out.println("Explanation: Multiplication (*) is performed first.");
        System.out.println("5 * 2 = 10, then 10 + 10 = 20\n");

        System.out.println("Expression: (10 + 5) * 2");
        System.out.println("Result = " + result2);
        System.out.println("Explanation: Parentheses are evaluated first.");
        System.out.println("(10 + 5) = 15, then 15 * 2 = 30\n");

        System.out.println("Expression: 20 - 4 / 2");
        System.out.println("Result = " + result3);
        System.out.println("Explanation: Division (/) is performed first.");
        System.out.println("4 / 2 = 2, then 20 - 2 = 18\n");

        System.out.println("Expression: (20 - 4) / 2");
        System.out.println("Result = " + result4);
        System.out.println("Explanation: Parentheses are evaluated first.");
        System.out.println("(20 - 4) = 16, then 16 / 2 = 8");
    }
}