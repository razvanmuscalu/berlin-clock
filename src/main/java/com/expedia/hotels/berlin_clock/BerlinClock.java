package com.expedia.hotels.berlin_clock;

import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.stream.IntStream;

import static com.expedia.hotels.berlin_clock.MathFunction.*;
import static java.lang.String.format;
import static java.util.stream.Collectors.joining;
import static java.util.stream.IntStream.rangeClosed;
import static java.util.stream.Stream.of;

public class BerlinClock {

    private final static int ZERO = 0;
    private final static int MAX_HOURS = 23;
    private final static int MAX_MINUTES = 59;
    private final static int MAX_SECONDS = 59;

    private static final String OFF = "O";
    private static final String RED = "R";
    private static final String YELLOW = "Y";

    private static final String NEW_LINE = "\n";
    private static final String EMPTY_STRING = "";

    private static final String VALIDATION_MESSAGE = "%d out of [%d,%d] range";

    public String calculate(int hours, int minutes, int seconds) {
        validateArgument(hours, ZERO, MAX_HOURS);
        validateArgument(minutes, ZERO, MAX_MINUTES);
        validateArgument(seconds, ZERO, MAX_SECONDS);


        final String pump = toColour(YELLOW, OFF).apply(remainder(seconds, 2).apply() == 0);
        final String firstLine = fillShortLine(rangeClosed(0, 3), lessThan(quotient(hours, 5)), toColour(RED, OFF));
        final String secondLine = fillShortLine(rangeClosed(0, 3), lessThan(remainder(hours, 5)), toColour(RED, OFF));
        final String thirdLine = fillLongLine(rangeClosed(0, 10), lessThan(quotient(minutes, 5)), toColour(RED, YELLOW), OFF);
        final String fourthLine = fillShortLine(rangeClosed(0, 3), lessThan(remainder(minutes, 5)), toColour(YELLOW, OFF));


        return of(pump, firstLine, secondLine, thirdLine, fourthLine).reduce(joinOn(NEW_LINE)).orElse(EMPTY_STRING);
    }

    private static void validateArgument(int argument, int minValue, int maxValue) {
        if (argument < minValue || argument > maxValue)
            throw new DataValidationException(format(VALIDATION_MESSAGE, argument, minValue, maxValue));
    }

    private static String fillShortLine(IntStream line, IntFunction<Boolean> lessThan, Function<Boolean, String> toColour) {
        return line
                .mapToObj(lessThan)
                .map(toColour)
                .collect(joining());
    }

    private static String fillLongLine(IntStream line, IntFunction<Boolean> lessThan, Function<Boolean, String> toQuarterColour, String offColour) {
        return line
                .mapToObj(index -> {
                    String colour = toQuarterColour.apply(remainder(index, 3).apply() == 2);
                    return toColour(colour, offColour).apply(lessThan.apply(index));
                })
                .collect(joining());
    }

    private static Function<Boolean, String> toColour(String onColour, String offColour) {
        return flag -> flag ? onColour : offColour;
    }

    private static BinaryOperator<String> joinOn(String connector) {
        return (allSoFar, nextElement) -> allSoFar + connector + nextElement;
    }

}