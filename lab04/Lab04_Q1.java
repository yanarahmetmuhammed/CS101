package lab04;

import java.util.Scanner;

public class Lab04_Q1 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n;
        System.out.print("Enter an odd number for the hourglass pattern: ");
        n = scn.nextInt();

        while (n <= 0 || n % 2 == 0) {
            System.out.println("Invalid input, try again.");
            System.out.print("Enter an odd number for the hourglass pattern: ");
            n = scn.nextInt();
        }

        int mid = n / 2;

        for (int row = 0; row <= mid; row++) {
            //spaces
            for (int space = 0; space < row; space++) {
                System.out.print(" ");
            }
            // stars
            int stars = n - 2 * row;
            for (int k = 0; k < stars; k++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for (int row = mid - 1; row >= 0; row--) {
            // spaces
            for (int space2 = 0; space2 < row; space2++) {
                System.out.print(" ");
            }
            // stars
            int stars = n - 2 * row;
            for (int k = 0; k < stars; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}