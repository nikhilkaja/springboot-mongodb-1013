package com.citi.mongodb.dal;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.citi.mongodb.model.TTDataDictionaryGlossary;

@Repository
public interface TTDataDictionaryGlossaryRepository extends MongoRepository<TTDataDictionaryGlossary, String> {
}