package Cognizant_DN.UpSkilling.Module_3_CoreJava.Exercise_12_MethodOverloading;

public class MethodOverloadingDemo {

    // Method 1: Two integers
    public static int add(int a, int b) {
        return a + b;
    }

    // Method 2: Two doubles
    public static double add(double a, double b) {
        return a + b;
    }

    // Method 3: Three integers
    public static int add(int a, int b, int c) {
        return a + b + c;
    }

    public static void main(String[] args) {

        System.out.println("Sum of two integers: " + add(10, 20));

        System.out.println("Sum of two doubles: " + add(10.5, 20.5));

        System.out.println("Sum of three integers: " + add(10, 20, 30));
    }
}