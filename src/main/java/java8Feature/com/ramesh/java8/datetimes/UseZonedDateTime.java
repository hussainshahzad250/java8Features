package java8Feature.com.ramesh.java8.datetimes;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

class UseZonedDateTime {

    ZonedDateTime getZonedDateTime(LocalDateTime localDateTime, ZoneId zoneId) {
        return ZonedDateTime.of(localDateTime, zoneId);
    }
}
