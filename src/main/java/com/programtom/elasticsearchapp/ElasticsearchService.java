package com.programtom.elasticsearchapp;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.ElasticsearchException;
import co.elastic.clients.elasticsearch.core.GetResponse;
import co.elastic.clients.elasticsearch.core.IndexResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ElasticsearchService {

    @Autowired
    private ElasticsearchClient elasticsearchClient;

    public void createIndex(String indexName) throws IOException {
        // Check if the index already exists
        boolean exists = elasticsearchClient.indices().exists(e -> e.index(indexName)).value();
        if (!exists) {
            // Create index if it doesn't exist
            elasticsearchClient.indices().create(c -> c.index(indexName));
            System.out.println("Index created: " + indexName);
        } else {
            System.out.println("Index already exists: " + indexName);
        }
    }

    public void indexDocument(String indexName, String id, SampleDocument document) throws IOException {
        IndexResponse response = elasticsearchClient.index(indexRequest -> indexRequest
                .index(indexName)
                .id(id)
                .document(document)
        );

        System.out.println("Indexed document ID: " + response.id());
    }

    public SampleDocument getDocument(String indexName, String id) throws IOException, ElasticsearchException {
        GetResponse<SampleDocument> response = elasticsearchClient.get(g -> g
                .index(indexName)
                .id(id), SampleDocument.class);

        if (response.found()) {
            System.out.println("Document found: " + response.source());
            return response.source();
        } else {
            System.out.println("Document not found with ID: " + id);
            return null;
        }
    }
}
