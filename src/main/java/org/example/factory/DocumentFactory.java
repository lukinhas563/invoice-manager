package org.example.factory;

import org.example.util.CreateDocument;
import org.w3c.dom.Document;

import java.util.ArrayList;
import java.util.List;

public class DocumentFactory implements Factory {

    public List<Document> createDocument(String[] paths) {
        List<Document> documents = new ArrayList<>();
        CreateDocument create = new CreateDocument();

        for (int i = 0; i < paths.length; i++) {

            try {
                create.setDocument(paths[i]);

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
}
