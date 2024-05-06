package org.example;

import org.example.factory.DocumentFactory;
import org.example.factory.ServiceInvoiceFactory;
import org.example.model.invoice.Service;
import org.w3c.dom.Document;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        // PATHS
        DocumentFactory factory = new DocumentFactory();

        try {
            List<Document> documents = factory.createDocumentByDirectory();

            // INVOICE
            ServiceInvoiceFactory invoiceFactory =  new ServiceInvoiceFactory();
            List<Service> serviceInvoices = invoiceFactory.createServiceInvoice(documents);

            for (Service invoices : serviceInvoices) {
                System.out.println(invoices);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }







    }
}
