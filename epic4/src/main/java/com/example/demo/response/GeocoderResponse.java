package com.example.demo.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GeocoderResponse {
	
	private String city;
    private String providence;
    
    @JsonProperty("city")
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
    @JsonProperty("prov")

	public String getProvidence() {
		return providence;
	}
	public void setProvidence(String providence) {
		this.providence = providence;
	}
    


}
