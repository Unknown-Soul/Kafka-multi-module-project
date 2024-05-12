package com.kafka.consumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kafka.consumer.entity.WikiMediaData;

public interface WikiMediaRepository extends JpaRepository<WikiMediaData,Long>{
    
    
}
