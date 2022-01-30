package com.azad.core.java.java_8.date_time;

import java.time.LocalDateTime;
import java.time.Month;

/**
 * Local − Simplified date-time API with no complexity of timezone handling.
 * Zoned − Specialized date-time API to deal with various timezones.
 * LocalDate – represents a date (year, month, day) LocalDateTime – same as LocalDate, but includes time with nanosecond precision
 */
public class No_Zone{
    public static void main(String[] args){
        /// example of using LocalDateTime
        LocalDateTime date = LocalDateTime.now(); // equivalent to LocalDateTime.now(ZoneOffset.UTC) localdatetime is basically as UTC-0
        System.out.println(date); // print in 2022-01-30T13:43:53.192467200 format by default
        System.out.println(date.toLocalDate()); 

        Month month = date.getMonth();
        int day = date.getDayOfMonth();
        int seconds = date.getSecond();
        System.out.println("Month: " + month +", day: " + day +", seconds: " + seconds);

        // alter date object either on the day or month or year
        LocalDateTime date2 = date.withDayOfMonth(10).withYear(2012);
        System.out.println("date2: " + date2);
    }

}