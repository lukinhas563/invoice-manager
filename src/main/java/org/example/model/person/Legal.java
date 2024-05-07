package org.example.model.person;

import org.example.model.address.Address;

public class Legal extends Person{

    public Legal(String name, String identification, String email, String tel, String tax, Address address) {
        super(name, identification, email, tel, tax,address);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + getName() + '\'' +
                ", identification='" + getIdentification() + '\'' +
                ", tax='" + getTax() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", tel='" + getTel() + '\'' +
                ", address=" + getAddress() +
                '}';
    }
}

