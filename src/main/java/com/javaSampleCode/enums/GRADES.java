package com.javaSampleCode.enums;

public enum GRADES {
	POOR(1, "Poor"), GOOD(2, "Good"), EXCELLENT(3, "Excellent");

	private int rankId;
	private String comment;

	private GRADES(int rankId, String comment) {
		this.rankId = rankId;
		this.comment = comment;
	}

	@Override
	public String toString() {
		return super.toString() + " " + this.rankId + " " + this.comment;
	}
}
