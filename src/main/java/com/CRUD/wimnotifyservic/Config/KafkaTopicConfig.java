package com.CRUD.wimnotifyservic.Config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
    @Bean
    public NewTopic NotificationTopic(){
        return TopicBuilder.name("NotificationTopic").build();
    }
    @Bean
    public NewTopic NotificationJsonTopic(){
        return TopicBuilder.name("NotificationTopic_Json").build();
    }

}
