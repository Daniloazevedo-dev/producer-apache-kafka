package com.live.kafka.producer.controller;

import com.live.kafka.producer.producer.CarProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cars")
public class CarController {

    private final CarProducer carService;

    @PostMapping
    public ResponseEntity<CarDTO> create(@RequestBody CarDTO carDTO) {

        CarDTO car = CarDTO.builder()
                .id(UUID.randomUUID().toString())
                .model(carDTO.getModel())
                .color(carDTO.getColor())
                .build();

        carService.send(car);

        return ResponseEntity.status(HttpStatus.CREATED).body(car);
    }

}
