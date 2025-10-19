package no.hvl.dat100.javel.oppgave4;

import no.hvl.dat100.javel.oppgave3.Customer;
import no.hvl.dat100.javel.oppgave3.PowerAgreementType;

public class CustomersMain {

    public static void main(String[] args) {

        System.out.println("==============");
        System.out.println("OPPGAVE 4");
        System.out.println("==============");
        System.out.println();
        System.out.println("a) - b) - c) - d)");
        Customers customers = new Customers(4);
        Customer new_customer1 = new Customer("bob", "bob123@gmail.com", 1, PowerAgreementType.NORGESPRICE);
        Customer new_customer2 = new Customer("roy", "roy123@gmail.com", 2, PowerAgreementType.SPOTPRICE);
        Customer new_customer3 = new Customer("john", "john@gmail.com", 3, PowerAgreementType.POWERSUPPORT);
        customers.addCustomer(new_customer1);
        customers.addCustomer(new_customer2);
        customers.addCustomer(new_customer3);
        Customer customer2 = customers.getCustomer(2);
        int total_customers = customers.countNonNull();
        System.out.println("Det er " + total_customers + " kunder og navnet til kunde to er " + customer2.getName());
        Customer deleted_customer = customers.removeCustomer(2);
        System.out.println();
        System.out.println("e)");
        System.out.println("Kunde " + deleted_customer.getName() + " ble fjernet fra listen");
        System.out.println();
        System.out.println("f)");
        Customer[] real_customers = customers.getCustomers();
        for (Customer i : real_customers) {
            i.valuesToString();
            System.out.println();
        }

    }
}
