package com.sandbox.rabbitmq.service_producer.infrastructure.application

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/produce")
class MessageController(
    private val messageAdapter: MessageAdapter
) {

    @PostMapping
    fun produce(@RequestBody message: MessageRequest = MessageRequest("Hello World!")) : ResponseEntity<MessageResponse> {
        return try {
            ResponseEntity.ok(messageAdapter.send(message))
        } catch (e : Exception){
            ResponseEntity.badRequest()
                .body(MessageResponse("Error : ${e.message}"))
        }
    }
}