package com.mnr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.MessageChannel;

@Configuration
public class SpringIntegrationConfig {
    @Bean("remoteRequest")
    public MessageChannel remoteRequest(){
        return new DirectChannel();
    }
}
