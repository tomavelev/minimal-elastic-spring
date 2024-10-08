package com.programtom.elasticsearchapp;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "users")
public class SampleDocument {
    @Id
    private String id;
    @Field(name = "name", type = FieldType.Text, analyzer = "english")
    private String message;

    @SuppressWarnings("unused")
    public SampleDocument() {

    }

    public SampleDocument(String id, String message) {
        this.id = id;
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "SampleDocument{" +
               "id='" + id + '\'' +
               ", message='" + message + '\'' +
               '}';
    }
}
