package com.mine.tutorials.date;

import com.mine.tutorials.lambda.Person;
import com.mine.tutorials.stream.CollectorsExample;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

/**
 * @stefanl
 */
public class DateAndTimeExample {
    public static void main(String... args) {
        List<Person> list = new ArrayList<>();

        ClassLoader classLoader = CollectorsExample.class.getClassLoader();

        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(classLoader.getResource("people.txt").getFile())));
                Stream<String> stream = br.lines();
        ) {
            stream.map(line -> {
                String[] s = line.split(" ");
                String name = s[0].trim();
                int year = Integer.parseInt(s[1]);
                Month month = Month.of(Integer.parseInt(s[2]));
                int day = Integer.valueOf(s[3]);
                Person p = new Person(s[0].trim(), LocalDate.of(year, month, day));
                list.add(p);
                return p;
            }).forEach(System.out::println);
        } catch (Exception e) {
            System.out.println(e);
        }

        LocalDate now = LocalDate.of(2014, Month.MARCH, 12);

        list.stream().forEach(
                p -> {
                    Period period = Period.between(p.getDayOfBirth(), now);
                    System.out.println(p.getFirstName() + " was born " + period.get(ChronoUnit.YEARS) + " years and " +
                            period.get(ChronoUnit.MONTHS) + " months " +
                            "[" + p.getDayOfBirth().until(now, ChronoUnit.MONTHS) + " months]");
                }
        );

        LocalDate now2= LocalDate.now();
        System.out.println(now2);
        LocalDate nextSunday = now2.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
        System.out.println(nextSunday);

        Instant nowInstant = Instant.now();
        System.out.println(nowInstant);

        LocalTime nowLT  = LocalTime.of(10,20);
        LocalTime laterLT  = nowLT.plusHours(3);
        System.out.println(laterLT);

        Set<String> allZoneIds = ZoneId.getAvailableZoneIds();
        System.out.println(allZoneIds);

        ZoneId ukTZ = ZoneId.of("Europe/London");
        ZonedDateTime currentMeeting = ZonedDateTime.of(2014, Month.APRIL.getValue(), 12, 9, 30, 0,
                0,ukTZ);
        System.out.println(currentMeeting);

        ZonedDateTime nextMeeting =currentMeeting.plusMonths(1);
        System.out.println(nextMeeting);
        ZonedDateTime nextMeetingUS =nextMeeting.withZoneSameInstant(ZoneId.of("US/Central"));
        System.out.println(nextMeetingUS);


        System.out.println(DateTimeFormatter.ISO_DATE_TIME.format(nextMeetingUS));
        System.out.println(DateTimeFormatter.RFC_1123_DATE_TIME.format(nextMeetingUS));
    }
}
