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

import com.citi.mongodb.dal.TTDataDictionaryEventRepository;
import com.citi.mongodb.exception.RecordNotFoundException;
import com.citi.mongodb.model.TTDataDictionaryEvent;

@RestController
@RequestMapping("/v1")
public class TTDataDictionaryEventController {
	
	private final Logger LOG = LoggerFactory.getLogger(getClass());
   
	@Autowired
    private TTDataDictionaryEventRepository ttDataDictionaryEventRepository;


    @GetMapping("/getEvents")
    public List <TTDataDictionaryEvent> getDataDictionaries() {
    	LOG.info("Fetching ttDataDictionaryEvent data");
        return ttDataDictionaryEventRepository.findAll();
    }

    @GetMapping("/getEvent/{id}")
    public ResponseEntity <TTDataDictionaryEvent> getDataDictionaryById(@PathVariable(value = "eventName") String eventName)
    throws RecordNotFoundException {
    	LOG.info("Getting ttDataDictionaryEvent data for event name :: "+ eventName);
    	TTDataDictionaryEvent ttDataDictionaryEvent = ttDataDictionaryEventRepository.findOne(eventName);
     	if(null == ttDataDictionaryEvent) {
     		throw new RecordNotFoundException("Record not found for this event name :: "+eventName);
     	}
        return ResponseEntity.ok().body(ttDataDictionaryEvent);
    }

    @PostMapping("/saveEvent")
    public TTDataDictionaryEvent createDataDictionary(@Valid @RequestBody TTDataDictionaryEvent ttDataDictionaryEvent) {
    	LOG.info("Saving ttDataDictionaryEvent data.");
        return ttDataDictionaryEventRepository.save(ttDataDictionaryEvent);
    }

    @PutMapping("/updateEvent/{id}")
    public ResponseEntity < TTDataDictionaryEvent > updateDataDictionary(@PathVariable(value = "eventName") String eventName,
        @Valid @RequestBody TTDataDictionaryEvent updateTTDataDictionary) throws RecordNotFoundException {
       
    	TTDataDictionaryEvent ttDataDictionaryEvent = ttDataDictionaryEventRepository.findOne(eventName);
    	if(null == ttDataDictionaryEvent) {
    		throw new RecordNotFoundException("Record not found for this event name :: "+eventName);
    	}
    	
    	//update Data
    	LOG.info("updating ttDataDictionaryEvent data for event name :: "+eventName);
    	
    	ttDataDictionaryEvent.setEventDataType(updateTTDataDictionary.getEventDataType());
    	ttDataDictionaryEvent.setEventRelease(updateTTDataDictionary.getEventRelease());
    	ttDataDictionaryEvent.setEventImplementedOn(updateTTDataDictionary.getEventImplementedOn());
    	ttDataDictionaryEvent.setEventProdStartDate(updateTTDataDictionary.getEventProdStartDate());
    	ttDataDictionaryEvent.setEventVariable(updateTTDataDictionary.getEventVariable());
    	ttDataDictionaryEvent.setEventName(updateTTDataDictionary.getEventName());
		ttDataDictionaryEvent.setEventContextData(updateTTDataDictionary.getEventContextData());
		ttDataDictionaryEvent.setEventStatus(updateTTDataDictionary.getEventStatus());
		ttDataDictionaryEvent.setEventDescription(updateTTDataDictionary.getEventDescription());
		ttDataDictionaryEvent.setEventAllocation(updateTTDataDictionary.getEventAllocation());
		ttDataDictionaryEvent.setEventExpiration(updateTTDataDictionary.getEventExpiration());
		ttDataDictionaryEvent.setEventMerchHandizing(updateTTDataDictionary.getEventMerchHandizing());
		ttDataDictionaryEvent.setEventTTUsage(updateTTDataDictionary.getEventTTUsage());
		ttDataDictionaryEvent.setEventMobileUsage(updateTTDataDictionary.getEventMobileUsage());
		ttDataDictionaryEvent.setEventMobileVariable(updateTTDataDictionary.getEventMobileVariable());
		ttDataDictionaryEvent.setEventGlobalVariable(updateTTDataDictionary.getEventGlobalVariable());
		ttDataDictionaryEvent.setEventCitiNaProdVariable(updateTTDataDictionary.getEventCitiNaProdVariable());
		ttDataDictionaryEvent.setEventMenuGrouping(updateTTDataDictionary.getEventMenuGrouping());
		ttDataDictionaryEvent.setEventReplication(updateTTDataDictionary.getEventReplication());
    	
    	
        final TTDataDictionaryEvent updateDataDictionary = ttDataDictionaryEventRepository.save(ttDataDictionaryEvent);
        return ResponseEntity.ok(updateDataDictionary);
    }


	@DeleteMapping("/deleteEvent/{eventName}")
    public Map < String, Boolean > deleteDataDictionary(@PathVariable(value = "eventName") String eventName) throws RecordNotFoundException {
		TTDataDictionaryEvent ttDataDictionaryEvent = ttDataDictionaryEventRepository.findOne(eventName);
    	
    	if(null == ttDataDictionaryEvent) {
    		throw new RecordNotFoundException("Record not found for this event name :: "+eventName);
    	}
    	LOG.info("Deleting ttDataDictionaryEvent data for event name :: "+eventName);
    	ttDataDictionaryEventRepository.delete(ttDataDictionaryEvent);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
	
}