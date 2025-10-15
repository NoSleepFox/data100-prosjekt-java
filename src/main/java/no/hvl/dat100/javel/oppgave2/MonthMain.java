package no.hvl.dat100.javel.oppgave2;

import no.hvl.dat100.javel.oppgave1.DailyPower;
import no.hvl.dat100.javel.oppgave1.DayPowerData;

import static no.hvl.dat100.javel.oppgave2.MonthlyPower.print_PowerPrices;
import static no.hvl.dat100.javel.oppgave2.MonthlyPower.print_PowerUsage;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class MonthMain {
    public static void main(String[] args) {

        // test data
        double[][] power_prices_month = MonthPowerData.powerprices_month;

        double[][] power_usage_month = MonthPowerData.powerusage_month;

        System.out.println("==============");
        System.out.println("OPPGAVE 2");
        System.out.println("==============");
        System.out.println("a) ");
        print_PowerUsage(power_usage_month);
        System.out.println("\n");
        System.out.println("b) ");
        print_PowerPrices(power_prices_month);
        System.out.println("\n");
        System.out.println("c) ");
        double totalUsage = MonthlyPower.computePowerUsage(power_usage_month);
        System.out.printf("Total strømforbruk for måned: %.2f kWh%n" , totalUsage);
        System.out.println("\n");
        System.out.println("d");





        /*
        TODO

         Write code that tests the methods you implement in the MonthlyPower class
         Remember to teste the methods as you implement them
         Remember to also to check that you get the expected results
         */

    }
}