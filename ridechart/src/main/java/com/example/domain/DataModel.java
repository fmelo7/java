package com.example.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class DataModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false, unique = true)
	private String filename;

	@ManyToOne(cascade = { CascadeType.ALL })
	private DataFileId dataFileId = new DataFileId();

	@ManyToOne(cascade = { CascadeType.ALL })
	private DataDeviceInfo dataDeviceInfo = new DataDeviceInfo();

	@ManyToOne(cascade = { CascadeType.ALL })
	private DataUserProfile dataUserProfile = new DataUserProfile();

	@ManyToOne(cascade = { CascadeType.ALL })
	private DataMonitoring dataMonitoring = new DataMonitoring();

	@ManyToOne(cascade = { CascadeType.ALL })
	private DataDeveloperFieldDescription dataDeveloperFieldDescription = new DataDeveloperFieldDescription();

	@OneToMany(cascade = { CascadeType.ALL })
	private List<DataRecord> dataRecords = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public DataFileId getDataFileId() {
		return dataFileId;
	}

	public void setDataFileId(DataFileId dataFileId) {
		this.dataFileId = dataFileId;
	}

	public DataMonitoring getDataMonitoring() {
		return dataMonitoring;
	}

	public void setDataMonitoring(DataMonitoring dataMonitoring) {
		this.dataMonitoring = dataMonitoring;
	}

	public DataDeviceInfo getDataDeviceInfo() {
		return dataDeviceInfo;
	}

	public void setDataDeviceInfo(DataDeviceInfo dataDeviceInfo) {
		this.dataDeviceInfo = dataDeviceInfo;
	}

	public DataUserProfile getDataUserProfile() {
		return dataUserProfile;
	}

	public void setDataUserProfile(DataUserProfile dataUserProfile) {
		this.dataUserProfile = dataUserProfile;
	}

	public DataDeveloperFieldDescription getDataDeveloperFieldDescription() {
		return dataDeveloperFieldDescription;
	}

	public void setDataDeveloperFieldDescription(DataDeveloperFieldDescription dataDeveloperFieldDescription) {
		this.dataDeveloperFieldDescription = dataDeveloperFieldDescription;
	}

	public List<DataRecord> getDataRecords() {
		return dataRecords;
	}

	public void setDataRecords(List<DataRecord> dataRecords) {
		this.dataRecords = dataRecords;
	}

}
