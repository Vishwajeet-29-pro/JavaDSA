package org.practice.dsa.java8.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class DateTimeApi {

    public static void localDateTimeApi() {
        LocalDate date = LocalDate.now();
        System.out.println("The current date is: "+date);

        LocalTime time = LocalTime.now();
        System.out.println("The current time is: "+time);

        LocalDateTime current = LocalDateTime.now();
        System.out.println("Current date and time is "+current);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-YYYY HH:mm:SS");
        String formatedDateTime = current.format(formatter);

        System.out.println("In formatted manner "+formatedDateTime);

        Month month = current.getMonth();
        int day = current.getDayOfMonth();
        int year = current.getYear();

        System.out.println("Month: "+month+" Day: "+day+" Year: "+year);

        LocalDate date1 = LocalDate.of(1950, 1, 26);
        System.out.println("The First Republic Day : "+date1);

        LocalDateTime specificDate = current.withDayOfMonth(24).withYear(2016);
        System.out.println("Specific date with current time: "+specificDate);
    }

    public static void main(String[] args) {
        localDateTimeApi();
    }
}
