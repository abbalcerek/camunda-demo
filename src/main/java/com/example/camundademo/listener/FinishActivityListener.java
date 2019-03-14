package com.example.camundademo.listener;


import org.camunda.bpm.engine.ActivityTypes;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.camunda.bpm.extension.reactor.bus.CamundaSelector;
import org.camunda.bpm.extension.reactor.spring.listener.ReactorExecutionListener;
import org.springframework.stereotype.Component;

@Component
@CamundaSelector(event = ExecutionListener.EVENTNAME_END, type = ActivityTypes.TASK_RECEIVE_TASK)
public class FinishActivityListener  extends ReactorExecutionListener {
    @Override
    public void notify(DelegateExecution execution) throws Exception {
        System.out.println("Received task finished with status: "
                + execution.getVariable("status"));
    }
}
