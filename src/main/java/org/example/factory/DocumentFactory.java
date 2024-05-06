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
           create.setDocument(paths[i]);

            documents.add(create.getDocument());
        }

        return documents;
    }

    public Document createDocument(String path) {
        CreateDocument create = new CreateDocument();
        create.setDocument(path);

        return create.getDocument();
    }
}
