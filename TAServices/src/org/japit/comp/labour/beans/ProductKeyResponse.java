package org.japit.comp.labour.beans;

public class ProductKeyResponse {
	private int responseStatus;
	private String responseMessage;
	
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

}
