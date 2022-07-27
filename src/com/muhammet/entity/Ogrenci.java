package com.muhammet.entity;

import java.io.Serializable;

public class Ogrenci implements Serializable {

	String ad;

	
	public Ogrenci(String ad) {
		super();
		this.ad = ad;
	}

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}
	
}
