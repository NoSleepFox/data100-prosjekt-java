package no.hvl.dat100.javel.oppgave5;

public class Invoices {

    public static void processInvoices(Invoice[] invoices) {

        for (Invoice invoice : invoices) {
            invoice.computeAmount();
            System.out.println("====================");
            invoice.printInvoice();
            System.out.println("====================");
            System.out.println();
        }
    }
}
