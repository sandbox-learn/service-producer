package com.sandbox.rabbitmq.service_producer.domain.core.service

import com.sandbox.rabbitmq.service_producer.domain.core.entity.Message
import com.sandbox.rabbitmq.service_producer.domain.core.event.MessageEvent

interface MessageService {
    fun isValid(message : Message) : Boolean
    fun isNotValid(message : Message) : Boolean
    fun createMessageEvent(message : Message) : MessageEvent
}