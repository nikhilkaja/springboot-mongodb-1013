package com.citi.mongodb.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "event")
public class TTDataDictionaryEvent {

	@Id
	private String eventName;
	private String eventRelease;
	private String eventImplementedOn;
	private String eventProdStartDate;
	private String eventVariable;
	private String eventContextData;
	private String eventStatus;
	private String eventDescription;
	private String eventDataType;
	private String eventAllocation;
	private String eventExpiration;
	private String eventMerchHandizing;
	private String eventTTUsage;
	private String eventMobileUsage;
	private String eventMobileVariable;
	private String eventGlobalVariable;
	private String eventCitiNaProdVariable;
	private String eventMenuGrouping;
	private String eventReplication;
	
	public String getEventRelease() {
		return eventRelease;
	}
	public void setEventRelease(String eventRelease) {
		this.eventRelease = eventRelease;
	}
	public String getEventImplementedOn() {
		return eventImplementedOn;
	}
	public void setEventImplementedOn(String eventImplementedOn) {
		this.eventImplementedOn = eventImplementedOn;
	}
	public String getEventProdStartDate() {
		return eventProdStartDate;
	}
	public void setEventProdStartDate(String eventProdStartDate) {
		this.eventProdStartDate = eventProdStartDate;
	}
	public String getEventVariable() {
		return eventVariable;
	}
	public void setEventVariable(String eventVariable) {
		this.eventVariable = eventVariable;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getEventContextData() {
		return eventContextData;
	}
	public void setEventContextData(String eventContextData) {
		this.eventContextData = eventContextData;
	}
	public String getEventStatus() {
		return eventStatus;
	}
	public void setEventStatus(String eventStatus) {
		this.eventStatus = eventStatus;
	}
	public String getEventDescription() {
		return eventDescription;
	}
	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}
	public String getEventDataType() {
		return eventDataType;
	}
	public void setEventDataType(String eventDataType) {
		this.eventDataType = eventDataType;
	}
	public String getEventMerchHandizing() {
		return eventMerchHandizing;
	}
	public void setEventMerchHandizing(String eventMerchHandizing) {
		this.eventMerchHandizing = eventMerchHandizing;
	}
	public String getEventTTUsage() {
		return eventTTUsage;
	}
	public void setEventTTUsage(String eventTTUsage) {
		this.eventTTUsage = eventTTUsage;
	}
	public String getEventMobileUsage() {
		return eventMobileUsage;
	}
	public void setEventMobileUsage(String eventMobileUsage) {
		this.eventMobileUsage = eventMobileUsage;
	}
	public String getEventGlobalVariable() {
		return eventGlobalVariable;
	}
	public void setEventGlobalVariable(String eventGlobalVariable) {
		this.eventGlobalVariable = eventGlobalVariable;
	}
	public String getEventCitiNaProdVariable() {
		return eventCitiNaProdVariable;
	}
	public void setEventCitiNaProdVariable(String eventCitiNaProdVariable) {
		this.eventCitiNaProdVariable = eventCitiNaProdVariable;
	}
	public String getEventMenuGrouping() {
		return eventMenuGrouping;
	}
	public void setEventMenuGrouping(String eventMenuGrouping) {
		this.eventMenuGrouping = eventMenuGrouping;
	}
	public String getEventReplication() {
		return eventReplication;
	}
	public void setEventReplication(String eventReplication) {
		this.eventReplication = eventReplication;
	}
	public String getEventAllocation() {
		return eventAllocation;
	}
	public void setEventAllocation(String eventAllocation) {
		this.eventAllocation = eventAllocation;
	}
	public String getEventExpiration() {
		return eventExpiration;
	}
	public void setEventExpiration(String eventExpiration) {
		this.eventExpiration = eventExpiration;
	}
	public String getEventMobileVariable() {
		return eventMobileVariable;
	}
	public void setEventMobileVariable(String eventMobileVariable) {
		this.eventMobileVariable = eventMobileVariable;
	}
}
