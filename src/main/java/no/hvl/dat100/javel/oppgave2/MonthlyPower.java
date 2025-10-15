package no.hvl.dat100.javel.oppgave2;

import no.hvl.dat100.javel.oppgave1.DailyPower;

public class MonthlyPower {

    // a) print power usage for a month
    public static void print_PowerUsage(double[][] usage) {
            System.out.println("Strømforbruk for måneden:");
            System.out.println("---------------------------");

            for (int day = 0; day < usage.length; day++) {
                System.out.println("Dag " + (day + 1) + ":");
                    DailyPower.printPowerUsage(usage[day]);
                System.out.println();
                System.out.println("---------------------------");
        }

    }

    // b) print power prices for a month
    public static void print_PowerPrices(double[][] prices) {
        System.out.println("Pris per måned");
        System.out.println("--------------------------");

        int day;
        for (day = 0; day < prices.length; day++) {
            System.out.println("Dag " + (day + 1) + ":");
            DailyPower.printPowerPrices(prices[day]);
            System.out.println();

            System.out.println("--------------------------");
        }
    }

    // c) compute total power usage for a month
    public static double computePowerUsage(double[][] usage) {
        System.out.println("Total strømforbruk for måned");
        System.out.println("----------------------------");

        double sum = 0;
        for (int day = 0; day < usage.length; day++) {
            for (int hour = 0; hour < usage[day].length; hour++) {
                sum += usage[day][hour];
            }
        }
        return sum;
    }


    // d) determine whether a given threshold in powerusage for the month has been exceeded
    public static boolean exceedThreshold(double[][] powerusage, double threshold) {

        boolean exceeded = false;
        double totalUsage = 0;

        int day = 0;
        while (day < powerusage.length){
            int hour = 0;
            while(hour <powerusage[day].length){
                totalUsage +=powerusage[day][hour];
                hour++;
            }
            if (totalUsage <threshold);
        }


        // TODO

        return exceeded;
    }

    // e) compute spot price
    public static double computeSpotPrice(double[][] usage, double[][] prices) {

        double price = 0;

        // TODO

        return price;
    }

    // f) power support for the month
    public static double computePowerSupport(double[][] usage, double[][] prices) {

        double support = 0;

        // TODO

        return support;
    }

    // g) Norgesprice for the month
    public static double computeNorgesPrice(double[][] usage) {

        double price = 0;

        // TODO

        return price;
    }
}
