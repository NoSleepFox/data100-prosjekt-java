package no.hvl.dat100.javel.oppgave1;

public class DayMain {

    public static void main(String[] args) {

        // test data
        double[] powerusage_day = DayPowerData.powerusage_day;

        double[] powerprices_day = DayPowerData.powerprices_day;

        System.out.println("==============");
        System.out.println("OPPGAVE 1");
        System.out.println("==============");
        System.out.println();
        System.out.println("a)");
        DailyPower.printPowerPrices(powerprices_day);
        System.out.println("\n");
        System.out.println("b)");
        DailyPower.printPowerUsage(powerusage_day);
        System.out.println("\n");
        System.out.println("c)");
        double total_usage = DailyPower.computePowerUsage(powerusage_day);
        System.out.println("Den totale bruken av strøm er " + total_usage + " kWh");
        System.out.println();
        System.out.println("d)");
        double total_spot_price = DailyPower.computeSpotPrice(powerusage_day, powerprices_day);
        System.out.printf("Den totale kostnaden av strømen er %.2f NOK", total_spot_price);
        System.out.println("\n");
        System.out.println("e) og f)");
        double total_suport = DailyPower.computePowerSupport(powerusage_day, powerprices_day);
        System.out.println("Strømstøtteavtalen vil dekke " + total_suport + " NOR den første timen");
        System.out.println();
        System.out.println("g)");
        double total_norway_price = DailyPower.computeNorgesPrice(powerusage_day);
        System.out.printf("Den totale kostnaden med Norges pris av strømen er %.2f NOK", total_norway_price);
        System.out.println("\n");
        System.out.println("h)");
        double peek_power_usage = DailyPower.findPeakUsage(powerusage_day);
        System.out.println("Det største strømforbruket er på " + peek_power_usage + " kWh");
        System.out.println();
        System.out.println("i)");
        double average_power_usage = DailyPower.findAvgPower(powerusage_day);
        System.out.println("Det gjennomsnitlige strømforbruket var på " + average_power_usage + " kWh");
    }
}
