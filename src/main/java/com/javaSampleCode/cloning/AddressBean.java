package com.javaSampleCode.cloning;

import java.io.Serializable;

public class AddressBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cityName;
	private String stateName;

	public AddressBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AddressBean(String cityName, String stateName) {
		super();
		this.cityName = cityName;
		this.stateName = stateName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	@Override
	public String toString() {
		return "AddressBean [cityName=" + cityName + ", stateName=" + stateName + "]";
	}

}
