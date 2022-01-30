package com.azad.core.java.java_8.date_time;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * Usually its better to only use UTC-0 in system and db and only apply conversion in frontend side to different zone.
 * Incase we want to store zone in db and system use:
 * @see <a href="https://docs.oracle.com/javase/tutorial/datetime/iso/timezones.html">oracle doc</a>
 * @see <a href="https://stackoverflow.com/questions/19843203/how-to-store-a-datetime-in-mysql-with-timezone-info/59004019">stack overflow discussion</a>
 * @see <a href="https://dev.mysql.com/doc/refman/8.0/en/datetime.html#:~:text=The%20DATE%20type%20is%20used,%2DMM%2DDD%20'%20format.&text=The%20TIMESTAMP%20data%20type%20is,%3A14%3A07'%20UTC.">mysql doc</a>
 *  
 */
public class With_Zone {
    public static void main(String[] args){
        /// - Get the current date and time with zone
        // Obtains an instance of ZonedDateTime from a text string such as 2007-12-03T10:15:30+01:00[Europe/Paris]. 
        // The string must represent a valid date-time and is parsed using java.time.format.DateTimeFormatter.ISO_ZONED_DATE_TIME.
        ZonedDateTime date1 = ZonedDateTime.parse("2007-12-03T10:15:30+05:30[Asia/Karachi]");
        System.out.println("date1: " + date1);
        // A ZoneId is used to identify the rules used to convert between an Instant and a LocalDateTime. There are two distinct types of ID:
        ZoneId id = ZoneId.of("Europe/Paris");
        System.out.println("ZoneId: " + id);
        ZoneId currentZone = ZoneId.systemDefault(); // get current system ZoneId
        System.out.println("CurrentZone: " + currentZone);

        /// - get a ZonedDateTime object from system
        ZonedDateTime zdate = ZonedDateTime.now();
        // print result
        // getOffset() - This is the offset of the local date-time from UTC/Greenwich.
        System.out.println("ZonedDateTime : "+ zdate + ", zone: " + zdate.getZone() + ", offset: " + zdate.getOffset());

        /// - convert localdatetime to zoned date
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        System.out.println("ZoneId.systemDefault(): " + ZoneId.systemDefault());
  
        /// - convert LocalDateTime to ZonedDateTime, with default system zone id
        ZonedDateTime zonedDateTime = now.atZone(ZoneId.systemDefault());
        System.out.println("LocalDateTime to ZonedDateTime, with default system zone id: " + zonedDateTime);

        /// - withZoneSameInstant() - to convert ZonedDateTime to different ZoneId, alternative is withZoneSameLocal() but it will change the zone but keep all the other fields the same might be wrong so better use withZoneSameInstant
        // more at https://stackoverflow.com/questions/55032725/what-is-the-difference-between-zoneddatetime-withzonesameinstant-and-zoneddateti
        ZonedDateTime europeDateTime = zonedDateTime.withZoneSameInstant(ZoneId.of("Europe/Kaliningrad"));
        System.out.println("ZonedDateTime to ZonedDateTime, with specified zoneId: " + europeDateTime);
  
        /// - convert LocalDateTime to OffsetDatetime to ZonedDateTime, with specified off set (unnecessary to use this)
        // atOffset() returns OffsetDateTime
        // toZonedDateTime() returns ZonedDateTime
        // Note using toZonedDateTime() on offsetdatetime will give e.x: 2022-01-30T14:11:13.373414500-05:00 instead of 2022-01-30T08:11:13.373414500+02:00[Europe/Kaliningrad] (without the zoneid naming)
        ZonedDateTime offSetNegative5 = now.atOffset(ZoneOffset.of("-05:00")).toZonedDateTime(); 
        System.out.println("LocalDateTime to ZonedDateTime, with specified off set: " + offSetNegative5 + " , zoneid: " + offSetNegative5.getZone());
  
        /// - display all zone ids
        //ZoneId.getAvailableZoneIds().forEach(System.out::println);

        /// - control date format
        DateTimeFormatter format = DateTimeFormatter.ofPattern("HHmm, dd MMM uuuu");
        LocalDateTime ldt = LocalDateTime.of(2016, Month.AUGUST, 22, 14, 30);
        LocalDateTime ldt2 = LocalDateTime.of(2017, Month.JULY, 18, 14, 30);
        System.out.println("LocalDateTime : " + format.format(ldt));

        /// - chronounits  - API to represent day, month, etc. Let us see them in action.
        ldt = ldt.plus(1, ChronoUnit.MONTHS); // add one month to ldt
        System.out.println(ldt);

        /// - duration and period two specialized classes are introduced to deal with the time differences.
        /**
         * Period − It deals with date based amount of time.
         * Duration − It deals with time based amount of time.
         */
        Period period = Period.between(ldt.toLocalDate(), ldt2.toLocalDate());
        Duration duration = Duration.between(ldt, ldt2);
        System.out.println("Period: " + period);
        System.out.println("Duration: " + duration);

        ///- convert offset to zone
        ZoneOffset currentOffsetForMyZone = ZonedDateTime.now().getOffset();
        System.out.println(currentOffsetForMyZone);
    }
}
