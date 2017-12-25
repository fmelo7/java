package com.example.domain;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class DataDeveloperFieldDescription implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	@Column
	private UUID applicationId;

	@Column
	private Long applicationVersion;

	@Column
	private Short fieldDefinitionNumber;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UUID getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(UUID applicationId) {
		this.applicationId = applicationId;
	}

	public Long getApplicationVersion() {
		return applicationVersion;
	}

	public void setApplicationVersion(Long applicationVersion) {
		this.applicationVersion = applicationVersion;
	}

	public Short getFieldDefinitionNumber() {
		return fieldDefinitionNumber;
	}

	public void setFieldDefinitionNumber(Short fieldDefinitionNumber) {
		this.fieldDefinitionNumber = fieldDefinitionNumber;
	}

}
