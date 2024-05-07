package org.example.model.person;

import org.example.model.address.Address;

public class Individual extends Person {

    public Individual(String name, String email, String tel, String identification, Address address){
        super(name, identification, email, tel, "", address);
    }

}
