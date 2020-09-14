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

    private static int MIN_BOUND = 1;
    private static int MAX_BOUND = 100;
    private static int MAX_GUESSES = 10;

    public static void main(String[] args) {
        System.out.println("GUESS MY NUMBER!");
        System.out.printf("I've selected a number between %d to %d.%n", MIN_BOUND, MAX_BOUND);
        System.out.println("I'll tell you if it is too high or too low for each guess.");
        System.out.printf("See if you can guess it in %d rounds or fewer!%n%n", MAX_GUESSES);

        Scanner scan = new Scanner(System.in);
        int guess;
        while (true) {
            System.out.print(">>> Guess a number: ");
            guess = scan.nextInt();
        }
    }
}
