package org.gcp.pubsub.sender.service;


import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway(defaultRequestChannel = "stringOutputChannel")
public interface StringService {
	void publish(String text);	
}
