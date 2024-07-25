package com.sandbox.rabbitmq.service_producer.domain.applicationservice.port.output

interface Publisher<T> {
    fun publish(event: T)
}