package com.camelspringbootproject.apachecamelmicroservicea;

import javax.annotation.Resource;

import org.apache.camel.builder.RouteBuilder;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

@Component
public class SQSRouteBuilder extends RouteBuilder {
	
	@Resource(name="DynamoDBMapper")
	DynamoDBMapper dbMapper;
	
	@Autowired
	TransformMessage transformer;
	
	private String AWS_SQS_SCHEME = "aws-sqs";
	
	public ConfigurationModel getServiceGroupDetails(String serviceGroup) {
		return dbMapper.load(ConfigurationModel.class, serviceGroup);
		 
	}
	
	// New Code Implementation starts//
	public String buildSQSExtendedConsumer(String sqsName) {
		
		URIBuilder builder = getSQSBaseURIBuilder(sqsName);
		builder.setParameter("amazonSQSClient", "#sqsOriginalClient");
		return builder.toString();
	}
	
	public URIBuilder getSQSBaseURIBuilder(String sqsName) {
		URIBuilder builder = new URIBuilder();
		builder.setScheme(AWS_SQS_SCHEME);
		builder.setHost(sqsName);
		return builder;
	}
	// New Code Implementation Over//
	
	@Override
	public void configure() throws Exception {
		
		ConfigurationModel model = getServiceGroupDetails("SG-IN-09");
		from(buildSQSExtendedConsumer(model.getInboundQueueName())+"&messageGroupIdStrategy=useExchangeId")
		.log("${body}")
		.bean(transformer)
		.log("${body}")
		.to(buildSQSExtendedConsumer(model.getOutboundQueueName())+"&messageGroupIdStrategy=useExchangeId");
	}
}
