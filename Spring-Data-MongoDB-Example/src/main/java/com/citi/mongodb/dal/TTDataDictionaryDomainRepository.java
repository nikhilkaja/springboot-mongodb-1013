package com.citi.mongodb.dal;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.citi.mongodb.model.TTDataDictionaryDomain;

@Repository
public interface TTDataDictionaryDomainRepository extends MongoRepository<TTDataDictionaryDomain, String> {
}