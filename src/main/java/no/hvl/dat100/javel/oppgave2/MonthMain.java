package no.hvl.dat100.javel.oppgave2;

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
        System.out.println("----------------------------");
        System.out.println("c) ");
        double totalUsage = MonthlyPower.computePowerUsage(power_usage_month);
        System.out.printf("Total strømforbruk for måned: %.2f kWh%n", totalUsage);
        System.out.println("\n");
        System.out.println("d) ");
        double lowThreshold = totalUsage - 0.01;
        double highThreshold = totalUsage + 0.01;
        System.out.println("Brukt opp strømgrensen på hytte: " + MonthlyPower.exceedThreshold(power_usage_month, lowThreshold));
        System.out.println("Brukt opp strømgrensen på bolig: " + MonthlyPower.exceedThreshold(power_usage_month, highThreshold));
        System.out.println("\n");
        System.out.println("e) ");
        double[][] month_power_usage = MonthPowerData.powerusage_month;
        double[][] month_power_prices = MonthPowerData.powerprices_month;
        double spotPrice = MonthlyPower.computeSpotPrice(month_power_usage, month_power_prices);
        System.out.printf("Total beløp for spotsprisavtale denne måneden: %.2f NOK%n", spotPrice);
        System.out.println("\n");
        System.out.println("f) ");
        double[][] power_usage_monthly = MonthPowerData.powerusage_month;
        double[][] power_prices_monthly = MonthPowerData.powerprices_month;
        double support = MonthlyPower.computePowerSupport(power_usage_monthly, power_prices_monthly);
        System.out.printf("Total strømstøtte for måneden %.2f", support);
        System.out.println("\n");
        System.out.println("g) ");
        double monthNorge = MonthlyPower.computeNorgesPrice(power_usage_month);
        System.out.printf("Norges pris er %.2f ", monthNorge);

        /*
        TODO

         Write code that tests the methods you implement in the MonthlyPower class
         Remember to teste the methods as you implement them
         Remember to also to check that you get the expected results
         */
    }
}
