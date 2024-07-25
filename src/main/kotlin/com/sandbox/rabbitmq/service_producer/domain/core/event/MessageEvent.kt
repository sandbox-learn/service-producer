package com.sandbox.rabbitmq.service_producer.domain.core.event

import com.sandbox.rabbitmq.service_producer.domain.core.entity.Message
import java.time.LocalDateTime

data class MessageEvent(
    val message: Message,
    val createdAt: LocalDateTime = LocalDateTime.now(),
)
