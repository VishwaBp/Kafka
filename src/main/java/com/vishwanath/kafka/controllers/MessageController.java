package com.vishwanath.kafka.controllers;

import com.vishwanath.kafka.payload.Student;
import com.vishwanath.kafka.producer.kafkaJsonProducer;
import com.vishwanath.kafka.producer.kafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/messages")
@RequiredArgsConstructor
public class MessageController {

    private final kafkaProducer producer;
    private final kafkaJsonProducer jsonProducer;

    @PostMapping
    public ResponseEntity<String> sendMessage(@RequestBody String message) {
        producer.publishToTopic(message);
        return ResponseEntity.ok("Message Queued Successfully");
    }

    @PostMapping("/json")
    public ResponseEntity<String> sendMessage(@RequestBody Student message) {
        jsonProducer.publishToTopic(message);
        return ResponseEntity.ok("Message Queued Successfully");
    }

}
