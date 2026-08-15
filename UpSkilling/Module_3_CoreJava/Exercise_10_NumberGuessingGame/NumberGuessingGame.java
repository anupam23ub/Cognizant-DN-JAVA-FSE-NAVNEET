package Cognizant_DN.UpSkilling.Module_3_CoreJava.Exercise_10_NumberGuessingGame;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {

        Random random = new Random();
        Scanner sc = new Scanner(System.in);

        int secretNumber = random.nextInt(100) + 1;
        int guess;
        int attempts = 0;

        System.out.println("=== Number Guessing Game ===");
        System.out.println("I have selected a number between 1 and 100.");
        System.out.println("Try to guess it!");

        do {

            System.out.print("\nEnter your guess: ");
            guess = sc.nextInt();

            attempts++;

            if (guess > secretNumber) {
                System.out.println("Too High! Try again.");
            }
            else if (guess < secretNumber) {
                System.out.println("Too Low! Try again.");
            }
            else {
                System.out.println("Congratulations!");
                System.out.println("You guessed the number correctly.");
                System.out.println("Total attempts: " + attempts);
            }

        } while (guess != secretNumber);

        sc.close();
    }
}