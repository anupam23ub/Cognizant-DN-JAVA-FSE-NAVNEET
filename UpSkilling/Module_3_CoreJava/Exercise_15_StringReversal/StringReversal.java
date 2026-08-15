package Cognizant_DN.UpSkilling.Module_3_CoreJava.Exercise_15_StringReversal;

import java.util.Scanner;

public class StringReversal {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        String reversed = new StringBuilder(input).reverse().toString();

        System.out.println("Reversed String: " + reversed);

        sc.close();
    }
}