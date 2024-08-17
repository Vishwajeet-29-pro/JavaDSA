package org.practice.dsa.java8.datetime;

import java.time.LocalDate;
import java.time.LocalTime;

public class DateTimeApi {

    public static void localDateTimeApi() {
        LocalDate date = LocalDate.now();
        System.out.println("The current date is: "+date);

        LocalTime time = LocalTime.now();
        System.out.println("The current time is: "+time);
    }

    public static void main(String[] args) {
        localDateTimeApi();
    }
}
