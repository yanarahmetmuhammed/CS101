package lab02;

import java.util.Scanner;

public class Lab02_Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // gravitational accelerations m/s^2
        final double G_EARTH = 9.807;
        final double G_MOON = 1.620;
        final double G_MARS = 3.711;
        final double G_JUPITER = 24.790;
        // inputs
        System.out.print("Enter the mass of the first probe (kg): ");
        double mass1 = sc.nextDouble();
        System.out.print("Enter the mass of the second probe (kg): ");
        double mass2 = sc.nextDouble();
        // calculations
        double weightEarthMass1 = mass1 * G_EARTH;
        double weightEarthMass2 = mass2 * G_EARTH;
        double weightMoonMass1 = mass1 * G_MOON;
        double weightMoonMass2 = mass2 * G_MOON;
        double weightMarsMass1 = mass1 * G_MARS;
        double weightMarsMass2 = mass2 * G_MARS;
        double weightJupiterMass1 = mass1 * G_JUPITER;
        double weightJupiterMass2 = mass2 * G_JUPITER;
        // outputs
        System.out.printf("%-30s%15s%15s%15s%15s%n",
                "", "EARTH", "MOON", "MARS", "JUPITER");
        System.out.printf("%-30s%15.1f%15.1f%15.1f%15.1f%n",
                "PROBE ONE (" + String.format("%.1f", mass1) + "kg)",
                weightEarthMass1, weightMoonMass1, weightMarsMass1, weightJupiterMass1);
        System.out.printf("%-30s%15.1f%15.1f%15.1f%15.1f%n",
                "PROBE TWO (" + String.format("%.1f", mass2) + "kg)",
                weightEarthMass2, weightMoonMass2, weightMarsMass2, weightJupiterMass2);

    }

}
