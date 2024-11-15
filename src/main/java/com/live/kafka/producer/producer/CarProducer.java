package com.live.kafka.producer.producer;

import com.live.kafka.producer.controller.CarDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CarProducer {

    @Value("${topic.name}")
    private String topic;

    private final KafkaTemplate<String, CarDTO> kafkaTemplate;

    public void send(CarDTO carDTO) {
        kafkaTemplate.send(topic, carDTO);
        log.info("Message sent: {}", carDTO);
    }
}
