package com.example.camundademo.controller;

import org.camunda.bpm.engine.RuntimeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RequestMapping("api/v1/")
@RestController
public class MessageController {

    private final RuntimeService runtimeService;

    public MessageController(RuntimeService runtimeService) {
        this.runtimeService = runtimeService;
    }

    @GetMapping(path = "heathcheck")
    public Map<String, String> healthCheck() {
        Map<String, String> resp = new HashMap<>();
        resp.put("up", "true");
        return resp;
    }

    @PutMapping(path = "message/name/{messageName}/id/{procId}")
    public void correlateMessage(@PathVariable String messageName, @PathVariable String procId) {
        runtimeService.createMessageCorrelation(messageName)
                .processInstanceId(procId)
                .setVariable("status", "COMPLETED")
                .correlateAll();
    }

    @PostMapping(path = "process/definition_key/{procDefinition}")
    public String startProcess(@PathVariable String procDefinition) {
        return runtimeService.startProcessInstanceByKey(procDefinition)
                .getId();
    }

}
