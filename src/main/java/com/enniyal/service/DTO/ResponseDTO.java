package com.enniyal.service.DTO;

public class ResponseDTO {
	
	private String status;
	private String description;
	private String organiserId;

	public ResponseDTO(String status, String description, String organiserId) {
		super();
		this.status = status;
		this.description = description;
		this.organiserId = organiserId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOrganiserId() {
		return organiserId;
	}

	public void setOrganiserId(String organiserId) {
		this.organiserId = organiserId;
	}

}
