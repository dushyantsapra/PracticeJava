package com.javaSampleCode.enums;

import java.util.EnumSet;

public class EnumSampleCode {

	public static void checkSwithcCase(GRADES enumName) {
		switch (enumName) {
		case EXCELLENT:
			System.out.println("Excellent");
			break;
		case GOOD:
		case POOR:
			System.out.println("Need Improvement");
			break;
		default:
			break;
		}
	}

	public static void main(String[] args) {
		System.out.println(GRADES.EXCELLENT);
		System.out.println(GRADES.GOOD);
		System.out.println(GRADES.POOR);

		System.out.println(GRADES.EXCELLENT.ordinal() + " " + GRADES.EXCELLENT.name());

		System.out.println(GRADES.valueOf("EXCELLENT").compareTo(GRADES.POOR));

		for (GRADES g : GRADES.values()) {
			checkSwithcCase(g);
		}

		EnumSet<GRADES> enumSet = EnumSet.of(GRADES.EXCELLENT, GRADES.GOOD, GRADES.POOR);
		
	}
}