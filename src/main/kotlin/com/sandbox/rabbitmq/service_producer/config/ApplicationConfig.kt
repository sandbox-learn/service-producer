package com.sandbox.rabbitmq.service_producer.config

import com.sandbox.rabbitmq.service_producer.domain.applicationservice.MessageApplicationServiceImpl
import com.sandbox.rabbitmq.service_producer.domain.core.service.MessageService
import com.sandbox.rabbitmq.service_producer.domain.core.service.MessageServiceImpl
import com.sandbox.rabbitmq.service_producer.infrastructure.messaging.MessagePublisher
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ApplicationConfig {

    @Bean
    fun messageService() = MessageServiceImpl()

    @Bean
    fun messageApplicationService(
        messageService: MessageService,
        messagePublisher: MessagePublisher
    ) = MessageApplicationServiceImpl(messageService, messagePublisher)
}