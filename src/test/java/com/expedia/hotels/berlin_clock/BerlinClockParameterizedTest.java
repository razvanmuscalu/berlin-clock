package com.expedia.hotels.berlin_clock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(Parameterized.class)
public class BerlinClockParameterizedTest {

    private BerlinClock sut = new BerlinClock();

    @Parameters(name = "{0} hours, {1} minutes, {2} hours")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {0, 0, 0, "Y", "OOOO", "OOOO", "OOOOOOOOOOO", "OOOO"},
                {0, 0, 1, "O", "OOOO", "OOOO", "OOOOOOOOOOO", "OOOO"},
                {5, 0, 2, "Y", "ROOO", "OOOO", "OOOOOOOOOOO", "OOOO"},
                {10, 0, 2, "Y", "RROO", "OOOO", "OOOOOOOOOOO", "OOOO"},
                {15, 0, 2, "Y", "RRRO", "OOOO", "OOOOOOOOOOO", "OOOO"},
                {20, 0, 2, "Y", "RRRR", "OOOO", "OOOOOOOOOOO", "OOOO"},
                {1, 0, 2, "Y", "OOOO", "ROOO", "OOOOOOOOOOO", "OOOO"},
                {2, 0, 2, "Y", "OOOO", "RROO", "OOOOOOOOOOO", "OOOO"},
                {3, 0, 2, "Y", "OOOO", "RRRO", "OOOOOOOOOOO", "OOOO"},
                {4, 0, 2, "Y", "OOOO", "RRRR", "OOOOOOOOOOO", "OOOO"},
                {6, 0, 2, "Y", "ROOO", "ROOO", "OOOOOOOOOOO", "OOOO"},
                {23, 0, 2, "Y", "RRRR", "RRRO", "OOOOOOOOOOO", "OOOO"},
                {0, 5, 2, "Y", "OOOO", "OOOO", "YOOOOOOOOOO", "OOOO"},
                {0, 10, 2, "Y", "OOOO", "OOOO", "YYOOOOOOOOO", "OOOO"},
                {0, 15, 2, "Y", "OOOO", "OOOO", "YYROOOOOOOO", "OOOO"},
                {0, 30, 2, "Y", "OOOO", "OOOO", "YYRYYROOOOO", "OOOO"},
                {0, 55, 2, "Y", "OOOO", "OOOO", "YYRYYRYYRYY", "OOOO"},
                {0, 1, 2, "Y", "OOOO", "OOOO", "OOOOOOOOOOO", "YOOO"},
                {0, 2, 2, "Y", "OOOO", "OOOO", "OOOOOOOOOOO", "YYOO"},
                {0, 4, 2, "Y", "OOOO", "OOOO", "OOOOOOOOOOO", "YYYY"},
                {0, 16, 2, "Y", "OOOO", "OOOO", "YYROOOOOOOO", "YOOO"},
                {0, 19, 2, "Y", "OOOO", "OOOO", "YYROOOOOOOO", "YYYY"},
                {23, 59, 59, "O", "RRRR", "RRRO", "YYRYYRYYRYY", "YYYY"},
        });
    }

    private final int hours;
    private final int minutes;
    private final int seconds;
    private final String pump;
    private final String firstLine;
    private final String secondLine;
    private final String thirdLine;
    private final String fourthLine;

    public BerlinClockParameterizedTest(int hours,
                                        int minutes,
                                        int seconds,
                                        String pump,
                                        String firstLine,
                                        String secondLine,
                                        String thirdLine,
                                        String fourthLine) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
        this.pump = pump;
        this.firstLine = firstLine;
        this.secondLine = secondLine;
        this.thirdLine = thirdLine;
        this.fourthLine = fourthLine;
    }

    @Test
    public void shouldCalculateCorrectly() {
        String result = sut.calculate(hours, minutes, seconds);

        assertThat("should calculate correctly pump", lineAtIndex(result, 0), is(pump));
        assertThat("should calculate correctly first line", lineAtIndex(result, 1), is(firstLine));
        assertThat("should calculate correctly second line", lineAtIndex(result, 2), is(secondLine));
        assertThat("should calculate correctly third line", lineAtIndex(result, 3), is(thirdLine));
        assertThat("should calculate correctly fourth line", lineAtIndex(result, 4), is(fourthLine));
    }

    private String lineAtIndex(String input, int index) {
        String[] lines = input.split("\\r?\\n");

        return lines[index];
    }
}