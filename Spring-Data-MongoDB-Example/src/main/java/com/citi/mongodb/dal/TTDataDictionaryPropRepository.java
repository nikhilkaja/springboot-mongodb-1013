package com.citi.mongodb.dal;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.citi.mongodb.model.TTDataDictionaryProp;

@Repository
public interface TTDataDictionaryPropRepository extends MongoRepository<TTDataDictionaryProp, String> {
}