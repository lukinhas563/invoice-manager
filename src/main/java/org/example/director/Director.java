package org.example.director;

import org.example.factory.documentFactory.DocumentFactory;
import org.example.factory.documentFactory.DocumentFactoryInterface;
import org.example.factory.serviceFactory.ServiceFactoryInterface;
import org.example.factory.serviceFactory.ServiceInvoiceFactory;
import org.example.model.invoice.Service;
import org.w3c.dom.Document;

import java.util.ArrayList;
import java.util.List;

public class Director {

    // Factories
    private DocumentFactoryInterface documentFactory;
    private ServiceFactoryInterface serviceInvoiceFactory;

    // Lists
    private List<Document> documentList = new ArrayList<>();
    private List<Service> serviceList = new ArrayList<>();

    public Director(DocumentFactoryInterface documentFactory, ServiceFactoryInterface serviceInvoiceFactory) {
        this.documentFactory = documentFactory;
        this.serviceInvoiceFactory = serviceInvoiceFactory;
    }

    public void createDocumentByDirectory(String url) {

        try {

            List<Document> documents = documentFactory.createDocumentByDirectory(url);

            documentList.addAll(documents);

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    public void createDocument(String url) {

        try {

            Document document = documentFactory.createDocument(url);

            documentList.add(document);

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    public void createDocument(String[] url) {

        try {

            List<Document> documents = documentFactory.createDocument(url);

            documentList.addAll(documents);

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    public void createServiceInvoice() {
      List<Service> invoices = serviceInvoiceFactory.createServiceInvoice(documentList);

      serviceList.addAll(invoices);
    }

    public void createServiceInvoice(Document document) {
        Service service = serviceInvoiceFactory.createServiceInvoice(document);

        serviceList.add(service);
    }

    public void createServiceInvoice(List<Document> documents) {
        List<Service> services = serviceInvoiceFactory.createServiceInvoice(documents);

        serviceList.addAll(services);
    }

    public List<Service> getServiceInvoice() {
        return serviceList;
    }

    public Service getServiceInvoice(int index) {
        return serviceList.get(index);
    }

    public double getTotalValue() {

        double totalValue = 0;

        for (Service service : serviceList) {
            totalValue = totalValue + service.getNetValue();
        }

        return totalValue;
    }

}
