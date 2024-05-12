package com.kafka.consumer;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaDataBaseConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "wikimedia_recentchange", groupId = "myKafkaGroup")
    public void consumer(String eventMessage){
        LOGGER.info(String.format("Message Receiver -> %s", eventMessage));
    }
}
