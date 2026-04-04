package lab05;

import java.util.Scanner;

public class Lab05_Q1 {

    static char toUpper(char ch) {
        if (ch >= 97 && ch <= 122) {
            //ch = ch - 32; ??
            ch -= 32;
        }
        return ch;
    }

    static boolean isAlphabetic(char ch) {
        if ((ch >= 97 && ch <= 122) || (ch >= 65 && ch <= 90)) {
            return true;
        }
        return false;
    }

    static boolean isNumeric(char ch) {
        if (ch >= 48 && ch <= 57) {
            return true;
        }
        return false;
    }

    static boolean isSeparator(char ch) {
        return (ch == ' ' || ch == '\t' || ch == '\n');
    }

    public static boolean isMirrorText(String str) {
        String cleaned = "";

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!isSeparator(ch)) {
                cleaned += toUpper(ch);
            }
        }

        for (int i = 0; i < cleaned.length() / 2; i++) {
            if (cleaned.charAt(i) != cleaned.charAt(cleaned.length() - 1 - i)) {
                return false;
            }
        }

        return true;

    }

    public static boolean haveSameLetters(String str1, String str2) {
        String s1 = "";
        String s2 = "";

        for (int i = 0; i < str1.length(); i++) {
            char ch = str1.charAt(i);
            if (isAlphabetic(ch)) {
                s1 += toUpper(ch);
            }
        }

        for (int i = 0; i < str2.length(); i++) {
            char ch = str2.charAt(i);
            if (isAlphabetic(ch)) {
                s2 += toUpper(ch);
            }
        }

        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            int index = s2.indexOf(ch);

            if (index == -1) {
                return false;
            }

            s2 = s2.substring(0, index) + s2.substring(index + 1);
        }

        return s2.length() == 0;
    }

    public static int tokenCount(String str) {
        int tokenCount = 0;
        boolean insideToken = false;

        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);

            if (isSeparator(currentChar)) {
                insideToken = false;
            } else if (!insideToken) {
                tokenCount++;
                insideToken = true;
            }
        }

        return tokenCount;
    }

    public static String generateTag(String str) {
        StringBuilder result = new StringBuilder();
        boolean pendingUnderscore = false;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (isAlphabetic(ch)) {
                if (pendingUnderscore && result.length() > 0) {
                    result.append('_');
                }

                if (ch >= 'A' && ch <= 'Z') {
                    ch = (char) (ch + ('a' - 'A'));
                }

                result.append(ch);
                pendingUnderscore = false;
            } else if (isNumeric(ch)) {
                if (pendingUnderscore && result.length() > 0) {
                    result.append('_');
                }

                result.append(ch);
                pendingUnderscore = false;
            } else if (isSeparator(ch)) {
                if (result.length() > 0) {
                    pendingUnderscore = true;
                }
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("=== String Toolkit ===");
            System.out.println("1) Mirror Text");
            System.out.println("2) Compare Letters");
            System.out.println("3) Token Count");
            System.out.println("4) Generate Tag");
            System.out.println("5) Exit");
            System.out.print("Select an option (1-5): ");

            String selection = input.nextLine();

            if (selection.equals("1")) {
                System.out.print("Enter text: ");
                String text = input.nextLine();
                System.out.println("Result: " + isMirrorText(text));
            } else if (selection.equals("2")) {
                System.out.print("Enter first string: ");
                String first = input.nextLine();
                System.out.print("Enter second string: ");
                String second = input.nextLine();
                System.out.println("Result: " + haveSameLetters(first, second));
            } else if (selection.equals("3")) {
                System.out.print("Enter text: ");
                String text = input.nextLine();
                System.out.println("Token count: " + tokenCount(text));
            } else if (selection.equals("4")) {
                System.out.print("Enter text: ");
                String text = input.nextLine();
                System.out.println("Tag: " + generateTag(text));
            } else if (selection.equals("5")) {
                System.out.println("Goodbye!");
                running = false;
            }
        }

    }

}
