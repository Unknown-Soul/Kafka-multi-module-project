package com.kafka.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class WikiMediaChangesProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(WikiMediaChangesProducer.class); 

    private KafkaTemplate<String,String> kafkaTemplate;

    public WikiMediaChangesProducer(KafkaTemplate<String, String> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(){
        String topic = "wikimedia_recentchange";

        // to read data from wikimedia we use  event source
    }
}