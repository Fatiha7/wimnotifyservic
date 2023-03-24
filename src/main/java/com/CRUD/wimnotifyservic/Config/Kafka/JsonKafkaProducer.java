package com.CRUD.wimnotifyservic.Config.Kafka;

import com.CRUD.wimnotifyservic.Model.Notification;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
@AllArgsConstructor
@Service
public class JsonKafkaProducer {
    private static final Logger LOGGER= LoggerFactory.getLogger(JsonKafkaProducer.class);
    private KafkaTemplate<String, Notification> KafkaTemplate;
    public void sendMessage(Notification notification){
        LOGGER.info(String.format("Message sent -> %s",notification.toString()));
        Message<Notification> message = MessageBuilder.withPayload(notification).setHeader(KafkaHeaders.TOPIC,"NotificationTopic_Json").build();
        KafkaTemplate.send(message);
    }
}
