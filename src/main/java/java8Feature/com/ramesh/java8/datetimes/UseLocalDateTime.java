package java8Feature.com.ramesh.java8.datetimes;

import java.time.LocalDateTime;

public class UseLocalDateTime {

    public LocalDateTime getLocalDateTimeUsingParseMethod(String representation) {
        return LocalDateTime.parse(representation);
    }

}
