package no.hvl.dat100.javel.oppgave5;

import no.hvl.dat100.javel.oppgave2.MonthPowerData;
import no.hvl.dat100.javel.oppgave3.Customer;
import no.hvl.dat100.javel.oppgave3.PowerAgreementType;

public class InvoiceMain {

    public static void main(String[] args) {

        System.out.println("==============");
        System.out.println("OPPGAVE 5");
        System.out.println("==============");
        System.out.println();

        Customer customer1 = new Customer("Roy", "roy123@gmail.com", 1, PowerAgreementType.SPOTPRICE);
        Customer customer2 = new Customer("Bob", "bob.hans@gmail.com", 2, PowerAgreementType.NORGESPRICE);
        Customer customer3 = new Customer("John", "jrex783@gmail.com", 3, PowerAgreementType.POWERSUPPORT);

        Invoice[] all_invoices = new Invoice[3];

        Invoice invoice1 = new Invoice(customer1, "January", CustomerPowerUsageData.usage_month_customer1, MonthPowerData.powerprices_month);
        Invoice invoice2 = new Invoice(customer2, "January", CustomerPowerUsageData.usage_month_customer2, MonthPowerData.powerprices_month);
        Invoice invoice3 = new Invoice(customer3, "January", CustomerPowerUsageData.usage_month_customer3, MonthPowerData.powerprices_month);

        all_invoices[0] = invoice1;
        all_invoices[1] = invoice2;
        all_invoices[2] = invoice3;

        Invoices.processInvoices(all_invoices);

    }
}
