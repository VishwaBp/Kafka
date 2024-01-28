package com.vishwanath.kafka.consumer;

import com.vishwanath.kafka.payload.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
@Slf4j
public class kafkaConsumer {
//    @KafkaListener(topics = "vishTopic", groupId = "myGroup")
    public void consumeMessage(String message) {
        log.info(format("#### -> Consumed message -> %s", message));
    }

    @KafkaListener(topics = "vishTopic", groupId = "myGroup")
    public void consumeJsonMessage(Student message){
        log.info(format("#### -> Consumed message -> %s", message.toString()));
    }

}
