package org.gcp.pubsub.receiver.service;

import org.gcp.pubsub.receiver.dto.NotificationWithAttachment;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ReceiverService {

    @ServiceActivator(inputChannel = "stringInputChannel")
	public void messageReceiver(String payload) {
		log.info("Message arrived! Payload: " + payload);
	}

	@ServiceActivator(inputChannel = "pojoInputChannel")
	public void pojoReceiver(NotificationWithAttachment payload) {
		log.info("Pojo arrived! Payload: " + payload);
	} 
}
