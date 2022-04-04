package org.gcp.pubsub.sender.config;

import com.google.cloud.spring.pubsub.core.PubSubTemplate;
import com.google.cloud.spring.pubsub.integration.outbound.PubSubMessageHandler;
import com.google.cloud.spring.pubsub.support.converter.JacksonPubSubMessageConverter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.MessageHandler;

@Configuration
public class SenderConfig {

    private static final String STRING_TOPIC = "test-string-topic";
    private static final String POJO_TOPIC = "test-pojo-topic";

    @Bean
	@ServiceActivator(inputChannel = "stringOutputChannel")
	public MessageHandler messageSender(PubSubTemplate pubsubTemplate) {
		return new PubSubMessageHandler(pubsubTemplate, STRING_TOPIC);
	} 	
	
    @Bean
    @ServiceActivator(inputChannel = "pojoOutputChannel")
    public PubSubMessageHandler pojoSender(
            PubSubTemplate pubSubTemplate,
            JacksonPubSubMessageConverter jacksonPubSubMessageConverter
    ) {
        pubSubTemplate.setMessageConverter(jacksonPubSubMessageConverter);
        return new PubSubMessageHandler(pubSubTemplate, POJO_TOPIC);
    }
}
