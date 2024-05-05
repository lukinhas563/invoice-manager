package org.example.builder;


import org.example.model.address.Address;
import org.example.model.person.Individual;
import org.example.model.person.Legal;
import org.example.model.person.Person;
import org.w3c.dom.NodeList;

public interface Builder {

    public Builder makeInfo();
    public Builder makeSender();
    public Builder makeRecipient();

}
