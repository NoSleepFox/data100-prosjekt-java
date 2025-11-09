package no.hvl.dat100.javel.oppgave5;

import no.hvl.dat100.javel.oppgave2.MonthlyPower;
import no.hvl.dat100.javel.oppgave3.Customer;
import no.hvl.dat100.javel.oppgave3.PowerAgreementType;

public class Invoice {

    private Customer c; // customer associated with this invoice
    private String month; // month that the invoice covers
    private double[][] usage; // power usage this month (per day and per hour)
    private double[][] prices; // power prices for this month

    private double amount; // power price for this month

    public Invoice(Customer c, String month, double[][] usage, double[][] power_prices) {

        this.c = c;
        this.month = month;
        this.usage = usage;
        prices = power_prices;
        amount = 0.0;

    }

    public void computeAmount() {

        PowerAgreementType agreement = c.getAgreement();
        switch (agreement) {
            case POWERSUPPORT ->
                amount = MonthlyPower.computePowerSupport(usage, prices);
            case NORGESPRICE ->
                amount = MonthlyPower.computeNorgesPrice(usage);
            case SPOTPRICE ->
                amount = MonthlyPower.computeSpotPrice(usage, prices);
            default ->
                throw new AssertionError("Agreement does not exist");
        }

    }

    public void printInvoice() {

        c.valuesToString();
        System.out.println();
        System.out.println("Month: " + month);
        double total_usage = MonthlyPower.computePowerUsage(usage);
        System.out.println("Usage: " + total_usage + " kWh");
        System.out.println("Amount: " + amount + " NOK");
    }
}
