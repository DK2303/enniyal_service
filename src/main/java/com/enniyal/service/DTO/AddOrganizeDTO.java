package com.enniyal.service.DTO;

import java.math.BigInteger;

public class AddOrganizeDTO {

	//private Long clientId;
		private String name;
		private String companyName;
		private BigInteger contactNumber;
		private String emailId;
		private String plan;
		private String paymentMethod;
		private String paymentMode;
		private String payment;
		
		
		
//		public Long getClientId() {
//			return clientId;
//		}
//		public void setClientId(Long clientId) {
//			this.clientId = clientId;
//		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getCompanyName() {
			return companyName;
		}
		public void setCompanyName(String companyName) {
			this.companyName = companyName;
		}
		public BigInteger getContactNumber() {
			return contactNumber;
		}
		public void setContactNumber(BigInteger contactNumber) {
			this.contactNumber = contactNumber;
		}
		public String getEmailId() {
			return emailId;
		}
		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}
		public String getPlan() {
			return plan;
		}
		public void setPlan(String plan) {
			this.plan = plan;
		}
		public String getPaymentMethod() {
			return paymentMethod;
		}
		public void setPaymentMethod(String paymentMethod) {
			this.paymentMethod = paymentMethod;
		}
		public String getPaymentMode() {
			return paymentMode;
		}
		public void setPaymentMode(String paymentMode) {
			this.paymentMode = paymentMode;
		}
		public String getPayment() {
			return payment;
		}
		public void setPayment(String payment) {
			this.payment = payment;
		}

}
