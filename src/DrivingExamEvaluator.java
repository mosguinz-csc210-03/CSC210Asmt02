/*
 * Assignment 02
 * Description: Driving exam evaluator
 * Name: Kullathon "Mos" Sitthisarnwattanachai
 * ID: 921425216
 * Class: CSC 210-03
 * Semester: Fall 2020
 */

import java.util.Scanner;

public class DrivingExamEvaluator {

    static final int ID_MAX_LENGTH = 9;
    static final String DEFAULT_ID = "999999999";
    static final int MIN_SCORE = 0;
    static final int MAX_SCORE = 500;
    static final double WRITTEN_SCORE_WEIGHT = 0.74;
    static final double PRACTICAL_SCORE_WEIGHT = 0.26;
    static final double PASS_PERCENTAGE = 0.52;

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
        if (id.length() > ID_MAX_LENGTH) {
            System.out.printf("%nInvalid ID. Defaulting to: %s.", DEFAULT_ID);
            return DEFAULT_ID;
        }
        return id;
    }

    public static void loop() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter your student ID: ");
        String id = validateID(scan.nextLine());
    }
}
