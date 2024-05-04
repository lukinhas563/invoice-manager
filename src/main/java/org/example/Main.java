package org.example;

import org.example.builder.ServiceInvoiceBuilder;
import org.example.model.invoice.Service;
import org.example.util.CreateDocument;
import org.w3c.dom.Document;

public class Main {
    public static void main(String[] args) {

        CreateDocument creater = new CreateDocument();
        // creater.setDocument();

        Document document = creater.getDocument();

        ServiceInvoiceBuilder serviceInvoiceBuilder = new ServiceInvoiceBuilder(document);

        Service invoice = serviceInvoiceBuilder.makeServiceInvoice();

        System.out.println(invoice);

    }
}
