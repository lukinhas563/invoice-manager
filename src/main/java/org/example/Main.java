package org.example;

import org.example.director.Director;
import org.example.factory.documentFactory.DocumentFactory;
import org.example.factory.serviceFactory.ServiceInvoiceFactory;
import org.example.model.invoice.Service;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        String url = "C:/Users/cedec/OneDrive/Área de Trabalho/Lucas/nfs";
        Director director = new Director(new DocumentFactory(), new ServiceInvoiceFactory());

        // CREATE THE DOCUMENT BY DIRECTORY
        director.createDocumentByDirectory(url);

        // CREATE THE SERVICE INVOICE
        director.createServiceInvoice();

        // GET THE RESULTS
        List<Service> invoices = director.getServiceInvoice();

        for (Service invoice : invoices) {
            System.out.println("------------------------------------------------");
            System.out.println(invoice);
        }

        System.out.println("Total: " + director.getTotalValue());

    }
}
