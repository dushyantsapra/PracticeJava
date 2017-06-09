package com.javaSampleCode.util;

import java.time.LocalDate;

public class DateFormatSampleCode {
	// public static void main(String[] args) {
	// LocalDate localDate = LocalDate.of(2016, 03, 13);
	// System.out.println(localDate);
	// localDate = localDate.plusMonths(1);
	// System.out.println(localDate);
	// localDate = localDate.plusMonths(1);
	// System.out.println(localDate);
	//
	// System.out.println();
	//
	// TemporalField weekOfYear =
	// WeekFields.of(Locale.getDefault()).weekOfWeekBasedYear();
	// localDate = LocalDate.of(2017, 01, 27);
	// System.out.println(localDate.get(weekOfYear));
	//
	// System.out.println();
	//
	// org.joda.time.LocalDate localDate1 =
	// org.joda.time.LocalDate.parse("2016-03-13");
	// System.out.println(localDate1);
	// localDate1 = localDate1.plusMonths(1);
	// System.out.println(localDate1);
	// localDate1 = localDate1.plusMonths(1);
	// System.out.println(localDate1);
	//
	// System.out.println();
	// System.out.println(15424);
	// System.out.println();
	//
	// LocalDateTime ldt = LocalDateTime.ofEpochSecond(DAYS.toSeconds(16369), 0,
	// ZoneOffset.of("Europe/Stockholm"));
	// System.out.println(ldt);
	//
	// LocalDateTime localDateTime =
	// LocalDateTime.ofInstant(Instant.ofEpochSecond(DAYS.toSeconds(15424)),
	// ZoneId.of("Europe/Stockholm"));
	// ZonedDateTime zonedDateTime =
	// localDateTime.atZone(ZoneId.of("Europe/Stockholm"));
	// System.out.println(zonedDateTime);
	// System.out.println(zonedDateTime.getOffset().getTotalSeconds());
	//
	// localDateTime =
	// localDateTime.minusSeconds(zonedDateTime.getOffset().getTotalSeconds());
	// System.out.println(localDateTime);
	//
	// localDateTime = localDateTime.plusHours(1);
	// System.out.println(localDateTime);
	// zonedDateTime = localDateTime.atZone(ZoneId.of("Europe/Stockholm"));
	// System.out.println(zonedDateTime);
	//
	//
	// System.out.println(localDateTime);
	// }

	public static void main(String[] args) {
		System.out.println(LocalDate.of(2012, 3, 0));
	}

}