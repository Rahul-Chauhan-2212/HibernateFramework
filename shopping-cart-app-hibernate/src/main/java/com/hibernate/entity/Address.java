package com.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {

	@Column(name = "ADDRESS_LINE1", nullable = false)
	private String line1;

	@Column(name = "ADDRESS_LINE2")
	private String line2;

	@Column(name = "ADDRESS_CITY", nullable = false)
	private String city;

	@Column(name = "ADDRESS_DISTRICT", nullable = false)
	private String district;

	@Column(name = "ADDRESS_STATE", nullable = false)
	private String state;

	@Column(name = "ADDRESS_COUNTRY", nullable = false)
	private String country;

	@Column(name = "ADDRESS_ZIPCODE", nullable = false)
	private String zipcode;

	public String getLine1() {
		return line1;
	}

	public void setLine1(String line1) {
		this.line1 = line1;
	}

	public String getLine2() {
		return line2;
	}

	public void setLine2(String line2) {
		this.line2 = line2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

}
