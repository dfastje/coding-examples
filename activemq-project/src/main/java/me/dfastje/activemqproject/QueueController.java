package me.dfastje.activemqproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QueueController {

    private Publisher publisher;

    @Autowired
    public QueueController(Publisher publisher){
        this.publisher = publisher;
    }

    @GetMapping("sendMessage")
    public String sendMessage(){
        publisher.sendMessageToQueue("Hello World");
        return "Hello World";
    }
}
