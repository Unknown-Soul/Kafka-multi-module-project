package com.kafka.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.MessageEvent;

/**
 * Trigger whevener there is new event int he wikimedia 
 */
public class WikieMediaChangesHandlerTopic implements EventHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(WikieMediaChangesHandlerTopic.class); 

    private KafkaTemplate<String, String> kafkaTemplate;
    private String topic; 

    public WikieMediaChangesHandlerTopic(KafkaTemplate<String, String> kafkaTemplate,String topic){
        this.kafkaTemplate = kafkaTemplate;
        this.topic = topic;
    }

    @Override
    public void onClosed() throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'onClosed'");
    }

    @Override
    public void onComment(String arg0) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'onComment'");
    }

    @Override
    public void onError(Throwable arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'onError'");
    }

    @Override
    public void onMessage(String arg0, MessageEvent arg1) throws Exception {
        LOGGER.info(String.format("event data -> s%", arg1.getData()));
        // send message to kafka
        kafkaTemplate.send(topic, arg1.getData());
    }

    @Override
    public void onOpen() throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'onOpen'");
    }
    
}
