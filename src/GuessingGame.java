/*
 * Assignment 02
 * Description: [Part 2 of 2] Guessing game
 * Name: Kullathon "Mos" Sitthisarnwattanachai
 * ID: 921425216
 * Class: CSC 210-03
 * Semester: Fall 2020
 */

import java.util.Scanner;
import java.util.Random;

public class GuessingGame {

    private static final int MIN_BOUND = 1;
    private static final int MAX_BOUND = 100;
    private static final int MAX_GUESSES = 10;

    public static void main(String[] args) {
        loop();
    }

    private static void printHeader() {
        System.out.println("GUESS MY NUMBER!");
        System.out.printf("I've selected a number between %d to %d inclusive.%n", MIN_BOUND, MAX_BOUND);
        System.out.println("I'll tell you if it is too high or too low for each guess.");
        System.out.printf("See if you can guess it in %d rounds or fewer!%n", MAX_GUESSES);
    }

    private static void loop() {
        int totalGuesses = 0;
        int delta;
        int targetNumber = new Random().nextInt(MAX_BOUND - MIN_BOUND + 1) + MIN_BOUND;
        Scanner scan = new Scanner(System.in);

        printHeader();

        while (true) {
            totalGuesses++;
            System.out.printf(">>> Guess #%d: ", totalGuesses);
            delta = targetNumber - scan.nextInt();

            if (delta > 0) {
                System.out.println("[x] Too low!");
            } else if (delta < 0) {
                System.out.println("[x] Too high!");
            } else {
                System.out.print("Awesome, you won!");
                break;
            }

            if (totalGuesses == MAX_GUESSES) {
                System.out.print("Game over!");
                break;
            }
        }

        System.out.printf(" The number was %d.%n", targetNumber);
    }
}
