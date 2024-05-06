package org.example.util;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CreateDocument {

    Document document;

    public void setDocument(String path) throws FileNotFoundException {
        Path file = Paths.get(path);

        if (!Files.exists(file)) {
            throw new FileNotFoundException("File not found: " + path);
        }

        if (!path.toLowerCase().endsWith(".xml")) {
            throw new IllegalArgumentException("The file doesn't have an .xml extension: " + path);
        }

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(false);

        try {

            DocumentBuilder documentBuilder = factory.newDocumentBuilder();

            this.document = documentBuilder.parse(new File(path));

        } catch (Exception e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }

    }

    public Document getDocument() {
        return document;
    }
}
