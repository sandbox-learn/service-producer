package com.sandbox.rabbitmq.service_producer.config

import org.springframework.amqp.core.FanoutExchange
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class MessagingConfig {
    @Bean
    fun fanout(): FanoutExchange {
        return FanoutExchange("sandbox.fanout")
    }
}