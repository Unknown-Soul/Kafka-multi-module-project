package com.kafka.producer;

import java.net.URI;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;

@Service
public class WikiMediaChangesProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(WikiMediaChangesProducer.class); 

    private KafkaTemplate<String,String> kafkaTemplate;

    public WikiMediaChangesProducer(KafkaTemplate<String, String> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage() throws InterruptedException{
        String topic = "wikimedia_recentchange";
        
        // to read data from wikimedia we use  event source
        EventHandler eventHandler =  new WikieMediaChangesHandlerTopic(kafkaTemplate, topic);
        String url  = "https://stream.wikimedia.org/v2/stream/recentchange";

        EventSource.Builder builder = new EventSource.Builder(eventHandler, URI.create(url));
        EventSource eventSource = builder.build();

        eventSource.start();
        TimeUnit.MINUTES.sleep(10);
    }
}