package com.camelspringbootproject.apachecamelmicroservicea;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "app-configuration-table")
public class ConfigurationModel {

	@DynamoDBHashKey(attributeName = "SERVICE_GROUP_ID")
	public String serviceGroupId;

	@DynamoDBAttribute(attributeName = "InboundQueueName")
	public String inboundQueueName;

	@DynamoDBAttribute(attributeName = "OutBoundQueueName")
	public String outboundQueueName;

	
	public String getServiceGroupId() { return serviceGroupId; }

	public void setServiceGroupId(String serviceGroupId) { 
		this.serviceGroupId =serviceGroupId; 
	}

	public String getInboundQueueName() { 
		return inboundQueueName;
	}

	public void setInboundQueueName(String inboundQueueName) {
		this.inboundQueueName = inboundQueueName; 
	}

    public String getOutboundQueueName() {
    	return outboundQueueName; 
    }

	public void setOutboundQueueName(String outboundQueueName) {
		 this.outboundQueueName = outboundQueueName; 
	}
	 

}
