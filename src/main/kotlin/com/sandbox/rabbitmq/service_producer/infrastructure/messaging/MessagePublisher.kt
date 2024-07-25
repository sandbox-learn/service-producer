package com.sandbox.rabbitmq.service_producer.infrastructure.messaging

import com.sandbox.rabbitmq.service_producer.domain.applicationservice.port.output.Publisher
import com.sandbox.rabbitmq.service_producer.domain.core.event.MessageEvent
import org.springframework.stereotype.Component

@Component
class MessagePublisher : Publisher<MessageEvent> {
    override fun publish(event: MessageEvent) {
        println("Publishing event: $event")
    }
}