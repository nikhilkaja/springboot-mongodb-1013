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

import com.citi.mongodb.dal.TTDataDictionarySubJourneyRepository;
import com.citi.mongodb.exception.RecordNotFoundException;
import com.citi.mongodb.model.TTDataDictionarySubJourney;

@RestController
@RequestMapping("/v1")
public class TTDataDictionarySubJourneyController {
	
	private final Logger LOG = LoggerFactory.getLogger(getClass());
   
	@Autowired
    private TTDataDictionarySubJourneyRepository ttDataDictionarySubJourneyRepository;


    @GetMapping("/getSubJourneys")
    public List <TTDataDictionarySubJourney> getDataDictionaries() {
    	LOG.info("Fetching ttDataDictionarySubJourney data");
        return ttDataDictionarySubJourneyRepository.findAll();
    }

    @GetMapping("/getSubJourney/{subJourneyId}")
    public ResponseEntity <TTDataDictionarySubJourney> getDataDictionaryById(@PathVariable(value = "subJourneyId") String subJourneyId)
    throws RecordNotFoundException {
    	LOG.info("Getting ttDataDictionarySubJourney data for subJourney id :: "+subJourneyId);
    	TTDataDictionarySubJourney ttDataDictionarySubJourney = ttDataDictionarySubJourneyRepository.findOne(subJourneyId);
     	if(null == ttDataDictionarySubJourney) {
     		throw new RecordNotFoundException("Record not found for this id :: "+subJourneyId);
     	}
        return ResponseEntity.ok().body(ttDataDictionarySubJourney);
    }

    @PostMapping("/saveSubJourney")
    public TTDataDictionarySubJourney createDataDictionary(@Valid @RequestBody TTDataDictionarySubJourney ttDataDictionarySubJourney) {
    	LOG.info("Saving ttDataDictionarySubJourney data.");
        return ttDataDictionarySubJourneyRepository.save(ttDataDictionarySubJourney);
    }

    @PutMapping("/updateSubJourney/{subJourneyId}")
    public ResponseEntity < TTDataDictionarySubJourney > updateDataDictionary(@PathVariable(value = "subJourneyId") String subJourneyId,
        @Valid @RequestBody TTDataDictionarySubJourney updateTTDataDictionary) throws RecordNotFoundException {
       
    	TTDataDictionarySubJourney ttDataDictionarySubJourney = ttDataDictionarySubJourneyRepository.findOne(subJourneyId);
    	if(null == ttDataDictionarySubJourney) {
    		throw new RecordNotFoundException("Record not found for this subJourney id :: "+subJourneyId);
    	}
    	
    	//update Data
    	LOG.info("updating ttDataDictionarySubJourney data for subJourney id :: "+subJourneyId);
		
    	ttDataDictionarySubJourney.setSubJourneyId(updateTTDataDictionary.getSubJourneyId());
    	ttDataDictionarySubJourney.setSubJourneyName(updateTTDataDictionary.getJourneyName());
    	ttDataDictionarySubJourney.setJourneyName(updateTTDataDictionary.getJourneyName());
    	ttDataDictionarySubJourney.setDomainName(updateTTDataDictionary.getDomainName());
    	
        final TTDataDictionarySubJourney updateDataDictionary = ttDataDictionarySubJourneyRepository.save(ttDataDictionarySubJourney);
        return ResponseEntity.ok(updateDataDictionary);
    }


	@DeleteMapping("/deleteSubJourney/{subJourneyId}")
    public Map < String, Boolean > deleteDataDictionary(@PathVariable(value = "subJourneyId") String subJourneyId) throws RecordNotFoundException {
		TTDataDictionarySubJourney ttDataDictionarySubJourney = ttDataDictionarySubJourneyRepository.findOne(subJourneyId);
    	
    	if(null == ttDataDictionarySubJourney) {
    		throw new RecordNotFoundException("Record not found for this subJourney id :: "+subJourneyId);
    	}
    	LOG.info("Deleting ttDataDictionarySubJourney data for subJourney id :: "+subJourneyId);
    	ttDataDictionarySubJourneyRepository.delete(ttDataDictionarySubJourney);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
	
}