package org.gcp.pubsub.receiver.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.cloud.spring.pubsub.support.converter.JacksonPubSubMessageConverter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JacksonPubSubMessageConverterConfig {
    @Bean
    public JacksonPubSubMessageConverter jacksonPubSubMessageConverter(ObjectMapper objectMapper) {
        return new JacksonPubSubMessageConverter(objectMapper);
    }
}