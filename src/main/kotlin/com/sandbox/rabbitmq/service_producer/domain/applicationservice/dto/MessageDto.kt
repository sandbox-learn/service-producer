package com.sandbox.rabbitmq.service_producer.domain.applicationservice.dto

import com.sandbox.rabbitmq.service_producer.domain.core.entity.Message

data class MessageDto(val value: String){
    fun toMessage() = Message(value = value)
}
