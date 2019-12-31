package pl.coderslab;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Main {

    public static void main(String [] args){

        DateTimeFormatter format=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime date=LocalDateTime.parse("2019-12-12 21:00", format);
        java.sql.Timestamp datetime = Timestamp.valueOf(date);
        System.out.println(datetime);
        Timestamp timestamp=Timestamp.valueOf("2019-12-31 23:00:45");
        System.out.println(timestamp);
    }
}
