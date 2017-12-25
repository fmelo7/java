package com.example.service;

import java.util.Date;

public class Trackpoint {

    private double lat;
    private double lon;
    private double ele;
    private Date time;

    public static Trackpoint fromWGS84(double lat, double lon, double ele, Date time) {
	// TODO Auto-generated method stub
	return null;
    }

    public double getLat() {
	return lat;
    }

    public void setLat(double lat) {
	this.lat = lat;
    }

    public double getLon() {
	return lon;
    }

    public void setLon(double lon) {
	this.lon = lon;
    }

    public double getEle() {
	return ele;
    }

    public void setEle(double ele) {
	this.ele = ele;
    }

    public Date getTime() {
	return time;
    }

    public void setTime(Date time) {
	this.time = time;
    }
}
