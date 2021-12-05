package entity;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.lang.*;

public class Rental {

    private long FULL_DAY_PRICE = 200000;
    private long FULL_DAY = 12;
    private long HOUR_EARLY_REFUND = 10000;
    private long EXCEED_PRICING = 2000;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public long calculateRent(String startTimeString, String endTimeString) {
        LocalDateTime startTime = LocalDateTime.parse(startTimeString, formatter);
        LocalDateTime endTime = LocalDateTime.parse(endTimeString, formatter);

        Duration d = Duration.between(startTime, endTime);
        long hours = d.toHours();
        long minutes = d.toMinutes();
        boolean exceedFullDay = (minutes - FULL_DAY * 60) < 0;

        if (exceedFullDay) {
            long hoursDiff = FULL_DAY - hours;
            return FULL_DAY_PRICE - hoursDiff * HOUR_EARLY_REFUND;
        } else {
            // case greater, need to pay more
            long minutesDiff = minutes - FULL_DAY * 60; // 0 case on previous branch
            return (long) (FULL_DAY_PRICE + Math.floor((double) minutesDiff / 15) * EXCEED_PRICING);
        }
    }

    public long calculateRefund(String startTimeString, String endTimeString, long paidAmount) {
        long rent = calculateRent(startTimeString, endTimeString);
        if (rent > paidAmount) {
            return paidAmount - rent;
        } else {
            return 0;
        }
    }

    public long hello(String x) {
        return 1;
    }
}
