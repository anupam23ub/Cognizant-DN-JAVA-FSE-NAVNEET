package Cognizant_DN.UpSkilling.Module_3_CoreJava.Exercise_23_File_Reading;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReadingDemo {

    public static void main(String[] args) {

        try {

            File file = new File("output.txt");

            Scanner fileReader = new Scanner(file);

            System.out.println("Contents of output.txt:");

            while (fileReader.hasNextLine()) {

                String line = fileReader.nextLine();

                System.out.println(line);
            }

            fileReader.close();

        } catch (FileNotFoundException e) {

            System.out.println("File not found: "
                    + e.getMessage());
        }
    }
}