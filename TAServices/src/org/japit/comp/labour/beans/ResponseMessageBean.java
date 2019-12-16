package org.japit.comp.labour.beans;

public class ResponseMessageBean {

	private String inspection_id;
	private String central_inspection_id;
	private String status;
	private String status_code;
	private String message;

	public ResponseMessageBean(String inspection_id,String status, String status_code, String message) {
		super();
		this.inspection_id = inspection_id;
		this.status = status;
		this.status_code = status_code;
		this.message = message;
	}
	
	public ResponseMessageBean(String inspection_id,String central_inspection_id,String status, String status_code, String message) {
		super();
		this.inspection_id = inspection_id;
		this.central_inspection_id=central_inspection_id;
		this.status = status;
		this.status_code = status_code;
		this.message = message;
	}

	public String getInspection_id() {
		return inspection_id;
	}

	public void setInspection_id(String inspection_id) {
		this.inspection_id = inspection_id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus_code() {
		return status_code;
	}

	public void setStatus_code(String status_code) {
		this.status_code = status_code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCentral_inspection_id() {
		return central_inspection_id;
	}

	public void setCentral_inspection_id(String central_inspection_id) {
		this.central_inspection_id = central_inspection_id;
	}

	
}
