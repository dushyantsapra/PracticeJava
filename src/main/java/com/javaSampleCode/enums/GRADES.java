package com.javaSampleCode.enums;

public enum GRADES {
	EXCELLENT(1, "Excellent"), GOOD(2, "Good"), POOR(3, "Poor");

	private int iValue;
	private String sValue;

	private GRADES(int iValue, String sValue) {
		this.iValue = iValue;
		this.sValue = sValue;
	}

	@Override
	public String toString() {
		return super.toString() + " " + this.iValue + " " + this.sValue;
	}
	
}
