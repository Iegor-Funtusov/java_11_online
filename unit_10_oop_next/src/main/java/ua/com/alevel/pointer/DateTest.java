package ua.com.alevel.pointer;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.TimeZone;

public class DateTest {

    public void test() {
        Date date = new Date();
        System.out.println("date = " + date);

        long time = System.currentTimeMillis();
//        System.out.println("time = " + time);

        Date max = new Date(Long.MAX_VALUE);
//        System.out.println("max = " + max);

        Date min = new Date(0);
//        System.out.println("min = " + min);

        OffsetDateTime odt = OffsetDateTime.now();
        System.out.println("odt = " + odt);
        LocalDateTime localDateTime = odt.toLocalDateTime();
//        System.out.println("localDateTime = " + localDateTime);
        ZonedDateTime zonedDateTime = odt.toZonedDateTime();
//        System.out.println("zonedDateTime = " + zonedDateTime);

        TimeZone timeZone = TimeZone.getTimeZone(ZoneId.systemDefault());
        System.out.println("timeZone = " + timeZone);

    }
}
