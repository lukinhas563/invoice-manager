package org.example.model.invoice;

import org.example.model.person.Person;

public abstract class Invoice {
   private String key;
   private int number;
   private String competence;
   private String series;

   private double netValue;

   private Person sender;
   private Person recipient;

   public Invoice(String key, int number, String competence, String series, double netValue, Person sender, Person recipient) {
      this.key = key;
      this.number = number;
      this.competence = competence;
      this.series = series;
      this.netValue = netValue;

      this.sender = sender;
      this.recipient = recipient;
   }

   public void setKey(String key) {
      this.key = key;
   }

   public void setNumber(int number) {
      this.number = number;
   }

   public void setCompetence(String competence) {
      this.competence = competence;
   }

   public void setSeries(String series) {
      this.series = series;
   }

   public void setNetValue(Double netValue) {
      this.netValue =netValue;
   }

   public void setSender(Person issuer) {
      this.sender = issuer;
   }

   public void setRecipient(Person recipient) {
      this.recipient = recipient;
   }

   public String getKey() {
      return key;
   }

   public int getNumber() {
      return number;
   }

   public String getCompetence() {
      return competence;
   }

   public String getSeries() {
      return series;
   }

   public Double getNetValue() {
      return netValue;
   }

   public Person getSender() {
      return sender;
   }

   public Person getRecipient() {
      return recipient;
   }

   @Override
   public String toString() {
      return "Invoice{" +
              "key='" + key + '\'' +
              ", number=" + number +
              ", competence='" + competence + '\'' +
              ", series='" + series + '\'' +
              ", netValue=" + netValue +
              ", sender=" + sender +
              ", recipient=" + recipient +
              '}';
   }
}
