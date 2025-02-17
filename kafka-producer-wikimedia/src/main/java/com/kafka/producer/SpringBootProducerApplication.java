package com.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootProducerApplication implements CommandLineRunner{
    public static void main(String[] args) {
        SpringApplication.run(SpringBootProducerApplication.class);
    }


    @Autowired
    private WikiMediaChangesProducer wikiMediaChangesProducer;

    // executed whenever SpringBootProducerApplication this is override from CommandLineRunner
    @Override
    public void run(String... args) throws Exception{
        wikiMediaChangesProducer.sendMessage();
    }


}
