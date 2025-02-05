package com.sandbox.rabbitmq.service_producer.infrastructure.messaging

import com.sandbox.rabbitmq.service_producer.domain.applicationservice.port.output.Publisher
import com.sandbox.rabbitmq.service_producer.domain.core.event.MessageEvent
import org.springframework.amqp.core.FanoutExchange
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.stereotype.Component

@Component
class MessagePublisher(
    private val template: RabbitTemplate,
    private val fanout: FanoutExchange,
) : Publisher<MessageEvent> {
    override fun publish(event: MessageEvent) {
        println("Publishing event: $event")
        send(event)
    }

    private fun send(event: MessageEvent) {
        template.convertAndSend(fanout.name, "", event)
        println(" [x] Sent '$event'")
    }

    private fun send(message: String) {
        template.convertAndSend(fanout.name, "", message)
        println(" [x] Sent '$message'")
    }
}