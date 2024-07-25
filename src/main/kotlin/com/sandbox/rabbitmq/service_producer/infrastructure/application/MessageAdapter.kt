package com.sandbox.rabbitmq.service_producer.infrastructure.application

import com.sandbox.rabbitmq.service_producer.domain.applicationservice.port.input.MessageApplicationService
import org.springframework.stereotype.Component

@Component
class MessageAdapter(
    private val messageApplicationService: MessageApplicationService
){
    fun send(messageRequest: MessageRequest) : MessageResponse {
        messageApplicationService.sendMessage(messageRequest.toMessageDto())

        return MessageResponse("Message [${messageRequest.value}] was sent !")
    }
}