/*
 * Assignment 02
 * Description: [Part 1 of 2] Driving exam evaluator
 * Name: Kullathon "Mos" Sitthisarnwattanachai
 * ID: 921425216
 * Class: CSC 210-03
 * Semester: Fall 2020
 */

import java.util.Scanner;

public class DrivingExamEvaluator {

    /* Parameters for the exam evaluator */
    static final String DEFAULT_ID = "999999999";
    static final int ID_MAX_LENGTH = 9;
    static final int MIN_SCORE = 0;
    static final int MAX_SCORE = 500;

    /* Score weights and passing percentage. */
    static final double WRITTEN_SCORE_WEIGHT = 74;
    static final double PRACTICAL_SCORE_WEIGHT = 26;
    static final double PASS_PERCENTAGE = 52;

    public static void main(String[] args) {
        loop();
    }

    /**
     * Validate the given student ID.
     * Prints a message if the given ID is invalid and returns the fallback ID.
     *
     * <i>Note: Only checks the length of the ID. Does not check if it is a
     * valid numerical ID.</i>
     *
     * @param id The ID to validate.
     * @return A valid ID.
     */
    private static String validateID(String id) {
        /* Return the DEFAULT_ID and notify the user. */
        if (id.length() > ID_MAX_LENGTH) {
            System.out.printf("Invalid ID. Defaulting to: %s.%n", DEFAULT_ID);
            return DEFAULT_ID;
        }
        return id;
    }

    /**
     * Validate the given score.
     * Prints a message of the given score is invalid and returns a score
     * that is within the valid range.
     *
     * @param score The score to validate.
     * @return A valid score.
     */
    private static double validateScore(double score) {
        /* Override scores with their defaults if they are out of bounds. */
        if (score > MAX_SCORE) score = MAX_SCORE;
        else if (score < MIN_SCORE) score = MIN_SCORE;
        /* Skip the print and return the original score if it is valid. */
        else return score;

        System.out.printf("Invalid score. Defaulting to: %.0f.%n", score);
        return score;
    }

    /**
     * Calculate the user's score and determine their results.
     *
     * @param writtenScore The (validated) written score.
     * @param practicalScore The (validated) practical score.
     */
    private static void calculateScore(double writtenScore, double practicalScore) {
        /* Calculate the weighted scores and its total. */
        double weightedWritten = WRITTEN_SCORE_WEIGHT * (writtenScore / MAX_SCORE);
        double weightedPractical = PRACTICAL_SCORE_WEIGHT * (practicalScore / MAX_SCORE);
        double totalWeighted = weightedWritten + weightedPractical;

        /* Display score summary. */
        String scoreMessage = "%nYour %s exam, weighted %.0f%% of your total score, is: %.2f%%";
        System.out.printf(scoreMessage, "written", WRITTEN_SCORE_WEIGHT, weightedWritten);
        System.out.printf(scoreMessage, "practical", PRACTICAL_SCORE_WEIGHT, weightedPractical);
        System.out.printf("%nYour total score is: %.2f%%%n", totalWeighted);

        /* Print pass/fail message. */
        if (totalWeighted >= PASS_PERCENTAGE) System.out.print("Congratulations, you passed!");
        else System.out.print("Unfortunately, you failed!");

        /* Print passing requirement, regardless of condition. */
        System.out.printf(" A passing grade requires you to score %.0f%% or above.%n", PASS_PERCENTAGE);
    }

    /**
     * Display the user's exam results.
     * Shows the user the scores for each tests, their weighted average, and the result.
     *
     * @param studentID The (validated) student ID.
     * @param writtenScore The (validated) written score.
     * @param practicalScore The (validated) practical score.
     */
    private static void displayResults(String studentID, double writtenScore, double practicalScore) {
        System.out.println("=========================================");
        System.out.printf("STUDENT ID: %s%n", studentID);
        System.out.println("Congratulations on finishing your test!");
        System.out.println("-----------------------------------------");
        System.out.printf("Your final scores: WRITTEN: %.2f, PRACTICAL: %.2f", writtenScore, practicalScore);
        calculateScore(writtenScore, practicalScore);
    }

    /**
     * Run the execution loop.
     */
    public static void loop() {
        /* Create a Scanner object. */
        Scanner scan = new Scanner(System.in);

        /*
         Print prompts, scan the input, and send them to
         their respective validation methods.
        */
        System.out.print("Enter your student ID: ");
        String studentID = validateID(scan.nextLine());
        System.out.print("Enter your written exam score: ");
        double writtenScore = validateScore(scan.nextDouble());
        System.out.print("Enter your practical exam score: ");
        double practicalScore = validateScore(scan.nextDouble());

        /* Send the validated ID and scores to be calculated and displayed. */
        displayResults(studentID, writtenScore, practicalScore);
    }
}
