package org.example.factory.documentFactory;

import org.example.util.CreateDocument;
import org.w3c.dom.Document;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DocumentFactory implements DocumentFactoryInterface {

    public List<Document> createDocument(String[] paths) {
        List<Document> documents = new ArrayList<>();
        CreateDocument create = new CreateDocument();

        for (String path : paths) {

            try {
                create.setDocument(path);

                documents.add(create.getDocument());
            } catch (Exception e) {
                throw new RuntimeException("Error: " + e.getMessage());
            }

        }

        return documents;
    }

    public Document createDocument(String path) {
        CreateDocument create = new CreateDocument();

        try {
            create.setDocument(path);
        } catch (Exception e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }

        return create.getDocument();
    }

    public List<Document> createDocumentByDirectory(String url) throws FileNotFoundException {
        Path path = Paths.get(url);

        if (!Files.isDirectory(path)) {
            throw new FileNotFoundException("Directory not found: " + url);
        }

        File directory = new File(url);
        File[] files = directory.listFiles();

        if (files.length == 0) {
            throw new FileNotFoundException("Files not found: " + url);
        }

        List<Document> documents = new ArrayList<>();

        for (File file : files) {
            String filePath = file.toString();

            if (filePath.toLowerCase().endsWith(".xml")) {
                documents.add(this.createDocument(filePath));
            }

        }

        return documents;
    }

}
