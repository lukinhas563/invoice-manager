package org.example.util;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CreateDocument {

    Document document;

    public boolean setDocument(String path) {
        Path file = Paths.get(path);

        if (!Files.exists(file) && !path.toLowerCase().endsWith(".xml")) {
            return false;
        }

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(false);

        try {

            DocumentBuilder documentBuilder = factory.newDocumentBuilder();

            this.document = documentBuilder.parse(new File(path));

            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public Document getDocument() {
        return document;
    }
}
