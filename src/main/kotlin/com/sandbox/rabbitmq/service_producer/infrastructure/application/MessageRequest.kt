package com.sandbox.rabbitmq.service_producer.infrastructure.application

import com.sandbox.rabbitmq.service_producer.domain.applicationservice.dto.MessageDto

data class MessageRequest(val value: String){
    fun toMessageDto() = MessageDto(value = value)
}