package org.gcp.pubsub.sender.service;

import org.gcp.pubsub.sender.dto.NotificationWithAttachment;
import org.springframework.integration.annotation.MessagingGateway;


@MessagingGateway(defaultRequestChannel = "pojoOutputChannel")
public interface PojoService {	
	void publish(NotificationWithAttachment notification);
}
