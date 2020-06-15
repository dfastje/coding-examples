package me.dfastje.activemqproject;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;


@Configuration
public class ActiveMQCBeanConfigurations {

    private final Environment environment;

    @Autowired
    public ActiveMQCBeanConfigurations(Environment environment){
        this.environment = environment;
    }

    @Bean
    public ActiveMQConnectionFactory activeMQConnectionFactory(){
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
        String amqUrl = environment.getProperty("spring.activemq.broker-url");
        activeMQConnectionFactory.setBrokerURL(amqUrl);
        return activeMQConnectionFactory;
    }

    @Bean
    public JmsTemplate jmsTemplate(){
        String queueName = environment.getProperty("spring.activemq.queuename");

        JmsTemplate jmsTemplate = new JmsTemplate();

        jmsTemplate.setDefaultDestinationName(queueName);
        jmsTemplate.setConnectionFactory( activeMQConnectionFactory() );
        jmsTemplate.setSessionAcknowledgeMode(2);
        jmsTemplate.setDeliveryPersistent(Boolean.TRUE);
        jmsTemplate.setMessageConverter( new MappingJackson2MessageConverter() );

        return jmsTemplate;
    }

    @Bean(name = "JmsListenerFactory")
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory(){
        DefaultJmsListenerContainerFactory jmsListenerContainerFactory = new DefaultJmsListenerContainerFactory();
        jmsListenerContainerFactory.setConnectionFactory( activeMQConnectionFactory() );
        jmsListenerContainerFactory.setSessionAcknowledgeMode(2);

        return jmsListenerContainerFactory;
    }
}
