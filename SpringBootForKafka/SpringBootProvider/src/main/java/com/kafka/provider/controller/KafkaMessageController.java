package com.kafka.provider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaMessageController {
    private final KafkaTemplate<String,String> kafkaTemplate;

    @Autowired
    public KafkaMessageController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping("/send")
    public String sendMessage(@RequestParam("topic") String topic, @RequestBody String message) {
        kafkaTemplate.send(topic, message);
        return "Message sent to topic " + topic;
    }
}
