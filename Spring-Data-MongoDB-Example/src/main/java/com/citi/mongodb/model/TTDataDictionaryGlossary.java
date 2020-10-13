package com.citi.mongodb.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "glossary")
public class TTDataDictionaryGlossary {

	@Id
	private String glossaryId;
	private String glossaryName;
	private String glossaryDesc;
	
	public String getGlossaryId() {
		return glossaryId;
	}
	public void setGlossaryId(String glossaryId) {
		this.glossaryId = glossaryId;
	}
	public String getGlossaryName() {
		return glossaryName;
	}
	public void setGlossaryName(String glossaryName) {
		this.glossaryName = glossaryName;
	}
	public String getGlossaryDesc() {
		return glossaryDesc;
	}
	public void setGlossaryDesc(String glossaryDesc) {
		this.glossaryDesc = glossaryDesc;
	}
	
}
