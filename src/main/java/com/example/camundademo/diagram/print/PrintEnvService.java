package com.example.camundademo.diagram.print;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class PrintEnvService implements JavaDelegate {

    private final Environment env;

    public PrintEnvService(Environment env) {
        this.env = env;
    }

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        System.out.println("Spring env bean in side java delegate:" + env);
    }
}
