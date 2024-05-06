package org.example.factory.serviceFactory;

import org.example.model.invoice.Service;
import org.w3c.dom.Document;

import java.util.List;

public interface ServiceFactoryInterface {
    public Service createServiceInvoice(Document document);
    public List<Service> createServiceInvoice(List<Document> documents);
}
