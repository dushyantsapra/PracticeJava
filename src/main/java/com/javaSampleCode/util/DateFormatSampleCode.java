package com.javaSampleCode.util;

import java.time.LocalDate;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.Locale;

public class DateFormatSampleCode {
	public static void main(String[] args) {
		LocalDate localDate = LocalDate.of(2016, 01, 27);
		System.out.println(localDate);
		localDate = localDate.plusMonths(1);
		System.out.println(localDate);
		localDate = localDate.plusMonths(1);
		System.out.println(localDate);

		System.out.println();
		
		TemporalField weekOfYear = WeekFields.of(Locale.getDefault()).weekOfWeekBasedYear();
        localDate = LocalDate.of(2017, 01, 27);
        System.out.println(localDate.get(weekOfYear));
		
		System.out.println();

		org.joda.time.LocalDate localDate1 = org.joda.time.LocalDate.parse("2016-01-30");
		System.out.println(localDate1);
		localDate1 = localDate1.plusMonths(1);
		System.out.println(localDate1);
		localDate1 = localDate1.plusMonths(1);
		System.out.println(localDate1);
	}
}