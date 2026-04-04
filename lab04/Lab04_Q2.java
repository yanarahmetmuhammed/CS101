package lab04;
import java.util.Scanner;

public class Lab04_Q2 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        boolean running = true;

        while (running) {
            System.out.print("Enter a string: ");
            String string = scn.nextLine();

            if (string.equals("0")) {
                System.out.println("Program terminated.");
                running = false;
            } else {
                boolean isPalindrome = true;
                int i = 0;

                while (i < string.length() / 2 && isPalindrome) {
                    if (string.charAt(i) != string.charAt(string.length() - 1 - i)) {
                        isPalindrome = false;
                    }
                    i++;
                }

                if (isPalindrome) {
                    System.out.println("It is a palindrome.");
                } else {
                    System.out.println("It is not a palindrome.");
                }
            }
        }
    }
}