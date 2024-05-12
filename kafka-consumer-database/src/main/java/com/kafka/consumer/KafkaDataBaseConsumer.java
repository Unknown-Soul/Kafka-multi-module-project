package com.kafka.consumer;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.config.SpringDataJacksonConfiguration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.kafka.consumer.entity.WikiMediaData;
import com.kafka.consumer.repository.WikiMediaRepository;

@Service
public class KafkaDataBaseConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    @Autowired
    private WikiMediaRepository wikiMediaRepository;

    public KafkaDataBaseConsumer(WikiMediaRepository wikiMediaRepository){
        this.wikiMediaRepository = wikiMediaRepository;
    }

    @KafkaListener(topics = "wikimedia_recentchange", groupId = "myKafkaGroup")
    public void consumer(String eventMessage){
        LOGGER.info(String.format("Message Receiver -> %s", eventMessage));
        WikiMediaData wikiMediaData = new WikiMediaData();
        wikiMediaData.setWikiEventData(eventMessage.substring(0,30));
        wikiMediaRepository.save(wikiMediaData);

    }
}
