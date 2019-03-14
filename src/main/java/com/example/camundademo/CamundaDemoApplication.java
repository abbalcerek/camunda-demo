package com.example.camundademo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.camunda.bpm.extension.reactor.spring.EnableCamundaEventBus;


@SpringBootApplication
@EnableCamundaEventBus
public class CamundaDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CamundaDemoApplication.class, args);
    }

}
