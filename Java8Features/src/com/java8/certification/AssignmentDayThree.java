/**
 * 
 */
package com.java8.certification;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Year;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

/**
 * @author User
 *
 */
public class AssignmentDayThree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// How to check Leap Year in Java 8
		LocalDate localDate = LocalDate.now();
		System.out.println("Current Year Leap Year? : " + localDate.isLeapYear());
		System.out.println("Any Year Leap Year? : " + localDate.withYear(2019).isLeapYear());
		System.out.println(Year.isLeap(2019));

		// Find out how many days, month between two dates. Take two dates.
		LocalDate fromDate = LocalDate.of(2020, Month.JANUARY, 01);
		LocalDate toDate = LocalDate.of(2020, Month.JUNE, 30);

		long noOfDays = ChronoUnit.DAYS.between(fromDate, toDate);
		System.out.println("Days difference between fromDate & toDate: " + noOfDays);

		long noOfMonths = ChronoUnit.MONTHS.between(fromDate, toDate);
		System.out.println("Months difference between fromDate & toDate: " + noOfMonths);

		// Parse date using custom formatting for format “2020/06/24”
		LocalDate customDate = LocalDate.of(2020, Month.JUNE, 24);
		System.out.println("Custom Date is: " + customDate.format(DateTimeFormatter.ofPattern("yyyy/MM/dd")));

		// Given a random date, how would you find the date of it's previous Thursday?
		LocalDate randomDate = LocalDate.of(2020, Month.JUNE, 20);
		System.out.println(
				"Date of the previous Thursday: " + randomDate.with(TemporalAdjusters.previous(DayOfWeek.THURSDAY)));

		// How would you convert an Instant to a ZonedDateTime?
		// System.out.println(ZoneId.getAvailableZoneIds());
		Instant instant = Instant.now();
		System.out.println("instant: " + instant);
		ZonedDateTime instantToZonedDateTime = instant.atZone(ZoneId.of("Europe/Rome"));
		System.out.println("instantToZonedDateTime: " + instantToZonedDateTime);

		// How would you convert a ZonedDateTime to an Instant?
		LocalDateTime localDateTime = LocalDateTime.of(2020, Month.MARCH, 22, 10, 10, 10);
		ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.of("Europe/Rome"));
		System.out.println("zonedDateTime : " + zonedDateTime);
		Instant zonedDateTimeToInstant = zonedDateTime.toInstant();
		System.out.println("zonedDateTimeToInstant : " + zonedDateTimeToInstant);

		// List of all the Mondays in that month.
		System.out.println("List of Mondays in a month: " + listAllMondaysInMonth(Month.APRIL));

		// Write an example that tests whether a given date occurs on Friday the 13th.
		System.out
				.println("Given date occurs on Friday 13th?: " + checkFriday13th(LocalDate.of(2020, Month.MARCH, 13)));
	}

	/**
	 * Write an example that, for a given month of the current year, lists all of
	 * the Mondays in that month.
	 * 
	 * @param month
	 * @return List of LocalDate
	 */
	private static List<LocalDate> listAllMondaysInMonth(Month month) {
		List<LocalDate> mondayList = new ArrayList<>();
		LocalDate setDate = Year.now().atMonth(month).atDay(1).with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
		Month mi = setDate.getMonth();
		while (mi == month) {
			mondayList.add(setDate);
			setDate = setDate.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
			mi = setDate.getMonth();
		}
		return mondayList;
	}

	/**
	 * Test whether a given date occurs on Friday the 13th.
	 * 
	 * @param friday13th
	 * @return boolean
	 */
	private static boolean checkFriday13th(LocalDate friday13th) {
		return ((friday13th.getDayOfMonth() == 13) && (friday13th.getDayOfWeek() == DayOfWeek.FRIDAY));
	}

}
