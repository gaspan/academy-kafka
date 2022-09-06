package com.dans.academy.academykafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping("/kafka/produce")
    public String produce(@RequestBody String message) {
        kafkaTemplate.send("topic-kafka", message);
        return "done";
    }
}
