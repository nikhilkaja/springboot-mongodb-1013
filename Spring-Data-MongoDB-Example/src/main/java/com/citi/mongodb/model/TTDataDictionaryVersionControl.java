package com.citi.mongodb.model;


import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "vesronControl")
public class TTDataDictionaryVersionControl {

	@Id
	private String changeNumber;
	private Date changeDate;
	private String changeDescription;
	private String changeAuthor;
	private String chnageTicket;
	
	public String getChangeNumber() {
		return changeNumber;
	}
	public void setChangeNumber(String changeNumber) {
		this.changeNumber = changeNumber;
	}
	public Date getChangeDate() {
		return changeDate;
	}
	public void setChangeDate(Date changeDate) {
		this.changeDate = changeDate;
	}
	public String getChangeDescription() {
		return changeDescription;
	}
	public void setChangeDescription(String changeDescription) {
		this.changeDescription = changeDescription;
	}
	public String getChangeAuthor() {
		return changeAuthor;
	}
	public void setChangeAuthor(String changeAuthor) {
		this.changeAuthor = changeAuthor;
	}
	public String getChnageTicket() {
		return chnageTicket;
	}
	public void setChnageTicket(String chnageTicket) {
		this.chnageTicket = chnageTicket;
	}
	
	
	
}
