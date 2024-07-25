package com.sandbox.rabbitmq.service_producer.domain.core.service

import com.sandbox.rabbitmq.service_producer.domain.core.entity.Message
import com.sandbox.rabbitmq.service_producer.domain.core.event.MessageEvent

class MessageServiceImpl : MessageService {
    override fun isValid(message: Message) = message.value.length > 3
    override fun isNotValid(message: Message) = !this.isValid(message)
    override fun createMessageEvent(message: Message): MessageEvent = MessageEvent(message)
}