package Cognizant_DN.UpSkilling.Module_3_CoreJava.Exercise_38_Decompile_Class;

public class Calculator {

    public int add(int a, int b) {

        return a + b;
    }

    public static void main(String[] args) {

        Calculator calculator =
                new Calculator();

        int result =
                calculator.add(10, 20);

        System.out.println(
                "Result = " + result
        );
    }
}