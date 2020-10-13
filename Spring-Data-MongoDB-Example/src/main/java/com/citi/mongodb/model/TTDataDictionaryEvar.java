package com.citi.mongodb.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "evar")
public class TTDataDictionaryEvar {

	@Id
	private String evarName;
	private String evarRelease;
	private String evarImplementedOn;
	private String evarProdStartDate;
	private String evarVariable;
	private String evarContextData;
	private String evarStatus;
	private String evarDescription;
	private String evarDataType;
	private String evarEvarAllocation;
	private String evarEvarExpiration;
	private String evarMerchHandizing;
	private String evarTTUsage;
	private String evarMobileUsage;
	private String evarMobileVariable;
	private String evarGlobalVariable;
	private String evarCitiNaProdVariable;
	private String evarMenuGrouping;
	private String evarReplication;
	
	public String getEvarRelease() {
		return evarRelease;
	}
	public void setEvarRelease(String evarRelease) {
		this.evarRelease = evarRelease;
	}
	public String getEvarImplementedOn() {
		return evarImplementedOn;
	}
	public void setEvarImplementedOn(String evarImplementedOn) {
		this.evarImplementedOn = evarImplementedOn;
	}
	public String getEvarProdStartDate() {
		return evarProdStartDate;
	}
	public void setEvarProdStartDate(String evarProdStartDate) {
		this.evarProdStartDate = evarProdStartDate;
	}
	public String getEvarVariable() {
		return evarVariable;
	}
	public void setEvarVariable(String evarVariable) {
		this.evarVariable = evarVariable;
	}
	public String getEvarName() {
		return evarName;
	}
	public void setEvarName(String evarName) {
		this.evarName = evarName;
	}
	public String getEvarContextData() {
		return evarContextData;
	}
	public void setEvarContextData(String evarContextData) {
		this.evarContextData = evarContextData;
	}
	public String getEvarStatus() {
		return evarStatus;
	}
	public void setEvarStatus(String evarStatus) {
		this.evarStatus = evarStatus;
	}
	public String getEvarDescription() {
		return evarDescription;
	}
	public void setEvarDescription(String evarDescription) {
		this.evarDescription = evarDescription;
	}
	public String getEvarDataType() {
		return evarDataType;
	}
	public void setEvarDataType(String evarDataType) {
		this.evarDataType = evarDataType;
	}
	public String getEvarEvarAllocation() {
		return evarEvarAllocation;
	}
	public void setEvarEvarAllocation(String evarEvarAllocation) {
		this.evarEvarAllocation = evarEvarAllocation;
	}
	public String getEvarEvarExpiration() {
		return evarEvarExpiration;
	}
	public void setEvarEvarExpiration(String evarEvarExpiration) {
		this.evarEvarExpiration = evarEvarExpiration;
	}
	public String getEvarMerchHandizing() {
		return evarMerchHandizing;
	}
	public void setEvarMerchHandizing(String evarMerchHandizing) {
		this.evarMerchHandizing = evarMerchHandizing;
	}
	public String getEvarTTUsage() {
		return evarTTUsage;
	}
	public void setEvarTTUsage(String evarTTUsage) {
		this.evarTTUsage = evarTTUsage;
	}
	public String getEvarMobileUsage() {
		return evarMobileUsage;
	}
	public void setEvarMobileUsage(String evarMobileUsage) {
		this.evarMobileUsage = evarMobileUsage;
	}
	public String getEvarMobileVariable() {
		return evarMobileVariable;
	}
	public void setEvarMobileVariable(String evarMobileVariable) {
		this.evarMobileVariable = evarMobileVariable;
	}
	public String getEvarGlobalVariable() {
		return evarGlobalVariable;
	}
	public void setEvarGlobalVariable(String evarGlobalVariable) {
		this.evarGlobalVariable = evarGlobalVariable;
	}
	public String getEvarCitiNaProdVariable() {
		return evarCitiNaProdVariable;
	}
	public void setEvarCitiNaProdVariable(String evarCitiNaProdVariable) {
		this.evarCitiNaProdVariable = evarCitiNaProdVariable;
	}
	public String getEvarMenuGrouping() {
		return evarMenuGrouping;
	}
	public void setEvarMenuGrouping(String evarMenuGrouping) {
		this.evarMenuGrouping = evarMenuGrouping;
	}
	public String getEvarReplication() {
		return evarReplication;
	}
	public void setEvarReplication(String evarReplication) {
		this.evarReplication = evarReplication;
	}
	
}
