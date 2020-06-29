/**
 * 
 */
package com.java8.certification;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

/**
 * @author User
 *
 */
public class PracticeDayThree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Instant instant = Instant.now();
		System.out.println(instant);

		// TimeZones
		System.out.println(ZoneId.getAvailableZoneIds());
		System.out.println(ZoneId.of("Asia/Aden"));

		LocalDate dob = LocalDate.of(1983, Month.APRIL, 17);
		DayOfWeek day = dob.getDayOfWeek();
		System.out.println("My DOB: " + dob + " and it was: " + day);

		System.out.println(dob.with(TemporalAdjusters.next(DayOfWeek.SUNDAY)));

		LocalDate today = LocalDate.now();
		System.out.println("Today: " + today);
		System.out.println("Tomorrow: " + today.plus(1, ChronoUnit.DAYS));
		System.out.println("Yesterday: " + today.minus(1, ChronoUnit.DAYS));

	}

}
