package com.citi.mongodb.dal;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.citi.mongodb.model.TTDataDictionaryVersionControl;

@Repository
public interface TTDataDictionaryVersionControlRepository extends MongoRepository<TTDataDictionaryVersionControl, String> {
}