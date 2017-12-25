package com.example.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class DataRecord implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	@Column
	private Short heartRate;

	@Column
	private Short cadence;

	@Column
	private Float distance;

	@Column
	private Float speed;

	@Column
	private Float altitude;

	@Column
	private Integer positionLat;

	@Column
	private Integer positionLong;

	@Column
	private Long timestamp;

	@Column
	private Integer power;

	@Column
	private Float grade;

	@Column
	private Integer calories;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Short getHeartRate() {
		return heartRate;
	}

	public void setHeartRate(Short heartRate) {
		this.heartRate = heartRate;
	}

	public Short getCadence() {
		return cadence;
	}

	public void setCadence(Short cadence) {
		this.cadence = cadence;
	}

	public Float getDistance() {
		return distance;
	}

	public void setDistance(Float distance) {
		this.distance = distance;
	}

	public Float getSpeed() {
		return speed;
	}

	public void setSpeed(Float speed) {
		this.speed = speed;
	}

	public Float getAltitude() {
		return altitude;
	}

	public void setAltitude(Float altitude) {
		this.altitude = altitude;
	}

	public Integer getPositionLat() {
		return positionLat;
	}

	public void setPositionLat(Integer positionLat) {
		this.positionLat = positionLat;
	}

	public Integer getPositionLong() {
		return positionLong;
	}

	public void setPositionLong(Integer positionLong) {
		this.positionLong = positionLong;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getPower() {
		return power;
	}

	public void setPower(Integer power) {
		this.power = power;
	}

	public Float getGrade() {
		return grade;
	}

	public void setGrade(Float grade) {
		this.grade = grade;
	}

	public Integer getCalories() {
		return calories;
	}

	public void setCalories(Integer calories) {
		this.calories = calories;
	}

}
