package lab02;

import java.util.Scanner;

public class Lab02_Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter book information: ");
        String info = sc.nextLine().trim();
        // symbols positions
        int braceOpen = info.indexOf("{");
        int braceClose = info.indexOf("}");
        int bracketOpen = info.indexOf("[");
        int bracketClose = info.indexOf("]");
        int underscore = info.indexOf("_");

        String title = info.substring(0, braceOpen).trim();
        String author = info.substring(braceOpen + 1, braceClose).trim();
        String yearString = info.substring(bracketOpen + 1, bracketClose).trim();
        int year = Integer.parseInt(yearString);
        String publisher = info.substring(underscore + 1).trim();
        System.out.printf("The book \"%s\" was written by %s in %d and published by %s.%n",
                title, author, year, publisher);

        // The Great Gatsby {F. Scott Fitzgerald} [1925] _Scribner
    }

}
