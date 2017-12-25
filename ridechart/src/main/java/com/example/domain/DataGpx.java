package com.example.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class DataGpx implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String filename;

    @OneToMany(cascade = { CascadeType.ALL })
    private List<Trk> trkpts = new ArrayList<>();

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

    public List<Trk> getTrkpts() {
	return trkpts;
    }

    public void setTrkpts(List<Trk> trkpts) {
	this.trkpts = trkpts;
    }
}
