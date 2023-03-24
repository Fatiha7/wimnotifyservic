package com.CRUD.wimnotifyservic.Config.Kafka;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
@AllArgsConstructor
@Service
public class KafkaProducer {
    private static final Logger LOGGER= LoggerFactory.getLogger(KafkaProducer.class);
    private KafkaTemplate<String,String> kafkaTemplate;
public void  sentMessage(String message){
    LOGGER.info(String.format("Message sent %s",message));
    kafkaTemplate.send("NotificationTopic",message);
}
}

