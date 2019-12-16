package com.techhub.common.spring.beans;

public class ProductKeyResponse {
	public int responseStatus;
	public String responseMessage;
	
	 public ProductKeyResponse(int responseStatus, String responseMessage) {
	    	this.responseStatus = responseStatus;
	    	this.responseMessage = responseMessage;
	    }

	public int getResponseStatus() {
		return responseStatus;
	}

	public void setResponseStatus(int responseStatus) {
		this.responseStatus = responseStatus;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	@Override
	public String toString() {
		return "ProductKeyResponse [responseStatus=" + responseStatus + ", responseMessage=" + responseMessage + "]";
	}

}
