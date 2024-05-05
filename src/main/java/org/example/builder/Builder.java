package org.example.builder;

import org.example.model.person.Person;
import org.w3c.dom.Document;

public abstract class Builder {

    protected final Document document;

    protected String key;
    protected int number;
    protected String competence;
    protected String series;
    protected String code;
    protected String description;
    protected String locationProvision;

    protected double netValue;

    protected Person sender;
    protected Person recipient;

    public Builder(Document document) {
        this.document = document;
    }

}
