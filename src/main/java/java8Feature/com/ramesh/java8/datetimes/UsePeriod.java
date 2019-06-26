package java8Feature.com.ramesh.java8.datetimes;

import java.time.LocalDate;
import java.time.Period;

class UsePeriod {

    LocalDate modifyDates(LocalDate localDate, Period period) {
        return localDate.plus(period);
    }

    Period getDifferenceBetweenDates(LocalDate localDate1, LocalDate localDate2) {
        return Period.between(localDate1, localDate2);
    }
}
