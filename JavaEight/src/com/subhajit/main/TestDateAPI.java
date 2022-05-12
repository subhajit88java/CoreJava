package com.subhajit.main;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class TestDateAPI {

	public static void main(String[] args) {
		
		checkLocalDate();
		//checkLocalDateTime();
		//checkLocalTime();
		
		
	}

	private static void checkLocalTime() {
		LocalTime lt = LocalTime.now();
		System.out.println("lt : " + lt);		
	}

	private static void checkLocalDateTime() {
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println("ldt : " + ldt);		
		System.out.println("ld.getDayOfMonth() : " + ldt.getDayOfMonth());
		System.out.println("ld.getDayOfYear() : " + ldt.getDayOfYear());
		System.out.println("ld.getMonthValue() : " + ldt.getMonthValue());
		System.out.println("ld.getYear() : " + ldt.getYear());
		System.out.println("ld.getDayOfWeek() : " + ldt.getDayOfWeek());
		System.out.println("Minus 2 days : " + ldt.minusDays(2));
		System.out.println("Minus 2 months : " + ldt.minusMonths(2));
		System.out.println("Minus 2 years : " + ldt.minusYears(2));
		System.out.println("plus 2 days : " + ldt.plusDays(2));
		System.out.println("plus 2 months : " + ldt.plusMonths(2));
		System.out.println("plus 2 years : " + ldt.plusYears(2));
		
		ZoneId zone1 = ZoneId.of("GMT");  
		LocalDateTime ldtWithZone = LocalDateTime.now(zone1);
		System.out.println("ldtWithZone : " + ldtWithZone);
		
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MMM/yyyy hh:mm:ss a");
	    System.out.println("Formatted date : " + df.format(ldt));
	}

	private static void checkLocalDate() {
		
		LocalDate ld = LocalDate.now();
		System.out.println("ld : " + ld);
		System.out.println("ld.getDayOfMonth() : " + ld.getDayOfMonth());
		System.out.println("ld.getDayOfYear() : " + ld.getDayOfYear());
		System.out.println("ld.getMonthValue() : " + ld.getMonthValue());
		System.out.println("ld.getYear() : " + ld.getYear());
		System.out.println("ld.getDayOfWeek() : " + ld.getDayOfWeek());
		System.out.println("ld.getEra() : " + ld.getEra());
		System.out.println("Minus 2 days : " + ld.minusDays(2));
		System.out.println("Minus 2 months : " + ld.minusMonths(2));
		System.out.println("Minus 2 years : " + ld.minusYears(2));
		System.out.println("plus 2 days : " + ld.plusDays(2));
		System.out.println("plus 2 months : " + ld.plusMonths(2));
		System.out.println("plus 2 years : " + ld.plusYears(2));
		System.out.println("Leap Year Check : " + ld.isLeapYear());
		System.out.println("ld.atTime: " + ld.atTime(23, 59, 59));
		
		LocalDate customizedLd = LocalDate.of(2019, 8, 28);
		System.out.println("customizedLd : " + customizedLd);
		
		System.out.println("isAfter : " + ld.isAfter(customizedLd));
		System.out.println("isBefore : " + ld.isBefore(customizedLd));
		System.out.println("isEqual : " + ld.isEqual(customizedLd));
		
	    long days = ChronoUnit.DAYS.between(customizedLd, ld);
	    System.out.println("days difference : " + days);
	    
	    DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MMM/yyyy");
	    System.out.println("Date to String : " + df.format(ld));
	    System.out.println("String to Date: " + df.parse("12/Jan/2021"));
	    
	    Period diff = Period.between(ld, customizedLd);
	    System.out.println("diff of year : " + diff.getYears());
	    System.out.println("diff of month : " + diff.getMonths());
	    System.out.println("diff of days : " + diff.getDays());
	    
	
		
	}
}
