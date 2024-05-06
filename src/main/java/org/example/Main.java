package org.example;

import org.example.factory.DocumentFactory;
import org.example.factory.ServiceInvoiceFactory;
import org.example.model.invoice.Service;
import org.w3c.dom.Document;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        // PATHS
        String path = ;

        String[] paths = new String[3];
        paths[0] = ;
        paths[1] = ;
        paths[2] = ;

        DocumentFactory factory = new DocumentFactory();

        // DOCUMENTS
        Document document = factory.createDocument(path);
        List<Document> documents = factory.createDocument(paths);

        // INVOICE
        ServiceInvoiceFactory invoiceFactory =  new ServiceInvoiceFactory();

        Service serviceInvoice = invoiceFactory.createServiceInvoice(document);
        List<Service> serviceInvoices = invoiceFactory.createServiceInvoice(documents);

        try {
            List<Document> documentList = factory.createDocumentByDirectory();

            System.out.println(documentList);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}
