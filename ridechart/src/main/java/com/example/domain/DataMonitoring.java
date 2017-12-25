package com.example.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class DataMonitoring implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	@Column
	private Long timestamp;

	@Column
	private String activityType;

	@Column
	private Long steps;

	@Column
	private Float strokes;

	@Column
	private Float cycles;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public String getActivityType() {
		return activityType;
	}

	public void setActivityType(String activityType) {
		this.activityType = activityType;
	}

	public Long getSteps() {
		return steps;
	}

	public void setSteps(Long steps) {
		this.steps = steps;
	}

	public Float getStrokes() {
		return strokes;
	}

	public void setStrokes(Float strokes) {
		this.strokes = strokes;
	}

	public Float getCycles() {
		return cycles;
	}

	public void setCycles(Float cycles) {
		this.cycles = cycles;
	}

}
