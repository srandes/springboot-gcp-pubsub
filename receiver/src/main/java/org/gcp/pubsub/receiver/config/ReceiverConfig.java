package org.gcp.pubsub.receiver.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.cloud.spring.pubsub.core.PubSubTemplate;
import com.google.cloud.spring.pubsub.integration.AckMode;
import com.google.cloud.spring.pubsub.integration.inbound.PubSubInboundChannelAdapter;
import com.google.cloud.spring.pubsub.support.converter.JacksonPubSubMessageConverter;

import org.gcp.pubsub.receiver.dto.WhatsZapEvent;
import org.gcp.pubsub.receiver.dto.DiscordEvent;
import org.gcp.pubsub.receiver.dto.NotificationWithAttachment;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.messaging.MessageChannel;

@Configuration
public class ReceiverConfig {

	private static final String STRING_SUBSCRIPTION = "test-string-topic-sub";
	private static final String POJO_SUBSCRIPTION = "test-pojo-topic-sub";
	private static final String FILTER_SUBSCRIPTION_WHATSZAP = "test-filter-topic-whatszap-sub";	
	private static final String FILTER_SUBSCRIPTION_DISCORD = "test-filter-topic-discord-sub";


	@Bean
	public MessageChannel pojoInputChannel() {
		return new PublishSubscribeChannel();
	}    

    @Bean
	public PubSubInboundChannelAdapter pojoChannelAdapter(
			@Qualifier("pojoInputChannel") MessageChannel messageChannel,
			PubSubTemplate pubSubTemplate,
            ObjectMapper objectMapper)
	{
        pubSubTemplate.setMessageConverter(new JacksonPubSubMessageConverter(objectMapper));        
		PubSubInboundChannelAdapter adapter = new PubSubInboundChannelAdapter(pubSubTemplate, POJO_SUBSCRIPTION);
		adapter.setOutputChannel(messageChannel);
        adapter.setAckMode(AckMode.AUTO_ACK);
        adapter.setPayloadType(NotificationWithAttachment.class);
        return adapter;
	} 


	



	@Bean
	public MessageChannel stringInputChannel() {
		return new PublishSubscribeChannel();
	}

	@Bean
	public PubSubInboundChannelAdapter stringChannelAdapter(
			@Qualifier("stringInputChannel") MessageChannel messageChannel,
			PubSubTemplate pubSubTemplate)
	{
		PubSubInboundChannelAdapter adapter = new PubSubInboundChannelAdapter(pubSubTemplate, STRING_SUBSCRIPTION);
		adapter.setOutputChannel(messageChannel);
		adapter.setAckMode(AckMode.AUTO_ACK);
        adapter.setPayloadType(String.class);
		return adapter;
	}






	@Bean
	public MessageChannel filterInputChannelWhatszap() {
		return new PublishSubscribeChannel();
	}


	@Bean
	public PubSubInboundChannelAdapter filterChannelAdapterWhatszap(
			@Qualifier("filterInputChannelWhatszap") MessageChannel messageChannel,
			PubSubTemplate pubSubTemplate,
			ObjectMapper objectMapper)
	{
		pubSubTemplate.setMessageConverter(new JacksonPubSubMessageConverter(objectMapper)); 
		PubSubInboundChannelAdapter adapter = new PubSubInboundChannelAdapter(pubSubTemplate, FILTER_SUBSCRIPTION_WHATSZAP);
		adapter.setOutputChannel(messageChannel);
		adapter.setAckMode(AckMode.AUTO_ACK);
        adapter.setPayloadType(WhatsZapEvent.class);
		return adapter;
	}



	@Bean
	public MessageChannel filterInputChannelDiscord() {
		return new PublishSubscribeChannel();
	}

	@Bean
	public PubSubInboundChannelAdapter filterChannelAdapterDiscord(
			@Qualifier("filterInputChannelDiscord") MessageChannel messageChannel,
			PubSubTemplate pubSubTemplate,
			ObjectMapper objectMapper)
	{
		pubSubTemplate.setMessageConverter(new JacksonPubSubMessageConverter(objectMapper)); 
		PubSubInboundChannelAdapter adapter = new PubSubInboundChannelAdapter(pubSubTemplate, FILTER_SUBSCRIPTION_DISCORD);
		adapter.setOutputChannel(messageChannel);
		adapter.setAckMode(AckMode.AUTO_ACK);
        adapter.setPayloadType(DiscordEvent.class);
		return adapter;
	}	
}
