package com.javaSampleCode.enums;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;
import java.util.Set;

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

		EnumSet<GRADES> enumSet = EnumSet.of(GRADES.EXCELLENT, GRADES.GOOD);

		for (GRADES g : enumSet) {
			System.out.println(g);
		}

		EnumMap<GRADES, String> enumMap = new EnumMap<>(GRADES.class);
		enumMap.put(GRADES.GOOD, "G");
		enumMap.put(GRADES.POOR, "P");

		Set<Map.Entry<GRADES, String>> entrySet = enumMap.entrySet();
		for (Map.Entry<GRADES, String> entry : entrySet) {
			System.out.println(entry);
		}

	}
}