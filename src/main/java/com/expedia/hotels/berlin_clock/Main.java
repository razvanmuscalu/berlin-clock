package com.expedia.hotels.berlin_clock;

import static java.util.stream.Stream.of;

public class Main {

    public static void main(String[] args) {
        BerlinClock bc = new BerlinClock();

        try {
            of(bc.calculate(Integer.valueOf(args[0]), Integer.valueOf(args[1]), Integer.valueOf(args[2])))
                    .forEach(System.out::println);
        } catch (DataValidationException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("You must have passed something invalid");
        }
    }

}
