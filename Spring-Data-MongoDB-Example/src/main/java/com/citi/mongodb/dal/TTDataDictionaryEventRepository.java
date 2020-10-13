package com.citi.mongodb.dal;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.citi.mongodb.model.TTDataDictionaryEvent;

@Repository
public interface TTDataDictionaryEventRepository extends MongoRepository<TTDataDictionaryEvent, String> {
}