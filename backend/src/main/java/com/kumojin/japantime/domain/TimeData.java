package com.kumojin.japantime.domain;

import java.time.LocalDateTime;

public class TimeData {

    private LocalDateTime value;

    public LocalDateTime getValue() {
        return value;
    }

    public void setValue(LocalDateTime value) {
        this.value = value;
    }
}
