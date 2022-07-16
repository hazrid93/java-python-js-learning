package com.azad.core.java.basic.date_time;

import java.time.LocalDateTime;
import java.time.LocalTime;

import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;

import java.time.DayOfWeek;

public class LocalDate1 {
    public static void main(String[] args) {
        LocalDateTime initial = LocalDateTime.parse("2022-06-30T10:11:30");
        LocalDateTime initialDayHour = initial.with(LocalTime.of(0,0,0));
        LocalDateTime lastDayHour = initial.with(LocalTime.of(23,59,59));
        LocalDateTime initialDayOfMonth = initial.withDayOfMonth(1).with(LocalTime.of(0,0,0));
        LocalDateTime lastDayOfMonth = initial.with(lastDayOfMonth()).with(LocalTime.of(23,59,59));
        LocalDateTime initialDayOfWeek = initial.with(DayOfWeek.MONDAY).with(LocalTime.of(0,0,0));
        LocalDateTime lastDayOfWeek = initial.with(DayOfWeek.SUNDAY).with(LocalTime.of(23,59,59));
        System.out.println(initialDayOfWeek + "," + lastDayOfWeek);
    }
}
