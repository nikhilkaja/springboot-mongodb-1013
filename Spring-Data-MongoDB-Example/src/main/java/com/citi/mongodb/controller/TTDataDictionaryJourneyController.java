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

import com.citi.mongodb.dal.TTDataDictionaryJourneyRepository;
import com.citi.mongodb.exception.RecordNotFoundException;
import com.citi.mongodb.model.TTDataDictionaryJourney;

@RestController
@RequestMapping("/v1")
public class TTDataDictionaryJourneyController {
	
	private final Logger LOG = LoggerFactory.getLogger(getClass());
   
	@Autowired
    private TTDataDictionaryJourneyRepository ttDataDictionaryJourneyRepository;


    @GetMapping("/getJournies")
    public List <TTDataDictionaryJourney> getDataDictionaries() {
    	LOG.info("Fetching ttDataDictionaryJourney data");
        return ttDataDictionaryJourneyRepository.findAll();
    }

    @GetMapping("/getJourney/{journeyId}")
    public ResponseEntity <TTDataDictionaryJourney> getDataDictionaryById(@PathVariable(value = "journeyId") String journeyId)
    throws RecordNotFoundException {
    	LOG.info("Getting ttDataDictionaryJourney data for journey id :: "+journeyId);
    	TTDataDictionaryJourney ttDataDictionaryJourney = ttDataDictionaryJourneyRepository.findOne(journeyId);
     	if(null == ttDataDictionaryJourney) {
     		throw new RecordNotFoundException("Record not found for this id :: "+journeyId);
     	}
        return ResponseEntity.ok().body(ttDataDictionaryJourney);
    }

    @PostMapping("/saveJourney")
    public TTDataDictionaryJourney createDataDictionary(@Valid @RequestBody TTDataDictionaryJourney ttDataDictionaryDomain) {
    	LOG.info("Saving ttDataDictionaryJourney data.");
        return ttDataDictionaryJourneyRepository.save(ttDataDictionaryDomain);
    }

    @PutMapping("/updateJourney/{journeyId}")
    public ResponseEntity < TTDataDictionaryJourney > updateDataDictionary(@PathVariable(value = "journeyId") String journeyId,
        @Valid @RequestBody TTDataDictionaryJourney updateTTDataDictionary) throws RecordNotFoundException {
       
    	TTDataDictionaryJourney ttDataDictionaryJourney = ttDataDictionaryJourneyRepository.findOne(journeyId);
    	if(null == ttDataDictionaryJourney) {
    		throw new RecordNotFoundException("Record not found for this id :: "+journeyId);
    	}
    	
    	//update Data
    	LOG.info("updating ttDataDictionaryJourney data for journey id :: "+journeyId);
    	ttDataDictionaryJourney.setJourneyId(updateTTDataDictionary.getJourneyId());
    	ttDataDictionaryJourney.setJourneyName(updateTTDataDictionary.getJourneyName());
    	ttDataDictionaryJourney.setDomainName(updateTTDataDictionary.getDomainName());
		
        final TTDataDictionaryJourney updateDataDictionary = ttDataDictionaryJourneyRepository.save(ttDataDictionaryJourney);
        return ResponseEntity.ok(updateDataDictionary);
    }


	@DeleteMapping("/deleteJourney/{journeyId}")
    public Map < String, Boolean > deleteDataDictionary(@PathVariable(value = "journeyId") String journeyId) throws RecordNotFoundException {
		TTDataDictionaryJourney ttDataDictionaryJourney = ttDataDictionaryJourneyRepository.findOne(journeyId);
    	
    	if(null == ttDataDictionaryJourney) {
    		throw new RecordNotFoundException("Record not found for this journey id :: "+journeyId);
    	}
    	LOG.info("Deleting ttDataDictionaryJourney data for journey id :: "+journeyId);
    	ttDataDictionaryJourneyRepository.delete(ttDataDictionaryJourney);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
	
}