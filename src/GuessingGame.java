/*
 * Assignment 02
 * Description: [Part 2 of 2] Guessing game
 * Name: Kullathon "Mos" Sitthisarnwattanachai
 * Teammate: Amber Hartigan
 * ID: 921425216
 * Class: CSC 210-03
 * Semester: Fall 2020
 */

import java.util.Scanner;
import java.util.Random;

public class GuessingGame {

    /* Parameters for the game. The bounds are inclusive. */
    private static final int MIN_BOUND = 1;
    private static final int MAX_BOUND = 100;
    private static final int MAX_GUESSES = 10;

    public static void main(String[] args) {
        loop();
    }

    /**
     * Print the welcome message for the game.
     */
    private static void printHeader() {
        System.out.println("GUESS MY NUMBER!");
        System.out.printf("I've selected a number between %d to %d inclusive.%n", MIN_BOUND, MAX_BOUND);
        System.out.println("I'll tell you if it is too high or too low for each guess.");
        System.out.printf("See if you can guess it in %d rounds or fewer!%n", MAX_GUESSES);
    }

    /**
     * Run the game's execution loop.
     * Much of the method is self-explanatory, but comments have been added to further
     * explain its purpose (and to comply with part (3)(b) of the assessment).
     */
    private static void loop() {
        /* To keep track of the number of guesses. */
        int totalGuesses = 0;

        /* Generate the target number, inclusive of the bounds. */
        int targetNumber = new Random().nextInt(MAX_BOUND - MIN_BOUND + 1) + MIN_BOUND;

        /* To check how far off the user's guess is from the `targetNumber`. */
        int delta;

        /* Create a Scanner object. */
        Scanner scan = new Scanner(System.in);

        printHeader();

        while (true) {
            /* Increment the number of guesses by one. */
            totalGuesses++;

            /* Scan the user's input and calculate the delta value (difference). */
            System.out.printf(">>> Guess #%d: ", totalGuesses);
            delta = targetNumber - scan.nextInt();

            /* Print the hint messages according to how far the user's guess is. */
            if (delta > 0) {
                /* If the difference is positive, then the guess is too low. */
                System.out.println("[x] Too low!");
            } else if (delta < 0) {
                /* If the difference is negative, then the guess is too high. */
                System.out.println("[x] Too high!");
            } else {
                /* If the difference is zero, then the user has guessed correctly; break. */
                System.out.print("Awesome, you won!");
                break;
            }

            /*
             If the user has reached the guess limit and didn't break from else clause
             above, then they've lost.
            */
            if (totalGuesses == MAX_GUESSES) {
                System.out.print("Game over!");
                break;
            }
        }

        /* Reveal the answer for either cases. */
        System.out.printf(" The number was %d.%n", targetNumber);
    }
}
