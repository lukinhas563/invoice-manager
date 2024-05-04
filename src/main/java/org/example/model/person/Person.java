package org.example.model.person;

import org.example.model.address.Address;

public abstract class Person {
    private String name;
    private String identification;
    private String email;
    private String tel;

    private Address address;

    public Person(
            String name,
            String identification,
            String email,
            String tel,
            Address address
            )
    {
        this.name = name;
        this.identification = identification;
        this.email = email;
        this.tel = tel;
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getIdentification() {
        return identification;
    }

    public String getEmail() {
        return email;
    }

    public String getTel() {
        return tel;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", identification='" + identification + '\'' +
                ", email='" + email + '\'' +
                ", tel='" + tel + '\'' +
                ", address=" + address +
                '}';
    }
}
