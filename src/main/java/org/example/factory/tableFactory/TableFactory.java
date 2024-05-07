package org.example.factory.tableFactory;

import com.opencsv.CSVWriter;
import org.example.model.invoice.Service;
import org.example.model.person.Person;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TableFactory {

    private static final String CSV_PATH = "./src/main/resources/generatedCsv.csv";

    public void create(List<Service> invoices) {

        try (CSVWriter csvWriter = new CSVWriter(new FileWriter(new File(CSV_PATH)))) {
            System.out.println("Starting CSV generation");

            String[] headersTop = {"", "", "", "", "", "", "", "", "sender", "", "", "", "", "address", "", "", "recipient", "", "", "", "", "address", "", "",};
            String[] headersMain = {"key", "number", "competence", "series", "value", "locationProvision", "code", "description", "name", "identification", "tax", "email", "tel", "address", "city", "zipCode", "name", "identification", "tax", "email", "tel", "address", "city", "zipCode"};
            List<String[]> data = new ArrayList<>();

            data.add(headersTop);
            data.add(headersMain);
            this.createLine(invoices, data);

            csvWriter.writeAll(data);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("File writing finished");
        }

    }

    private void createLine(List<Service> invoices, List<String[]> data) {
        for (Service invoice : invoices) {
            Person sender = invoice.getSender();
            Person recipient = invoice.getRecipient();

            String[] item = {invoice.getKey(), Integer.toString(invoice.getNumber()), invoice.getCompetence().toString(), invoice.getSeries(), Double.toString(invoice.getNetValue()), invoice.getLocationProvision(), invoice.getCode(), invoice.getDescription(), sender.getName(), sender.getIdentification(), sender.getTax(), sender.getEmail(), sender.getTel(), sender.getAddress().getAddress(), sender.getAddress().getCity(), sender.getAddress().getZipCode(), recipient.getName(), recipient.getIdentification(), recipient.getTax(), recipient.getEmail(), recipient.getTel(), recipient.getAddress().getAddress(), recipient.getAddress().getCity(), recipient.getAddress().getZipCode()};
            data.add(item);
        }
    }
}
