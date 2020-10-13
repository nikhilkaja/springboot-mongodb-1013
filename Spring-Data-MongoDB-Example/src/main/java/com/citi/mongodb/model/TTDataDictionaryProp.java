package com.citi.mongodb.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "prop")
public class TTDataDictionaryProp {

	@Id
	private String propName;
	private String propRelease;
	private String propImplementedOn;
	private String propProdStartDate;
	private String propVariable;
	private String propContextData;
	private String propStatus;
	private String propDescription;
	private String propDataType;
	private String propAllocation;
	private String propExpiration;
	private String propMerchHandizing;
	private String propTTUsage;
	private String propMobileUsage;
	private String propMobileVariable;
	private String propGlobalVariable;
	private String propCitiNaProdVariable;
	private String propMenuGrouping;
	private String propReplication;
	
	public String getPropRelease() {
		return propRelease;
	}
	public void setPropRelease(String propRelease) {
		this.propRelease = propRelease;
	}
	public String getPropImplementedOn() {
		return propImplementedOn;
	}
	public void setPropImplementedOn(String propImplementedOn) {
		this.propImplementedOn = propImplementedOn;
	}
	public String getPropProdStartDate() {
		return propProdStartDate;
	}
	public void setPropProdStartDate(String propProdStartDate) {
		this.propProdStartDate = propProdStartDate;
	}
	public String getPropVariable() {
		return propVariable;
	}
	public void setPropVariable(String propVariable) {
		this.propVariable = propVariable;
	}
	public String getPropName() {
		return propName;
	}
	public void setPropName(String propName) {
		this.propName = propName;
	}
	public String getPropContextData() {
		return propContextData;
	}
	public void setPropContextData(String propContextData) {
		this.propContextData = propContextData;
	}
	public String getPropStatus() {
		return propStatus;
	}
	public void setPropStatus(String propStatus) {
		this.propStatus = propStatus;
	}
	public String getPropDescription() {
		return propDescription;
	}
	public void setPropDescription(String propDescription) {
		this.propDescription = propDescription;
	}
	public String getPropDataType() {
		return propDataType;
	}
	public void setPropDataType(String propDataType) {
		this.propDataType = propDataType;
	}
	public String getPropMerchHandizing() {
		return propMerchHandizing;
	}
	public void setPropMerchHandizing(String propMerchHandizing) {
		this.propMerchHandizing = propMerchHandizing;
	}
	public String getPropTTUsage() {
		return propTTUsage;
	}
	public void setPropTTUsage(String propTTUsage) {
		this.propTTUsage = propTTUsage;
	}
	public String getPropMobileUsage() {
		return propMobileUsage;
	}
	public void setPropMobileUsage(String propMobileUsage) {
		this.propMobileUsage = propMobileUsage;
	}
	public String getPropGlobalVariable() {
		return propGlobalVariable;
	}
	public void setPropGlobalVariable(String propGlobalVariable) {
		this.propGlobalVariable = propGlobalVariable;
	}
	public String getPropCitiNaProdVariable() {
		return propCitiNaProdVariable;
	}
	public void setPropCitiNaProdVariable(String propCitiNaProdVariable) {
		this.propCitiNaProdVariable = propCitiNaProdVariable;
	}
	public String getPropMenuGrouping() {
		return propMenuGrouping;
	}
	public void setPropMenuGrouping(String propMenuGrouping) {
		this.propMenuGrouping = propMenuGrouping;
	}
	public String getPropReplication() {
		return propReplication;
	}
	public void setPropReplication(String propReplication) {
		this.propReplication = propReplication;
	}
	public String getPropAllocation() {
		return propAllocation;
	}
	public void setPropAllocation(String propAllocation) {
		this.propAllocation = propAllocation;
	}
	public String getPropExpiration() {
		return propExpiration;
	}
	public void setPropExpiration(String propExpiration) {
		this.propExpiration = propExpiration;
	}
	public String getPropMobileVariable() {
		return propMobileVariable;
	}
	public void setPropMobileVariable(String propMobileVariable) {
		this.propMobileVariable = propMobileVariable;
	}
	
}
