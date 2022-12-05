package com.camelspringbootproject.apachecamelmicroservicea;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

@Configuration
public class DynamoDBConfiguration {

	@Bean(name="DynamoDBMapper")
	DynamoDBMapper dbMapper() {
		
		AmazonDynamoDBClient client = (AmazonDynamoDBClient)AmazonDynamoDBClientBuilder.standard().withRegion(Regions.US_EAST_1).build();
		
		return new DynamoDBMapper(client);
	}
	
	
}
