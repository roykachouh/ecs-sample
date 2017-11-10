package com.kachouh.ecs.sample;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.services.ecs.AmazonECS;
import com.amazonaws.services.ecs.AmazonECSClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EcsClientWiring {

    @Bean
    AmazonECS amazonECS(@Value(("${accessKey}")) String accessKey, @Value("${secretKey}") String secretKey) {
        AmazonECSClientBuilder clientBuilder = AmazonECSClientBuilder.standard();

        clientBuilder.setCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(accessKey, secretKey)));

        return clientBuilder.build();
    }
}
