package org.example.factory.documentFactory;

import org.w3c.dom.Document;

import java.io.FileNotFoundException;
import java.util.List;

public interface DocumentFactoryInterface {

    public List<Document> createDocument(String[] paths);
    public Document createDocument(String path);
    public List<Document> createDocumentByDirectory(String url) throws FileNotFoundException;
}
