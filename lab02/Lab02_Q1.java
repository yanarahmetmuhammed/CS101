package lab02;

import java.util.Scanner;

public class Lab02_Q1 {
    public static void main(String[] args) {
        Scanner sc   = new Scanner(System.in);
        // Base edge length a
        // Slant height s
        double a;
        double s;
        System.out.print("Enter base edge length: ");
        a = sc.nextDouble();
        System.out.print("Enter slant height: ");
        s = sc.nextDouble();
        // surface area of the square pyramid = a^2 + 2as
        double hsquared = (s * s) - ((a / 2) * (a / 2));
        double height = Math.sqrt(hsquared);
        double volume = (a * a * height) / 3;
        double surfaceArea = a * a + 2 * a * s;
        System.out.printf("The height of the pyramid is:%12.1f%n", height);
        System.out.printf("The volume of the pyramid is:%12.1f%n", volume);
        System.out.printf("The total surface area is: %15.1f%n", surfaceArea);

    }

}
