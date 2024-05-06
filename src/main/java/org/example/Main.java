package org.example;

import org.example.factory.DocumentFactory;
import org.w3c.dom.Document;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        // PATHS
        String path = ;

        String[] paths = new String[3];
        paths[0] = ;
        paths[1] = ;
        paths[2] = ;

        DocumentFactory factory = new DocumentFactory();

        // DOCUMENTS
        Document document = factory.createDocument(path);
        List<Document> documents = factory.createDocument(paths);


    }
}
