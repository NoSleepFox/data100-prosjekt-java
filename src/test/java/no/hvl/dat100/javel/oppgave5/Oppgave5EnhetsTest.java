package no.hvl.dat100.javel.oppgave5;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import no.hvl.dat100.javel.oppgave2.MonthPowerData;
import no.hvl.dat100.javel.oppgave3.Customer;
import no.hvl.dat100.javel.oppgave3.PowerAgreementType;

@Timeout(30)
class Oppgave3EnhetsTest {

    static Customer customer1;
    static Customer customer2;

    static Invoice[] all_invoices;

    static String string_invoice1;
    static String string_invoice2;
    static String string_invoices;

    @BeforeEach
    public void initEach() {

        customer1 = new Customer("Roy", "roy123@gmail.com", 1, PowerAgreementType.SPOTPRICE);
        customer2 = new Customer("Bob", "bob.hans@gmail.com", 2, PowerAgreementType.NORGESPRICE);

        all_invoices = new Invoice[2];
        all_invoices[0] = new Invoice(customer1, "January", CustomerPowerUsageData.usage_month_customer1, MonthPowerData.powerprices_month);
        all_invoices[1] = new Invoice(customer2, "January", CustomerPowerUsageData.usage_month_customer2, MonthPowerData.powerprices_month);

        string_invoice1 = "====================\nName: Roy\nEmail: roy123@gmail.com\nCustomer number: 1\nAgreement: SPOTPRICE\n\nMonth: January\nUsage: 927.56 kWh\nAmount: 3409.6 NOK\n====================\n\n";
        string_invoice2 = "====================\nName: Bob\nEmail: bob.hans@gmail.com\nCustomer number: 2\nAgreement: NORGESPRICE\n\nMonth: January\nUsage: 914.58 kWh\nAmount: 457.32 NOK\n====================\n\n";
        string_invoices = string_invoice1 + string_invoice2;
    }

    @Test
    public void testProcessInvoices() {
        ByteArrayOutputStream print_out = new ByteArrayOutputStream();
        PrintStream original_out;

        original_out = System.out;
        System.setOut(new PrintStream(print_out));

        Invoices.processInvoices(all_invoices);

        String result = print_out.toString();
        assertEquals(string_invoices.trim(), result.trim());

        System.setOut(original_out);
    }
}
