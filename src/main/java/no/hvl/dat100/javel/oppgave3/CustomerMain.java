package no.hvl.dat100.javel.oppgave3;

public class CustomerMain {

    public static void main(String[] args) {

        System.out.println("==============");
        System.out.println("OPPGAVE 3");
        System.out.println("==============");
        System.out.println();

        Customer customer = new Customer("James", "james.smith@gmail.com", 15, PowerAgreementType.NORGESPRICE);

        System.out.println(customer.getName());
        System.out.println(customer.getEmail());
        System.out.println(customer.getCustomer_id());
        System.out.println(customer.getAgreement());

        customer.setName("Bob");
        customer.setEmail("bob.jamerson@gmail.com");
        customer.setCustomer_id(16);
        customer.setAgreement(PowerAgreementType.SPOTPRICE);

        customer.valuesToString();
    }
}
