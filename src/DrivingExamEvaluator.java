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

    final String DEFAULT_ID = "999999999";
    final int MIN_SCORE = 0;
    final int MAX_SCORE = 500;
    final double WRITTEN_SCORE_WEIGHT = 0.74;
    final double PRACTICAL_SCORE_WEIGHT = 0.26;
    final double PASS_PERCENTAGE = 0.52;

    public static void main(String[] args) {
        loop();
    }

    public static void loop() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter your student ID: ");
        scan.nextLine();
    }
}
