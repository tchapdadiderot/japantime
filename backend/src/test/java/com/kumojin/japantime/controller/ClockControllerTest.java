package com.kumojin.japantime.controller;

import com.kumojin.japantime.util.TimeUtils;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ClockController.class)
class ClockControllerTest {

    @Autowired
    private MockMvc mockMvc;

    public static Matcher<String> notOlderThanIxMilliseconds(long value) {
        return new BaseMatcher<>() {
            @Override
            public void describeTo(Description description) {
            }

            @Override
            public boolean matches(Object arg0) {
                LocalDateTime nowInJapan = LocalDateTime.parse((String) arg0, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
                final LocalDateTime expected = new TimeUtils().convertFromUtcToJst(LocalDateTime.now(ZoneId.of("UTC")));
                return value >= Duration.between(expected, nowInJapan)
                        .abs()
                        .toMillis();
            }

        };
    }

    @Test
    void getJapanTime() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("/japan-time-now").accept("application/json")
        )
                .andExpect(
                        MockMvcResultMatchers.jsonPath("value").value(notOlderThanIxMilliseconds(500L))
                );
    }

}