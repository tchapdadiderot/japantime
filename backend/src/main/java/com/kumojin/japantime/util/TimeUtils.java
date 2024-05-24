package com.kumojin.japantime.util;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class TimeUtils {

    public LocalDateTime convertFromUtcToJst(LocalDateTime dateTime) {
        return convertFromUtcToAnotherTimeZone(dateTime, ZoneId.of("Asia/Tokyo"));
    }

    public LocalDateTime convertFromUtcToAnotherTimeZone(LocalDateTime dateTime, ZoneId zoneId) {
        ZonedDateTime instantInUtc = ZonedDateTime.of(dateTime, ZoneId.of("UTC"));
        return instantInUtc.withZoneSameInstant(zoneId).toLocalDateTime();
    }
}
