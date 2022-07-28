package com.mpr.backend.global;

import com.mongodb.*;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.net.ssl.SSLContext;
import java.security.NoSuchAlgorithmException;

@Configuration
@PropertySource("classpath:application.yml")
public class MongoConfig {
    @Value("${spring.data.mongodb.port}")
    private int port;
    @Value("${spring.data.mongodb.host}")
    private String host;
    @Value("${spring.data.mongodb.database}")
    private String database;
    @Value("${spring.data.mongodb.username}")
    private String username;
    @Value("${spring.data.mongodb.password}")
    private String password;
    @Value("${spring.data.mongodb.uri}")
    private String uri;
    @Value("${spring.data.mongodb.trustStore}")
    private String trustStore;

    @Bean
    public MongoClient mongoClient() throws NoSuchAlgorithmException {
        ConnectionString connectionString = new ConnectionString(uri);

        System.setProperty("javax.net.ssl.trustStore", trustStore);
        System.setProperty("javax.net.ssl.trustStorePassword", password);

        MongoClientSettings settings = MongoClientSettings.builder()
                .applyToSslSettings(builder -> {
                    builder.enabled(true);
                    builder.invalidHostNameAllowed(true);
                })
                .applyConnectionString(connectionString)
                .build();

        return MongoClients.create(settings);
    }

    @Bean
    public  MongoDatabase mongoDatabase() throws NoSuchAlgorithmException {
        return mongoClient().getDatabase(this.database);
    }
}