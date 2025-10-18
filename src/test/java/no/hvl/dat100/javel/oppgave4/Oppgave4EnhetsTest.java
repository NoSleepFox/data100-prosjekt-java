package no.hvl.dat100.javel.oppgave4;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import no.hvl.dat100.javel.oppgave3.Customer;
import no.hvl.dat100.javel.oppgave3.PowerAgreementType;

@Timeout(30)
class Oppgave4EnhetsTest {

    static Customer customer1 = new Customer("bob", "bob123@gmail.com", 1, PowerAgreementType.NORGESPRICE);
    static Customer customer2 = new Customer("roy", "roy123@gmail.com", 2, PowerAgreementType.SPOTPRICE);
    static Customer customer3 = new Customer("john", "john@gmail.com", 3, PowerAgreementType.POWERSUPPORT);
    static Customers customers;
    static Customer[] list_customer;

    @BeforeEach
    public void initEach() {
        customers = new Customers(5);
        customers.addCustomer(customer1);
        customers.addCustomer(customer2);
        customers.addCustomer(customer3);
        list_customer = new Customer[3];
        list_customer[0] = customer1;
        list_customer[1] = customer2;
        list_customer[2] = customer3;
    }

    @Test
    public void testNumberCustomers() {
        int number_customers = 3;
        int t_number_customers = customers.countNonNull();
        assertEquals(number_customers, t_number_customers);
    }

    @Test
    public void testGetCustomer() {
        Customer t_customer1 = customers.getCustomer(1);
        assertEquals(customer1, t_customer1);
    }

    @Test
    public void testRemoveCustomer() {
        int number_customers = 2;
        Customer t_customer2 = customers.removeCustomer(2);
        int t_number_customers = customers.countNonNull();
        assertAll(
                () -> assertEquals(customer2, t_customer2),
                () -> assertEquals(number_customers, t_number_customers)
        );
    }

    @Test
    public void testGetCustomers() {
        Customer[] t_list_customer = customers.getCustomers();
        assertAll(
                () -> assertEquals(list_customer[0], t_list_customer[0]),
                () -> assertEquals(list_customer[1], t_list_customer[1]),
                () -> assertEquals(list_customer[2], t_list_customer[2])
        );
    }
}
