package lab01;
public class Lab01_Q1{

    public static void main(String[] args) {
        
        // Constants
        final double LABS_GRADE_PERCENT = 15;  // grading policy
        final int LABS_COUNT = 9;
        final double GRADE_PERCENT_PER_LAB = LABS_GRADE_PERCENT / LABS_COUNT;
        
        // Variables String courseAndSemester;
        String courseAndSemester = "CS101 Spring 2026";
       
        System.out.println("Hello! Here are some details about coursework weights");
        System.out.println("Welcome to " + courseAndSemester + " Lab 01");
        System.out.println();
        System.out.println("There are " + LABS_COUNT + " lab sessions in this course.");
        System.out.println("Labs contribute to " + LABS_GRADE_PERCENT + "% of your total grade.");
        System.out.printf("This lab:\t%.2f\tpoints%n", GRADE_PERCENT_PER_LAB);
        System.out.println("All labs:\t" + LABS_GRADE_PERCENT + "\tpoints");
        System.out.println("Small percentages still matter! Practice adds up fast!");
        System.out.println();
        System.out.println("Best of luck!");
    }
}