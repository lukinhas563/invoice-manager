package org.example.builder;

import org.example.model.invoice.Service;
import org.w3c.dom.Document;


public class ServiceInvoiceBuilder extends Builder{

    public ServiceInvoiceBuilder(Document document) {
        super(document);
    }

    public Service makeServiceInvoice() {
        this.makeInfo().makeSender().makeRecipient();
        return new Service(key, number, competence, series, netValue, sender, recipient, code, description, locationProvision);
    }

}
