package com.kumojin.japantime.controller;

import com.kumojin.japantime.domain.TimeData;
import com.kumojin.japantime.util.TimeUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Controller
public class ClockController {

    @GetMapping("/japan-time-now")
    @ResponseBody
    public TimeData getCurrentTimeInJapan() {
        final TimeData timeData = new TimeData();
        timeData.setValue(new TimeUtils().convertFromUtcToJst(LocalDateTime.now(ZoneId.of("UTC"))));
        return timeData;
    }
}
