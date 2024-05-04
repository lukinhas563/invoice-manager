package org.example.model.person;

import org.example.model.address.Address;

public class Legal extends Person{

    private String tax;

    public Legal(String name, String identification, String email, String tel, String tax, Address address) {
        super(name, identification, email, tel, address);

        this.tax = tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public String getTax() {
        return tax;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + getName() + '\'' +
                ", identification='" + getIdentification() + '\'' +
                ", tax='" + tax + '\'' +
                ", email='" + getEmail() + '\'' +
                ", tel='" + getTel() + '\'' +
                ", address=" + getAddress() +
                '}';
    }
}

