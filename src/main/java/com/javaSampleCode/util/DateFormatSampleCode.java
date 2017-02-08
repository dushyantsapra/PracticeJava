package com.javaSampleCode.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

//1477702800

public class DateFormatSampleCode {
	public static void main(String[] args) throws ParseException {
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");

		Date date = sdf.parse("2016-10-29T03:00:00+0200");

		String timeZone = "Europe/Stockholm";

		LocalDateTime currentTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.of(timeZone));

		currentTime = currentTime.plusDays(1);
		ZonedDateTime zdt = currentTime.atZone(ZoneId.of("Europe/Stockholm"));
		System.out.println(zdt);

		long mili = 1477702800000L;
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
		System.out.println(dateFormat.format(mili));
	}
}