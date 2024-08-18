package com.ds.paymentservice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer
{
    private static final Logger logger = LoggerFactory.getLogger(Producer.class);
    private static final String TOPIC = "customer-events";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendEvent(String type, String username) throws JsonProcessingException {
        PaymentEvent paymentEvent = new PaymentEvent();
        paymentEvent.setType(type);
        paymentEvent.setUsername(username);

        ObjectMapper objectMapper = new ObjectMapper();
        String event =  objectMapper.writeValueAsString(paymentEvent);

        logger.info(String.format("#### -> Producing message -> %s", event));
        this.kafkaTemplate.send(TOPIC,username, event);
    }

}
