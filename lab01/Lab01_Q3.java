package lab01;

public class Lab01_Q3 {
    public static void main(String[] args) {
        final double ANNU_ENERGY_OF_WORLD = 4200000;
        final double PERCENTAGE_OF_RENEW_SOURCES = 63.5;
        final double PERCENTAGE_OF_GERMANY = 2.3;
        final double RATIO_RENEW_TO_NONRENEW_GER = 1.8;

        double totalRenewable = ANNU_ENERGY_OF_WORLD * (PERCENTAGE_OF_RENEW_SOURCES / 100);
        double totalNonRenewable = ANNU_ENERGY_OF_WORLD - totalRenewable;
        double totalGermany = ANNU_ENERGY_OF_WORLD * (PERCENTAGE_OF_GERMANY / 100);

        // RENEWABLE = 1.8X NONRENEWABLE = 1X TOTAL GERMANY = 2.8X
        double germanyRenewable = totalGermany * (RATIO_RENEW_TO_NONRENEW_GER / 2.8);
        // double germanyNonRenewable = totalGermany - germanyRenewable; ??
        double germanyNonRenewable = totalGermany * (1 / 2.8);
        double percentageOfRenewGerToAllRenew = (germanyRenewable / totalRenewable) * 100;
        double percentageOfNonRenewToAllNonRenew = (germanyNonRenewable / totalNonRenewable) * 100;

        // Outputs
        System.out.printf("The world produces %.0f km2 renewable energy and %.0f km2 non-renewable energy. \n",
                totalRenewable, totalNonRenewable);
        System.out.printf("Germany produces %.0f km2 renewable energy and %.0f km2 non-renewable energy. \n",
                germanyRenewable, germanyNonRenewable);
        System.out.println("Germany produces " + percentageOfRenewGerToAllRenew +
                " percent of the world's renewable energy and " + percentageOfNonRenewToAllNonRenew +
                " percent of the world's non-renewable energy.");

    }
}
