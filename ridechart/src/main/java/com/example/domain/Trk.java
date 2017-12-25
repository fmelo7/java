package com.example.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Trk implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String heartRate;

    @Column
    private String cadence;

    @Column
    private String distance;

    @Column
    private String speed;

    @Column
    private String altitude;

    @Column
    private String positionLat;

    @Column
    private String positionLong;

    @Column
    private String timestamp;

    @Column
    private String power;

    @Column
    private String grade;

    @Column
    private String calories;

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getHeartRate() {
	return heartRate;
    }

    public void setHeartRate(String heartRate) {
	this.heartRate = heartRate;
    }

    public String getCadence() {
	return cadence;
    }

    public void setCadence(String cadence) {
	this.cadence = cadence;
    }

    public String getDistance() {
	return distance;
    }

    public void setDistance(String distance) {
	this.distance = distance;
    }

    public String getSpeed() {
	return speed;
    }

    public void setSpeed(String speed) {
	this.speed = speed;
    }

    public String getAltitude() {
	return altitude;
    }

    public void setAltitude(String altitude) {
	this.altitude = altitude;
    }

    public String getPositionLat() {
	return positionLat;
    }

    public void setPositionLat(String positionLat) {
	this.positionLat = positionLat;
    }

    public String getPositionLong() {
	return positionLong;
    }

    public void setPositionLong(String positionLong) {
	this.positionLong = positionLong;
    }

    public String getTimestamp() {
	return timestamp;
    }

    public void setTimestamp(String timestamp) {
	this.timestamp = timestamp;
    }

    public String getPower() {
	return power;
    }

    public void setPower(String power) {
	this.power = power;
    }

    public String getGrade() {
	return grade;
    }

    public void setGrade(String grade) {
	this.grade = grade;
    }

    public String getCalories() {
	return calories;
    }

    public void setCalories(String calories) {
	this.calories = calories;
    }
}
