package lab04;

public class Lab04_Q3 {
    public static void main(String[] args) {

        final double GOAL = 1000.00;

        double balanceA = 100.00; 
        double monthlyA = 50.00;
        double balanceB = 300.00; 
        double monthlyB = 30.00;
        double balanceC = 0.00;   
        double monthlyC = 75.00;

        int month = 0;

        System.out.println("Welcome to the Savings Race!");
        System.out.printf("Target: $%.2f%n", GOAL);

        while (balanceA < GOAL && balanceB < GOAL && balanceC < GOAL) {
            month++;

            balanceA += monthlyA;
            balanceB += monthlyB;
            balanceC += monthlyC;

            System.out.println("Month " + month + ":");
            System.out.printf("Student A: %.2f | Student B: %.2f | Student C: %.2f%n",
                    balanceA, balanceB, balanceC);
        }

        System.out.println("Race finished!");
        System.out.println("Total months: " + month);

        System.out.println("Final Balances:");
        System.out.printf("Student A: $%.2f%n", balanceA);
        System.out.printf("Student B: $%.2f%n", balanceB);
        System.out.printf("Student C: $%.2f%n", balanceC);

        System.out.println("Winner(s):");

        String winners = "";
        boolean firstWinner = true;

        if (balanceA >= GOAL) {
            winners += "Student A";
            firstWinner = false;
        }

        if (balanceB >= GOAL) {
            if (!firstWinner) {
                winners += ", ";
            }
            winners += "Student B";
            firstWinner = false;
        }

        if (balanceC >= GOAL) {
            if (!firstWinner) {
                winners += ", ";
            }
            winners += "Student C";
            firstWinner = false;
        }

        System.out.println(winners);
    }
}