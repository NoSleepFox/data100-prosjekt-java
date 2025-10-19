package no.hvl.dat100.javel.oppgave3;

public class Customer {

    private String name;
    private String email;
    private int customer_id;
    private PowerAgreementType agreement;

    public Customer(String name, String email, int customer_id, PowerAgreementType agreement) {
        this.name = name;
        this.email = email;
        this.customer_id = customer_id;
        this.agreement = agreement;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public PowerAgreementType getAgreement() {
        return agreement;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public void setAgreement(PowerAgreementType agreement) {
        this.agreement = agreement;
    }

    public void valuesToString() {
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Customer number: " + customer_id);
        System.out.println("Agreement: " + agreement);
    }
}
