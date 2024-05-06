package org.example;

import org.example.factory.DocumentFactory;
import org.example.factory.ServiceInvoiceFactory;
import org.example.model.invoice.Service;
import org.w3c.dom.Document;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        // PATHS
        String path = "C:/Users/cedec/OneDrive/Área de Trabalho/Lucas/nfs/NFS 50.xml";

        String[] paths = new String[3];
        paths[0] = "C:/Users/cedec/OneDrive/Área de Trabalho/Lucas/nfs/NFS 49.xml";
        paths[1] = "C:/Users/cedec/OneDrive/Área de Trabalho/Lucas/nfs/NFS 50.xml";
        paths[2] = "C:/Users/cedec/OneDrive/Área de Trabalho/Lucas/nfs/NFS 51.xml";

        DocumentFactory factory = new DocumentFactory();

        // DOCUMENTS
        Document document = factory.createDocument(path);
        List<Document> documents = factory.createDocument(paths);

        // INVOICE
        ServiceInvoiceFactory invoiceFactory =  new ServiceInvoiceFactory();

        Service serviceInvoice = invoiceFactory.createServiceInvoice(document);
        List<Service> serviceInvoices = invoiceFactory.createServiceInvoice(documents);

    }
}
