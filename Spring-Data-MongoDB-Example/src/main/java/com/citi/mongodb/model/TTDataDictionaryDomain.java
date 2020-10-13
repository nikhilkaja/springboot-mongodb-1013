package com.citi.mongodb.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "domain")
public class TTDataDictionaryDomain {

	@Id
	private String domainId;
	private String domainName;
	
	public String getDomainId() {
		return domainId;
	}
	public void setDomainId(String domainId) {
		this.domainId = domainId;
	}
	public String getDomainName() {
		return domainName;
	}
	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}
	
	
	
	
}
