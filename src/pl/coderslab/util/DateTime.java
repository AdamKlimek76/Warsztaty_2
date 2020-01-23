package pl.coderslab.util;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class DateTime {
    public static Timestamp createTimestampNow() {
        LocalDateTime localDateTime = LocalDateTime.now();
        return Timestamp.valueOf(localDateTime);
    }
}
