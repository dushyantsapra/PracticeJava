package com.javaSampleCode.enums;

class EnumExample {
	enum LEVEL {
		LOW(1, "Low"), MEDIUM(2, "Medium"), HIGH(3, "High");

		private int levelID;
		private String levelName;

		private LEVEL(int levelID, String levelName) {
			this.levelID = levelID;
			this.levelName = levelName;
		}

		@Override
		public String toString() {
			return super.toString() + " " + this.levelID + " " + this.levelName;
		}
	}
}

public class EnumSampleCode {
	public static void main(String[] args) {
		System.out.println(GRADES.POOR);
		System.out.println(GRADES.GOOD);
		System.out.println(GRADES.EXCELLENT);
		System.out.println();
		for (GRADES tempEnum : GRADES.values()) {
			System.out.println(tempEnum);
		}
		System.out.println();
		System.out.println(GRADES.valueOf("POOR"));
		try {
			System.out.println(GRADES.valueOf("Poor"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(EnumExample.LEVEL.LOW);
		System.out.println();
		for (EnumExample.LEVEL tempEnum : EnumExample.LEVEL.values()) {
			System.out.println(tempEnum);
		}
	}
}
