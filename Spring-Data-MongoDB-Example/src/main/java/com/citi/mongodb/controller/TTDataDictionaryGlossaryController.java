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

import com.citi.mongodb.dal.TTDataDictionaryGlossaryRepository;
import com.citi.mongodb.exception.RecordNotFoundException;
import com.citi.mongodb.model.TTDataDictionaryGlossary;

@RestController
@RequestMapping("/v1")
public class TTDataDictionaryGlossaryController {
	
	private final Logger LOG = LoggerFactory.getLogger(getClass());
   
	@Autowired
    private TTDataDictionaryGlossaryRepository ttDataDictionaryGlossaryRepository;


    @GetMapping("/getGlossaries")
    public List <TTDataDictionaryGlossary> getDataDictionaries() {
    	LOG.info("Fetching ttDataDictionaryGlossary data");
        return ttDataDictionaryGlossaryRepository.findAll();
    }

    @GetMapping("/getGlossaries/{glossaryId}")
    public ResponseEntity <TTDataDictionaryGlossary> getDataDictionaryById(@PathVariable(value = "glossaryId") String glossaryId)
    throws RecordNotFoundException {
    	LOG.info("Getting ttDataDictionaryGlossary data for glossary id :: "+glossaryId);
    	TTDataDictionaryGlossary ttDataDictionaryGlossary = ttDataDictionaryGlossaryRepository.findOne(glossaryId);
     	if(null == ttDataDictionaryGlossary) {
     		throw new RecordNotFoundException("Record not found for this glossary id :: "+glossaryId);
     	}
        return ResponseEntity.ok().body(ttDataDictionaryGlossary);
    }

    @PostMapping("/saveGlossary")
    public TTDataDictionaryGlossary createDataDictionary(@Valid @RequestBody TTDataDictionaryGlossary ttDataDictionaryGlossary) {
    	LOG.info("Saving ttDataDictionaryGlossary data.");
        return ttDataDictionaryGlossaryRepository.save(ttDataDictionaryGlossary);
    }

    @PutMapping("/updateGlossary/{id}")
    public ResponseEntity < TTDataDictionaryGlossary > updateDataDictionary(@PathVariable(value = "glossaryId") String glossaryId,
        @Valid @RequestBody TTDataDictionaryGlossary updateTTDataDictionary) throws RecordNotFoundException {
       
    	TTDataDictionaryGlossary ttDataDictionaryGlossary = ttDataDictionaryGlossaryRepository.findOne(glossaryId);
    	if(null == ttDataDictionaryGlossary) {
    		throw new RecordNotFoundException("Record not found for this glossary id :: "+glossaryId);
    	}
    	
    	//update Data
    	LOG.info("updating ttDataDictionaryGlossary data for glossary id :: "+glossaryId);
		
    	ttDataDictionaryGlossary.setGlossaryId(updateTTDataDictionary.getGlossaryId());
    	ttDataDictionaryGlossary.setGlossaryName(updateTTDataDictionary.getGlossaryName());
    	ttDataDictionaryGlossary.setGlossaryDesc(updateTTDataDictionary.getGlossaryDesc());
        final TTDataDictionaryGlossary updateDataDictionary = ttDataDictionaryGlossaryRepository.save(ttDataDictionaryGlossary);
        return ResponseEntity.ok(updateDataDictionary);
    }


	@DeleteMapping("/deleteGlossary/{id}")
    public Map < String, Boolean > deleteDataDictionary(@PathVariable(value = "glossaryId") String glossaryId) throws RecordNotFoundException {
		TTDataDictionaryGlossary ttDataDictionaryGlossary = ttDataDictionaryGlossaryRepository.findOne(glossaryId);
    	
    	if(null == ttDataDictionaryGlossary) {
    		throw new RecordNotFoundException("Record not found for this glossary id :: "+glossaryId);
    	}
    	LOG.info("Deleting ttDataDictionaryGlossary data for id :: "+glossaryId);
    	ttDataDictionaryGlossaryRepository.delete(ttDataDictionaryGlossary);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
	
}