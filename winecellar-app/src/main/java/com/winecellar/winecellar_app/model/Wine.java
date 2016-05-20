package com.winecellar.winecellar_app.model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
@XmlRootElement
public class Wine {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int identity;

    private String name;

    private String grapes;

    private String country;

    private String region;
    
    private String year;
    
    private String picture;

    private String description;

	public int getId() {
		return identity;
	}

	public void setId(final int identity) {
		this.identity = identity;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getGrapes() {
		return grapes;
	}

	public void setGrapes(final String grapes) {
		this.grapes = grapes;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(final String country) {
		this.country = country;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(final String region) {
		this.region = region;
	}

	public String getYear() {
		return year;
	}

	public void setYear(final String year) {
		this.year = year;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(final String picture) {
		this.picture = picture;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

}

