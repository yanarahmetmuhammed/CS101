package lab03;

import java.util.Scanner;

public class Lab03_Q2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int age;
        double annualBudget;
        int previousTrips;
        String destinationType;
        String travelSeason;
        int groupSize;

        int totalScore = 50;
        int agePoints = 0;
        int budgetPoints = 0;
        int loyaltyPoints = 0;
        int seasonalBonusPoints = 0;
        int groupPenaltyPoints = 0;
        int destinationBonusPoints = 0;

        boolean eligible = true;

        System.out.print("Enter customer age: ");
        age = input.nextInt();

        System.out.print("Enter annual travel budget: ");
        annualBudget = input.nextDouble();

        System.out.print("Enter number of previous trips with company: ");
        previousTrips = input.nextInt();
        input.nextLine();

        System.out.print("Enter preferred destination type (beach/mountain/city/adventure): ");
        destinationType = input.nextLine();

        System.out.print("Enter travel season (summer/winter/spring/fall): ");
        travelSeason = input.nextLine();

        System.out.print("Enter number of travelers in group: ");
        groupSize = input.nextInt();

        // Age points
        if (age >= 18) {
            if (age <= 30) {
                agePoints = 15;
            } else {
                if (age <= 45) {
                    agePoints = 25;
                } else {
                    if (age <= 60) {
                        agePoints = 20;
                    } else {
                        if (age <= 75) {
                            agePoints = 10;
                        }
                    }
                }
            }
        }

        budgetPoints = (int) (annualBudget / 100.0);
        if (budgetPoints > 150) {
            budgetPoints = 150;
        }

        // Loyalty points
        if (previousTrips >= 3) {
            if (previousTrips <= 5) {
                loyaltyPoints = 30;
            } else {
                if (previousTrips <= 10) {
                    loyaltyPoints = 60;
                } else {
                    loyaltyPoints = 100;
                }
            }
        }

        if (travelSeason.equalsIgnoreCase("summer")) {
            if (destinationType.equalsIgnoreCase("beach")) {
                seasonalBonusPoints = 20;
            }
            if (destinationType.equalsIgnoreCase("adventure")) {
                seasonalBonusPoints = 20;
            }
        }

        if (travelSeason.equalsIgnoreCase("winter")) {
            if (destinationType.equalsIgnoreCase("mountain")) {
                seasonalBonusPoints = 20;
            }
        }

        if (travelSeason.equalsIgnoreCase("spring")) {
            if (destinationType.equalsIgnoreCase("city")) {
                seasonalBonusPoints = 15;
            }
        }

        if (travelSeason.equalsIgnoreCase("fall")) {
            if (destinationType.equalsIgnoreCase("mountain")) {
                seasonalBonusPoints = 15;
            }
            if (destinationType.equalsIgnoreCase("city")) {
                seasonalBonusPoints = 15;
            }
        }

        // penalty
        groupPenaltyPoints = groupSize * 5;

        // preference bonus
        if (destinationType.equalsIgnoreCase("adventure")) {
            if (age >= 18) {
                if (age <= 45) {
                    destinationBonusPoints = destinationBonusPoints + 25;
                }
            }
        }

        if (destinationType.equalsIgnoreCase("beach")) {
            if (travelSeason.equalsIgnoreCase("summer")) {
                destinationBonusPoints = destinationBonusPoints + 15;
            }
        }

        if (destinationType.equalsIgnoreCase("mountain")) {
            if (travelSeason.equalsIgnoreCase("winter")) {
                destinationBonusPoints = destinationBonusPoints + 15;
            }
        }

        totalScore = totalScore + agePoints;
        totalScore = totalScore + budgetPoints;
        totalScore = totalScore + loyaltyPoints;
        totalScore = totalScore + seasonalBonusPoints;
        totalScore = totalScore - groupPenaltyPoints;
        totalScore = totalScore + destinationBonusPoints;

        if (age < 18) {
            eligible = false;
        }

        if (annualBudget < 2000) {
            eligible = false;
        }

        if (groupSize > 8) {
            eligible = false;
        }

        if (totalScore < 150) {
            eligible = false;
        }

        // outputs
        System.out.println();
        System.out.println("Total eligibility score: " + totalScore);
        System.out.println();

        if (eligible) {
            System.out.println("The applicant is approved for the travel package.");

            if (totalScore >= 150) {
                if (totalScore <= 199) {
                    System.out.println("Package tier: Silver Package");
                } else {
                    if (totalScore <= 249) {
                        System.out.println("Package tier: Gold Package");
                    } else {
                        System.out.println("Package tier: Platinum Package");
                    }
                }
            }
        } else {
            System.out.println("The applicant is not approved for the travel package. Reason:");

            if (age < 18) {
                System.out.println("Age is below 18.");
            }

            if (annualBudget < 2000) {
                System.out.println("Annual budget is below $2,000.");
            }

            if (groupSize > 8) {
                System.out.println("Group size exceeds 8 travelers.");
            }

            if (totalScore < 150) {
                System.out.println("Total eligibility score is below 150 points.");
            }
        }
    }
}