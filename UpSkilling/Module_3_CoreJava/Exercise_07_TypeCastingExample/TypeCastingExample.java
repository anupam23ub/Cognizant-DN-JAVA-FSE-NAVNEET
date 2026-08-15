package Cognizant_DN.UpSkilling.Module_3_CoreJava.Exercise_07_TypeCastingExample;

public class TypeCastingExample {

    public static void main(String[] args) {

        // Double to int (Narrowing)
        double doubleValue = 25.89;
        int intValue = (int) doubleValue;

        System.out.println("Original Double Value : " + doubleValue);
        System.out.println("After Casting to int  : " + intValue);

        System.out.println();

        // int to double (Widening)
        int number = 100;
        double convertedDouble = (double) number;

        System.out.println("Original int Value    : " + number);
        System.out.println("After Casting to double: " + convertedDouble);
    }
}