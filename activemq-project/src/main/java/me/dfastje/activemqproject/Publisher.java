package me.dfastje.activemqproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class Publisher {

    private final JmsTemplate jmsTemplate;

    @Autowired
    public Publisher(JmsTemplate jmsTemplate){
        this.jmsTemplate = jmsTemplate;
    }

    public void sendMessageToQueue(String message){
        jmsTemplate.convertAndSend(message);
    }

}
