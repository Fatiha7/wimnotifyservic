package com.CRUD.wimnotifyservic.Config.Kafka;

import com.CRUD.wimnotifyservic.Model.Notification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {
    private static final Logger LOGGER= LoggerFactory.getLogger(JsonKafkaConsumer.class);
    @KafkaListener(topics = "NotificationTopic_Json",groupId = "NotificationGroup")
    public void consumer(Notification notification){
        LOGGER.info(String.format("Json message received -> %s",notification.toString()));
    }
}
