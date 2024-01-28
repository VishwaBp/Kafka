package com.vishwanath.kafka.producer;

import com.vishwanath.kafka.payload.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class kafkaJsonProducer {

    private final KafkaTemplate<String, Student> kafkaTemplate;

    public void publishToTopic(Student student) {
   Message<Student> message = MessageBuilder
                .withPayload(student)
                .setHeader(KafkaHeaders.TOPIC, "vishTopic")
                .build();
        kafkaTemplate.send(message);
    }
}
