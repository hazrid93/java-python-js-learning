package com.azad.core.java;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        int currentCount = 2;
        int maxResetCount = 3;
        LocalDateTime lastResetDate = LocalDateTime.parse("2023-08-04T10:11:30");
        LocalDateTime currentTime = LocalDateTime.now();
        boolean isRangeExceeded = ChronoUnit.SECONDS.between(lastResetDate, currentTime) > 86400;
        boolean isCountExceeded = ++currentCount > maxResetCount;
        System.out.println(isRangeExceeded);
    }
}
