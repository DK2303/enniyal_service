package com.enniyal.service.DTO;

import java.math.BigInteger;

public class SettingsDTO {
	private Long id;
	private String companyName;
	private byte[] companyLogo;
	private String fileName;
	private String fileType;
	private BigInteger mobileNumber;
	private String phoneNumber;
	private String email;
	private String websiteAddress;
	private String gstNumber;
	private String cinNumber;
	private String tinNumber;
	private String currency;
	private String address;
	private String notes;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public byte[] getCompanyLogo() {
		return companyLogo;
	}
	public void setCompanyLogo(byte[] companyLogo) {
		this.companyLogo = companyLogo;
	}
	public BigInteger getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(BigInteger mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getWebsiteAddress() {
		return websiteAddress;
	}
	public void setWebsiteAddress(String websiteAddress) {
		this.websiteAddress = websiteAddress;
	}
	public String getGstNumber() {
		return gstNumber;
	}
	public void setGstNumber(String gstNumber) {
		this.gstNumber = gstNumber;
	}
	public String getCinNumber() {
		return cinNumber;
	}
	public void setCinNumber(String cinNumber) {
		this.cinNumber = cinNumber;
	}
	public String getTinNumber() {
		return tinNumber;
	}
	public void setTinNumber(String tinNumber) {
		this.tinNumber = tinNumber;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
//	@Override
//	public String toString() {
//		return "SettingsDTO [id=" + id + ", companyName=" + companyName + ", companyLogo="
//				+ Arrays.toString(companyLogo) + ", mobileNumber=" + mobileNumber + ", phoneNumber=" + phoneNumber
//				+ ", email=" + email + ", websiteAddress=" + websiteAddress + ", gstNumber=" + gstNumber
//				+ ", cinNumber=" + cinNumber + ", tinNumber=" + tinNumber + ", currency=" + currency + ", address="
//				+ address + ", notes=" + notes + "]";
//	}
}
