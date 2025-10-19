package no.hvl.dat100.javel.oppgave3;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

@Timeout(30)
class Oppgave3EnhetsTest {

    static Customer test_customer;
    static String name;
    static String email;
    static int customer_id;
    static PowerAgreementType agreement;
    static String values_to_string;

    @BeforeEach
    public void initEach() {

        name = "Bob";
        email = "bob123@gmail.com";
        customer_id = 1;
        agreement = PowerAgreementType.POWERSUPPORT;

        test_customer = new Customer(name, email, customer_id, agreement);

        values_to_string = "Name: Bob\nEmail: bob123@gmail.com\nCustomer number: 1\nAgreement: POWERSUPPORT";
    }

    private void verifyCustomerValues(String name, String email, int customer_id, PowerAgreementType agreement) {
        assertAll("Teste alle assertEquals",
                () -> assertEquals(name, test_customer.getName()),
                () -> assertEquals(email, test_customer.getEmail()),
                () -> assertEquals(customer_id, test_customer.getCustomer_id()),
                () -> assertEquals(agreement, test_customer.getAgreement())
        );
    }

    @Test
    public void testGet() {
        verifyCustomerValues(name, email, customer_id, agreement);
    }

    @Test
    public void testSet() {
        name = "Roy";
        email = "roy.smith@gmail.com";
        customer_id = 2;
        agreement = PowerAgreementType.SPOTPRICE;

        test_customer.setName(name);
        test_customer.setEmail(email);
        test_customer.setCustomer_id(customer_id);
        test_customer.setAgreement(agreement);

        verifyCustomerValues(name, email, customer_id, agreement);
    }

    @Test
    public void testValuesToString() {
        ByteArrayOutputStream print_out = new ByteArrayOutputStream();
        PrintStream original_out;

        original_out = System.out;
        System.setOut(new PrintStream(print_out));

        test_customer.valuesToString();
        String result = print_out.toString();
        assertEquals(values_to_string.trim(), result.trim());

        System.setOut(original_out);
    }
}
