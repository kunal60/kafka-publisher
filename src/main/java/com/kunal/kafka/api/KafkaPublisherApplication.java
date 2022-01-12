package com.kunal.kafka.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class KafkaPublisherApplication {

    @Autowired
    private KafkaTemplate<String, Object> template;

    private String topic = "TravelSeries";

    @GetMapping("/publish/{name}")
    public String publishMessage(@PathVariable String name) {
        //topic created as shown in readme.md
        template.send(topic, "Hi " + name + ". Welcome to Kunal's gitHub");
        return "Data published";
    }

    public static void main(String[] args) {
        SpringApplication.run(KafkaPublisherApplication.class, args);
    }

}
