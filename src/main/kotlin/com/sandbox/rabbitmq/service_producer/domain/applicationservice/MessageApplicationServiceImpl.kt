package com.sandbox.rabbitmq.service_producer.domain.applicationservice

import com.sandbox.rabbitmq.service_producer.domain.applicationservice.dto.MessageDto
import com.sandbox.rabbitmq.service_producer.domain.applicationservice.port.input.MessageApplicationService
import com.sandbox.rabbitmq.service_producer.domain.applicationservice.port.output.Publisher
import com.sandbox.rabbitmq.service_producer.domain.core.event.MessageEvent
import com.sandbox.rabbitmq.service_producer.domain.core.service.MessageService

class MessageApplicationServiceImpl(
    private val messageService: MessageService,
    private val messagePublisher: Publisher<MessageEvent>
) : MessageApplicationService {
    override fun sendMessage(messageDto: MessageDto) {
        val message = messageDto.toMessage()
        if(messageService.isNotValid(message)) throw Exception("Message is not valid")
        val event = messageService.createMessageEvent(message)

        messagePublisher.publish(event)
    }
}