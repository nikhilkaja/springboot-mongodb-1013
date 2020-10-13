package com.citi.mongodb.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "journey")
public class TTDataDictionaryJourney {

	@Id
	private String journeyId;
	private String domainName;
	private String journeyName;
	
	public String getJourneyId() {
		return journeyId;
	}
	public void setJourneyId(String journeyId) {
		this.journeyId = journeyId;
	}
	public String getDomainName() {
		return domainName;
	}
	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}
	public String getJourneyName() {
		return journeyName;
	}
	public void setJourneyName(String journeyName) {
		this.journeyName = journeyName;
	}
	
	
}
