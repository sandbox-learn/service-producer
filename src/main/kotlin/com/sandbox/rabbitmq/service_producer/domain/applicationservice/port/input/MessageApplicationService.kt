package com.sandbox.rabbitmq.service_producer.domain.applicationservice.port.input

import com.sandbox.rabbitmq.service_producer.domain.applicationservice.dto.MessageDto

interface MessageApplicationService {
    fun sendMessage(messageDto: MessageDto)
}