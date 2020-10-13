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

import com.citi.mongodb.dal.TTDataDictionaryVersionControlRepository;
import com.citi.mongodb.exception.RecordNotFoundException;
import com.citi.mongodb.model.TTDataDictionaryVersionControl;

@RestController
@RequestMapping("/v1")
public class TTDataDictionaryVersionControlController {
	
	private final Logger LOG = LoggerFactory.getLogger(getClass());
   
	@Autowired
    private TTDataDictionaryVersionControlRepository ttDataDictionaryVersionControlRepository;


    @GetMapping("/getVersionControls")
    public List <TTDataDictionaryVersionControl> getDataDictionaries() {
    	LOG.info("Fetching ttDataDictionaryVersionControl data");
        return ttDataDictionaryVersionControlRepository.findAll();
    }

    @GetMapping("/getVersionControl/{changeNumber}")
    public ResponseEntity <TTDataDictionaryVersionControl> getDataDictionaryById(@PathVariable(value = "changeNumber") String changeNumber)
    throws RecordNotFoundException {
    	LOG.info("Getting ttDataDictionaryVersionControl data for change number :: "+changeNumber);
    	TTDataDictionaryVersionControl ttDataDictionaryVersionControl = ttDataDictionaryVersionControlRepository.findOne(changeNumber);
     	if(null == ttDataDictionaryVersionControl) {
     		throw new RecordNotFoundException("Record not found for this change number :: "+changeNumber);
     	}
        return ResponseEntity.ok().body(ttDataDictionaryVersionControl);
    }

    @PostMapping("/saveVersionControl")
    public TTDataDictionaryVersionControl createDataDictionary(@Valid @RequestBody TTDataDictionaryVersionControl ttDataDictionaryVersionControl) {
    	LOG.info("Saving ttDataDictionaryVersionControl data.");
        return ttDataDictionaryVersionControlRepository.save(ttDataDictionaryVersionControl);
    }

    @PutMapping("/updateVersionControl/{changeNumber}")
    public ResponseEntity < TTDataDictionaryVersionControl > updateDataDictionary(@PathVariable(value = "changeNumber") String changeNumber,
        @Valid @RequestBody TTDataDictionaryVersionControl updateTTDataDictionary) throws RecordNotFoundException {
       
    	TTDataDictionaryVersionControl ttDataDictionaryVersionControl = ttDataDictionaryVersionControlRepository.findOne(changeNumber);
    	if(null == ttDataDictionaryVersionControl) {
    		throw new RecordNotFoundException("Record not found for this change number :: "+changeNumber);
    	}
    	
    	//update Data
    	LOG.info("updating ttDataDictionaryVersionControl data for change number :: "+changeNumber);
    	ttDataDictionaryVersionControl.setChangeAuthor(updateTTDataDictionary.getChangeAuthor());
    	ttDataDictionaryVersionControl.setChangeDate(updateTTDataDictionary.getChangeDate());
    	ttDataDictionaryVersionControl.setChangeDescription(updateTTDataDictionary.getChangeDescription());
    	ttDataDictionaryVersionControl.setChangeNumber(updateTTDataDictionary.getChangeNumber());
    	ttDataDictionaryVersionControl.setChnageTicket(updateTTDataDictionary.getChnageTicket());
    	
        final TTDataDictionaryVersionControl updateDataDictionary = ttDataDictionaryVersionControlRepository.save(ttDataDictionaryVersionControl);
        return ResponseEntity.ok(updateDataDictionary);
    }


	@DeleteMapping("/deleteVersionControl/{changeNumber}")
    public Map < String, Boolean > deleteDataDictionary(@PathVariable(value = "changeNumber") String changeNumber) throws RecordNotFoundException {
		TTDataDictionaryVersionControl ttDataDictionaryVersionControl = ttDataDictionaryVersionControlRepository.findOne(changeNumber);
    	
    	if(null == ttDataDictionaryVersionControl) {
    		throw new RecordNotFoundException("Record not found for this change number :: "+changeNumber);
    	}
    	LOG.info("Deleting ttDataDictionaryVersionControl data for change number :: "+changeNumber);
    	ttDataDictionaryVersionControlRepository.delete(ttDataDictionaryVersionControl);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
	
}