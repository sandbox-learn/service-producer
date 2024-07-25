package com.sandbox.rabbitmq.service_producer.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.springframework.amqp.core.FanoutExchange
import org.springframework.amqp.rabbit.connection.ConnectionFactory
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class MessagingConfig {
    @Bean
    fun fanout(): FanoutExchange {
        return FanoutExchange("sandbox.fanout")
    }

    @Bean
    fun jackson2JsonMessageConverter(): Jackson2JsonMessageConverter {
        val objectMapper = ObjectMapper()
            .registerModule(KotlinModule.Builder().build())
            .registerModule(JavaTimeModule())
        return Jackson2JsonMessageConverter(objectMapper)
    }

    @Bean
    fun rabbitTemplate(connectionFactory: ConnectionFactory, converter: Jackson2JsonMessageConverter): RabbitTemplate {
        val rabbitTemplate = RabbitTemplate(connectionFactory)
        rabbitTemplate.messageConverter = converter
        return rabbitTemplate
    }
}