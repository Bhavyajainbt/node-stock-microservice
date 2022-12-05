package com.camelspringbootproject.apachecamelmicroservicea;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQSAsyncClientBuilder;
import com.amazonaws.services.sqs.AmazonSQSClient;

@Configuration
public class AmazonSQSClientBuilder {
	
	
    @Bean(name="sqsOriginalClient")
	AmazonSQSClient getSqsClient() {
		 	
    	AmazonSQSClient client = (AmazonSQSClient)AmazonSQSAsyncClientBuilder.standard().withRegion(Regions.US_EAST_1).build();
        return client;

	}
	
}
