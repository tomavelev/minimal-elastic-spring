package com.programtom.elasticsearchapp;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ElasticsearchConfig {

    @Value("${elastic.host}")
    String host;

    @Value("${elastic.port}")
    int port;

    @Value("${elastic.scheme}")
    String scheme;


    @Bean
    public ElasticsearchClient elasticsearchClient() {
        RestClient restClient = RestClient.builder(
                new HttpHost(host, port, scheme)).build();

        // Create the transport with a Jackson mapper
        RestClientTransport transport = new RestClientTransport(
                restClient, new JacksonJsonpMapper());

        // Create the Elasticsearch client
        return new ElasticsearchClient(transport);
    }
}
