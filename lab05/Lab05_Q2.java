package lab05;

import java.util.Scanner;

public class Lab05_Q2 {

    public static boolean isAlphabetic(char ch) {
        return (ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z');
    }

    public static boolean isLowerAlphabet(char ch) {
        return ch >= 'a' && ch <= 'z';
    }

    public static String shiftCipher(String text, int shift, boolean encrypt) {
        StringBuilder answer = new StringBuilder();

        int realShift = shift % 26;
        if (!encrypt) {
            realShift = -realShift;
        }

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (isAlphabetic(ch)) {
                char start;

                if (isLowerAlphabet(ch)) {
                    start = 'a';
                } else {
                    start = 'A';
                }

                int oldPos = ch - start;
                int newPos = (oldPos + realShift) % 26;

                if (newPos < 0) {
                    newPos += 26;
                }

                char newCh = (char) (start + newPos);
                answer.append(newCh);
            } else {
                answer.append(ch);
            }
        }

        return answer.toString();
    }

    public static String reverseAlphabetCipher(String text) {
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (ch >= 'A' && ch <= 'Z') {
                char newCh = (char) ('Z' - (ch - 'A'));
                answer.append(newCh);
            } else if (ch >= 'a' && ch <= 'z') {
                char newCh = (char) ('z' - (ch - 'a'));
                answer.append(newCh);
            } else {
                answer.append(ch);
            }
        }

        return answer.toString();
    }

    public static String reverseString(String text) {
        StringBuilder answer = new StringBuilder();

        for (int i = text.length() - 1; i >= 0; i--) {
            answer.append(text.charAt(i));
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;

        do {
            System.out.println("=== Encoding Toolkit ===");
            System.out.println("1) Shift Cipher");
            System.out.println("2) Reverse Alphabet Cipher");
            System.out.println("3) Reverse Text");
            System.out.println("4) Exit");
            System.out.print("Choose an option (1-4): ");
            choice = input.nextInt();
            input.nextLine();

            if (choice == 1) {
                System.out.print("Enter text: ");
                String text = input.nextLine();

                System.out.print("Enter shift amount: ");
                int shift = input.nextInt();
                input.nextLine();

                System.out.print("Type 'e' to encode or 'd' to decode: ");
                char type = input.nextLine().charAt(0);

                boolean encrypt = type == 'e';
                String result1 = shiftCipher(text, shift, encrypt);

                System.out.println("Result: " + result1);
            } else if (choice == 2) {
                System.out.print("Enter text: ");
                String text2 = input.nextLine();

                String result2 = reverseAlphabetCipher(text2);
                System.out.println("Result: " + result2);
            } else if (choice == 3) {
                System.out.print("Enter text: ");
                String text3 = input.nextLine();

                String result3 = reverseString(text3);
                System.out.println("Reversed Text: " + result3);
            } else if (choice == 4) {
                System.out.println("Goodbye!");
            } else {
                System.out.println("Invalid option.");
            }

        } while (choice != 4);

    }
}