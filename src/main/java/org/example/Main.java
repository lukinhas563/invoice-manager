package org.example;

import org.example.director.Director;
import org.example.factory.documentFactory.DocumentFactory;
import org.example.factory.serviceFactory.ServiceInvoiceFactory;
import org.example.factory.tableFactory.TableFactory;
import org.example.model.invoice.Service;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        String url = "C:/Users/cedec/OneDrive/Área de Trabalho/Lucas/nfs";
        Director director = new Director(new DocumentFactory(), new ServiceInvoiceFactory());

        director.createDocumentByDirectory(url);

        director.createServiceInvoice();

        List<Service> services = director.getServiceInvoice();

        new TableFactory().create(services);

    }
}
