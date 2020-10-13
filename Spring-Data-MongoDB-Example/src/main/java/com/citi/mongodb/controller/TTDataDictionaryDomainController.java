package com.citi.mongodb.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citi.mongodb.dal.TTDataDictionaryDomainRepository;
import com.citi.mongodb.exception.RecordNotFoundException;
import com.citi.mongodb.model.TTDataDictionaryDomain;

@RestController
@RequestMapping("/v1")
public class TTDataDictionaryDomainController {
	
	private final Logger LOG = LoggerFactory.getLogger(getClass());
   
	@Autowired
    private TTDataDictionaryDomainRepository ttDataDictionaryDomainRepository;


    @GetMapping("/getDomains")
    public List <TTDataDictionaryDomain> getDataDictionaries() {
    	LOG.info("Fetching ttDataDictionaryDomain data");
        return ttDataDictionaryDomainRepository.findAll();
    }

    @GetMapping("/getDomain/{domainId}")
    public ResponseEntity <TTDataDictionaryDomain> getDataDictionaryById(@PathVariable(value = "domainId") String domainId)
    throws RecordNotFoundException {
    	LOG.info("Getting ttDataDictionaryDomain data for domain id :: "+domainId);
    	TTDataDictionaryDomain ttDataDictionaryDomain = ttDataDictionaryDomainRepository.findOne(domainId);
     	if(null == ttDataDictionaryDomain) {
     		throw new RecordNotFoundException("Record not found for this domain id :: "+domainId);
     	}
        return ResponseEntity.ok().body(ttDataDictionaryDomain);
    }

    @PostMapping("/saveDomain")
    public TTDataDictionaryDomain createDataDictionary(@Valid @RequestBody TTDataDictionaryDomain ttDataDictionaryDomain) {
    	LOG.info("Saving ttDataDictionaryDomain data.");
        return ttDataDictionaryDomainRepository.save(ttDataDictionaryDomain);
    }

    @PutMapping("/updateDomain/{id}")
    public ResponseEntity < TTDataDictionaryDomain > updateDataDictionary(@PathVariable(value = "domainId") String domainId,
        @Valid @RequestBody TTDataDictionaryDomain updateTTDataDictionary) throws RecordNotFoundException {
       
    	TTDataDictionaryDomain ttDataDictionaryDomain = ttDataDictionaryDomainRepository.findOne(domainId);
    	if(null == ttDataDictionaryDomain) {
    		throw new RecordNotFoundException("Record not found for this domain id :: "+domainId);
    	}
    	
    	//update Data
    	LOG.info("updating ttDataDictionaryDomain data for domain id :: "+domainId);
    	
    	ttDataDictionaryDomain.setDomainId(updateTTDataDictionary.getDomainId());
    	ttDataDictionaryDomain.setDomainName(updateTTDataDictionary.getDomainName());
    	
        final TTDataDictionaryDomain updateDataDictionary = ttDataDictionaryDomainRepository.save(ttDataDictionaryDomain);
        return ResponseEntity.ok(updateDataDictionary);
    }


	@DeleteMapping("/deleteDomain/{domainId}")
    public Map < String, Boolean > deleteDataDictionary(@PathVariable(value = "domainId") String domainId) throws RecordNotFoundException {
		TTDataDictionaryDomain ttDataDictionaryDomain = ttDataDictionaryDomainRepository.findOne(domainId);
    	
    	if(null == ttDataDictionaryDomain) {
    		throw new RecordNotFoundException("Record not found for this domain id :: "+domainId);
    	}
    	LOG.info("Deleting ttDataDictionaryDomain data for domain id :: "+domainId);
    	ttDataDictionaryDomainRepository.delete(ttDataDictionaryDomain);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
	
}