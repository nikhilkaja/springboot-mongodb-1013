package com.citi.mongodb.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "subJourney")
public class TTDataDictionarySubJourney {

	@Id
	private String subJourneyId;
	private String subJourneyName;
	private String journeyName;
	private String domainName;
	public String getSubJourneyId() {
		return subJourneyId;
	}
	public void setSubJourneyId(String subJourneyId) {
		this.subJourneyId = subJourneyId;
	}
	public String getSubJourneyName() {
		return subJourneyName;
	}
	public void setSubJourneyName(String subJourneyName) {
		this.subJourneyName = subJourneyName;
	}
	public String getJourneyName() {
		return journeyName;
	}
	public void setJourneyName(String journeyName) {
		this.journeyName = journeyName;
	}
	public String getDomainName() {
		return domainName;
	}
	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

}
