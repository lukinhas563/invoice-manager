package org.example.model.invoice;

import org.example.model.person.Person;

public class Service extends Invoice{

    private String code;
    private String description;
    private String locationProvision;

    public Service(String key, int number, String competence, String series, Double netValue ,Person sender, Person recipient, String code, String description, String locationProvision) {
        super(key, number, competence, series, netValue, sender, recipient);

        this.code = code;
        this.description = description;
        this.locationProvision = locationProvision;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLocationProvision(String locationProvision) {
        this.locationProvision = locationProvision;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public String getLocationProvision() {
        return locationProvision;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "key='" + getKey() + '\'' +
                ", number=" + getNumber() +
                ", competence='" + getCompetence() + '\'' +
                ", series='" + getSeries() + '\'' +
                ", code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", locationProvision='" + locationProvision + '\'' +
                ", netValue=" + getNetValue() +
                ", sender=" + getSender() +
                ", recipient=" + getRecipient() +
                '}';
    }
}
