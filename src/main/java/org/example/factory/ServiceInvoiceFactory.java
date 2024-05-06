package org.example.factory;

import org.example.builder.ServiceInvoiceBuilder;
import org.example.model.invoice.Service;
import org.w3c.dom.Document;

import java.util.ArrayList;
import java.util.List;

public class ServiceInvoiceFactory {

    public Service createServiceInvoice(Document document) {
       ServiceInvoiceBuilder builder = new ServiceInvoiceBuilder(document);

       return builder.makeInfo().makeSender().makeRecipient().makeServiceInvoice();
    }

    public List<Service> createServiceInvoice(List<Document> documents) {
        List<Service> serviceList = new ArrayList<>();

        for (int i = 0; i < documents.size(); i++) {
          ServiceInvoiceBuilder builder = new ServiceInvoiceBuilder(documents.get(i));

           serviceList.add(builder.makeInfo().makeSender().makeRecipient().makeServiceInvoice());
        }

        return serviceList;
    }
}
