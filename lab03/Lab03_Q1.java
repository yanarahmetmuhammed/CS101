package lab03;

import java.util.Scanner;

public class Lab03_Q1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int age;
        String movieType;
        String showTime;
        boolean premiumMember;

        double basePrice = 0.0;
        double finalPrice = 0.0;
        double totalSavings = 0.0;
        double ageDiscountRate = 0.0;

        boolean validInput = true;
        boolean movieTypeValid = false;
        boolean showTimeValid = false;
        boolean isIMAX = false;
        boolean isMatinee = false;
        boolean isEvening = false;

        System.out.print("Enter customer age: ");
        age = input.nextInt();
        input.nextLine();

        System.out.print("Enter movie type (regular/3D/IMAX): ");
        movieType = input.nextLine();

        System.out.print("Enter show time (matinee/evening): ");
        showTime = input.nextLine();

        System.out.print("Premium member? (true/false): ");
        premiumMember = input.nextBoolean();

        // type of movie
        if (movieType.equalsIgnoreCase("regular")) {
            basePrice = 10.0;
            movieTypeValid = true;
        }

        if (movieType.equalsIgnoreCase("3D")) {
            basePrice = 15.0;
            movieTypeValid = true;
        }

        if (movieType.equalsIgnoreCase("IMAX")) {
            basePrice = 18.0;
            isIMAX = true;
            movieTypeValid = true;
        }

        if (!movieTypeValid) {
            System.out.println("Error: Invalid movie type.");
            validInput = false;
        }

        // time
        if (validInput) {
            if (showTime.equalsIgnoreCase("matinee")) {
                isMatinee = true;
                showTimeValid = true;
            }

            if (showTime.equalsIgnoreCase("evening")) {
                isEvening = true;
                showTimeValid = true;
            }

            if (!showTimeValid) {
                System.out.println("Error: Invalid show time.");
                validInput = false;
            }
        }

        //under 5 cannot watch imax
        if (validInput) {
            if (age < 5) {
                if (isIMAX) {
                    System.out.println("Error: Children under 5 cannot watch IMAX movies.");
                    validInput = false;
                }
            }
        }

        if (validInput) {
            if (age < 12) {
                ageDiscountRate = 0.40;
            } else {
                if (age <= 25) {
                    ageDiscountRate = 0.25;
                } else {
                    if (age <= 64) {
                        ageDiscountRate = 0.0;
                    } else {
                        ageDiscountRate = 0.35;
                    }
                }
            }

            finalPrice = basePrice;
            finalPrice = finalPrice * (1.0 - ageDiscountRate);

            if (isMatinee) {
                finalPrice = finalPrice * 0.80;
            }

            if (premiumMember) {
                finalPrice = finalPrice * 0.90;
            }

            double discountBeforeSurcharge = basePrice - finalPrice;
            double maxDiscount = basePrice * 0.60;

            if (discountBeforeSurcharge > maxDiscount) {
                finalPrice = basePrice - maxDiscount;
            }

            if (isIMAX) {
                if (isEvening) {
                    finalPrice = finalPrice + 3.0;
                }
            }

            totalSavings = basePrice - finalPrice;
            if (totalSavings < 0) {
                totalSavings = 0.0;
            }

            // outputs
            System.out.printf("Base Price: $%.2f%n", basePrice);

            if (age < 12) {
                System.out.println("Children Discount Applied: 40%");
            } else {
                if (age <= 25) {
                    System.out.println("Student Discount Applied: 25%");
                } else {
                    if (age <= 64) {
                        System.out.println("Adult Discount Applied: 0%");
                    } else {
                        System.out.println("Senior Discount Applied: 35%");
                    }
                }
            }

            if (isMatinee) {
                System.out.println("Matinee Discount Applied: 20%");
            }

            if (premiumMember) {
                System.out.println("Premium Member Discount Applied: 10%");
            }

            if (isIMAX) {
                if (isEvening) {
                    System.out.println("Evening IMAX Surcharge Applied: $3.00");
                }
            }

            System.out.printf("Final Price: $%.2f%n", finalPrice);
            System.out.printf("Total Savings: $%.2f%n", totalSavings);
            System.out.println("Enjoy your movie!");
        }
    }
}
