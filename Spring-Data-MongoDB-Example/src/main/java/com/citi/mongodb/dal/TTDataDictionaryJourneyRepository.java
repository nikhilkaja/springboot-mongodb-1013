package com.citi.mongodb.dal;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.citi.mongodb.model.TTDataDictionaryJourney;

@Repository
public interface TTDataDictionaryJourneyRepository extends MongoRepository<TTDataDictionaryJourney, String> {
}