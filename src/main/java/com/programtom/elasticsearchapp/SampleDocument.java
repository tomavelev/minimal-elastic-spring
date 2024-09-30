package com.programtom.elasticsearchapp;

public class SampleDocument {

    private String id;
    private String message;

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
