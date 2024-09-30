package com.programtom.elasticsearchapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ElasticsearchRunner implements CommandLineRunner {

    @Autowired
    private ElasticsearchService elasticsearchService;


    @Override
    public void run(String... args) throws Exception {
        String indexName = "sample-index-3";
        String documentId = "1";
        SampleDocument sampleDocument = new SampleDocument(documentId, "This is a test document");

        // Create the index
        elasticsearchService.createIndex(indexName);

        // Index the document
        elasticsearchService.indexDocument(indexName, documentId, sampleDocument);

        // Get the document back
        elasticsearchService.getDocument(indexName, documentId);
    }
}
