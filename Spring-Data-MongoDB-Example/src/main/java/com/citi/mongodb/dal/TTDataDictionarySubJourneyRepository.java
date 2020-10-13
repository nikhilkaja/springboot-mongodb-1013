package com.citi.mongodb.dal;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.citi.mongodb.model.TTDataDictionarySubJourney;

@Repository
public interface TTDataDictionarySubJourneyRepository extends MongoRepository<TTDataDictionarySubJourney, String> {
}