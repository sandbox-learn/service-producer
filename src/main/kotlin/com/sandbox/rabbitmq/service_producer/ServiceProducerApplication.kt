package com.sandbox.rabbitmq.service_producer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ServiceProducerApplication

fun main(args: Array<String>) {
	runApplication<ServiceProducerApplication>(*args)
}
