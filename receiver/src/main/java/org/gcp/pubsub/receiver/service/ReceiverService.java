package org.gcp.pubsub.receiver.service;

import org.gcp.pubsub.receiver.dto.WhatsZapEvent;
import org.gcp.pubsub.receiver.dto.DiscordEvent;
import org.gcp.pubsub.receiver.dto.NotificationWithAttachment;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
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

	@ServiceActivator(inputChannel = "filterInputChannelWhatszap")
	public void filterWhatsZapReceiver(Message<WhatsZapEvent> payload) {		
		log.info("Filter whatszap arrived! Payload: " + payload.getPayload());
	}
	
	@ServiceActivator(inputChannel = "filterInputChannelDiscord")
	public void filterDiscordReceiver(Message<DiscordEvent> payload) {		
		log.info("Filter discord arrived! Payload: " + payload.getPayload());
	}

}
