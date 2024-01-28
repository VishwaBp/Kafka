package com.vishwanath.kafka.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
@Slf4j
public class kafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void publishToTopic(String message) {
        log.info(format("#### -> Producing message -> %s", message));
        kafkaTemplate.send("vishTopic", message);
    }
}
