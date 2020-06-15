package me.dfastje.activemqproject;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.activemq.RedeliveryPolicy;
import org.apache.activemq.command.ActiveMQBytesMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;

@Component
public class Listener {

    @JmsListener( destination = "foo.bar", containerFactory = "JmsListenerFactory")
    public void receiveMessage(final Message jsonMessage ) throws JMSException {
        String messageData = null;
        String response = null;
        try{
            if( jsonMessage instanceof ActiveMQBytesMessage){
                ActiveMQBytesMessage message = (ActiveMQBytesMessage) jsonMessage;
                messageData = new String( message.getContent().getData() );
                ObjectMapper mapper = new ObjectMapper();

                //Any processing would be done from calling a method here, usually
                throw new RuntimeException("DLQ test!");
            }
        } catch ( Exception ex){
            throw new RuntimeException(ex);
        }
        jsonMessage.acknowledge();
    }
}