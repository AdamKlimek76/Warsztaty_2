package pl.coderslab.tests;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateAndTimeTests {

    public static void main(String[] args) {

        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime date = LocalDateTime.parse("2019-12-12 21:00", format);
        java.sql.Timestamp datetime = Timestamp.valueOf(date);
        System.out.println(datetime);
        Timestamp timestamp = Timestamp.valueOf("2019-12-31 23:00:45");
        System.out.println(timestamp);
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        Timestamp timestamp1 = Timestamp.valueOf(localDateTime);
        System.out.println(timestamp1);
    }
}
