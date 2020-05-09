package com.ntier.lambdas.starters;

import java.time.ZoneId;

public class Airport {

	private String code;
	private String name;
	private String city;
	private String state;
	private ZoneId timezone;
	
	public Airport(){
		
	}
	public Airport(String code, String name, String city, String state, ZoneId timezone) {
		super();
		this.setCode(code);
		this.setName(name);
		this.setCity(city);
		this.setState(state);
		this.setTimezone(timezone);
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public ZoneId getTimezone() {
		return timezone;
	}
	public void setTimezone(ZoneId timezone) {
		this.timezone = timezone;
	}
	@Override
	public String toString() {
		return "Airport: " + code + " Name: " + name + " City: " + city 
				+ " State: " + state + " Timezone: " + timezone;
	}
}
