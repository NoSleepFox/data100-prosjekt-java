package no.hvl.dat100.javel.oppgave4;

import no.hvl.dat100.javel.oppgave3.Customer;

public class Customers {

    private Customer[] customers;

    // a) Complete constructor
    public Customers(int size) {

        customers = new Customer[size];

    }

    // b) count number of non-null references
    public int countNonNull() {

        int count = 0;

        for (Customer i : customers) {
            if (!(i == null)) {
                count++;
            }
        }
        return count;
    }

    // c) return reference to customer with given id (if exists)
    public Customer getCustomer(int customer_id) {

        boolean funnet = false;
        Customer c = null;

        for (Customer i : customers) {
            if (i.getCustomer_id() == customer_id) {
                c = i;
                return c;
            }
        }
        return c;
    }

    // d) add a customer to the reference table
    public boolean addCustomer(Customer c) {

        boolean inserted = false;

        for (int i = 0; i < customers.length; i++) {
            if (customers[i] == null) {
                customers[i] = c;
                inserted = true;
                return inserted;
            }
        }
        return inserted;
    }

    // e) remove customer with given id from reference table
    public Customer removeCustomer(int customer_id) {

        boolean deleted = false;
        Customer c = null;

        for (int i = 0; i < customers.length; i++) {
            if (customers[i].getCustomer_id() == customer_id) {
                c = customers[i];
                customers[i] = null;
                return c;
            }
        }
        return c;
    }

    // f) return reference table with all customers
    public Customer[] getCustomers() {

        Customer[] customers = null;

        int number_customers = countNonNull();
        if (!(number_customers > 0)) {
            return customers;
        }
        customers = new Customer[number_customers];
        int place = 0;
        for (Customer i : this.customers) {
            if (!(i == null)) {
                customers[place++] = i;
            }
        }

        return customers;
    }
}
