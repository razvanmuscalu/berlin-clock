package com.expedia.hotels.berlin_clock;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class BerlinClockTest {

    private BerlinClock sut = new BerlinClock();

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void shouldThrowExceptionWhenInvalidHoursArgumentPassed() {
        thrown.expect(DataValidationException.class);
        thrown.expectMessage("24 out of [0,23] range");

        sut.calculate(24, 0, 0);
    }

    @Test
    public void shouldThrowExceptionWhenNegativeHoursArgumentPassed() {
        thrown.expect(DataValidationException.class);
        thrown.expectMessage("-1 out of [0,23] range");

        sut.calculate(-1, 0, 0);
    }

    @Test
    public void shouldThrowExceptionWhenInvalidMinutesArgumentPassed() {
        thrown.expect(DataValidationException.class);
        thrown.expectMessage("60 out of [0,59] range");

        sut.calculate(0, 60, 0);
    }

    @Test
    public void shouldThrowExceptionWhenNegativeMinutesArgumentPassed() {
        thrown.expect(DataValidationException.class);
        thrown.expectMessage("-1 out of [0,59] range");

        sut.calculate(0, -1, 0);
    }

    @Test
    public void shouldThrowExceptionWhenInvalidHSecondsArgumentPassed() {
        thrown.expect(DataValidationException.class);
        thrown.expectMessage("60 out of [0,59] range");

        sut.calculate(0, 0, 60);
    }

    @Test
    public void shouldThrowExceptionWhenNegativeHSecondsArgumentPassed() {
        thrown.expect(DataValidationException.class);
        thrown.expectMessage("-1 out of [0,59] range");

        sut.calculate(0, 0, -1);
    }
}