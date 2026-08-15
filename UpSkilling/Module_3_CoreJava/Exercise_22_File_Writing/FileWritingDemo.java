package Cognizant_DN.UpSkilling.Module_3_CoreJava.Exercise_22_File_Writing;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileWritingDemo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        try {

            FileWriter writer = new FileWriter("output.txt");

            writer.write(text);

            writer.close();

            System.out.println("Data successfully written to output.txt");

        } catch (IOException e) {

            System.out.println("Error writing to file: "
                    + e.getMessage());
        }

        sc.close();
    }
}