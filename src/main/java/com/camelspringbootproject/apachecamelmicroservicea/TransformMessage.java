package com.camelspringbootproject.apachecamelmicroservicea;

import org.json.JSONObject;
import org.json.XML;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;


@Component
public class TransformMessage {
	
	public String transformer(String message) throws Exception {
		
		ObjectMapper mapper = new ObjectMapper();
		StockDetails details;
		
		try {
			details = mapper.readValue(message, StockDetails.class);		
		}
		catch(Exception e) {
			throw e;
		}
		
		// Message details tranformation
		details.Location = "Mumbai";
		String tempJsonString = mapper.writeValueAsString(details);
		
		JSONObject jsonObject = new JSONObject(tempJsonString);
		
		return XML.toString(jsonObject);
	}
}
