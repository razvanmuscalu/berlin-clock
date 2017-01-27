Instructions:

<<<mvn clean test>>> in berlin-clock directory will run all tests.
<<<mvn exec:java -Dexec.mainClass="com.expedia.hotels.berlin_clock.Main" -Dexec.args="13 30 35">>> will run the code with the provided arguments. Feel free to pass whatever you want.


Colour representation:

O = off
Y = yellow
R = red


Couple of considerations:

I wrote only business logic. In the real world, e.g. in a microservice, this would be contained within other frameworks (e.g. Spring).
I only wrote unit tests (not even mocking since there was no need). In the real world, mocks for unit tests, integration tests, behvaiour tests (cucumber) would be written.
I only used System.out, but in the real world, a logger would be used.
I went for maven since this is what I use in current role. I have also used gradle in the past.

These decisions were made because the requirements were aimed at core logic and testing, rather than frameworks and their use.



=======================================================================================================================================



Requirements:
 
1) Implement the Berlin Clock as a function of the three parameters: hours (24-based), minutes, seconds and return a multi line string.
2) Find a reasonable representation for the colors and states.
3) Provide instructions on how to run it.
 
Berlin Clock description: The time is calculated by adding the lit
rectangular lamps. The top lamp is a pump which is blinking on/off every
two seconds. In the topmost line of red lamps every lamp represents 5
hours. In the second line of red lamps every lamp represents 1 hour. So
if in the first line 2 lamps are lit and in the second line 3 lamps its
5+5+3=13h or 1 p.m. In the third line with tall lamps every lamp
represents 5 minutes. There are 11 lamps, the 3rd, 6th, and 9th are red
indicating the first quarter, half, and the last quarter of the hour. In
the last line with yellow lamps every lamp represents 1 minute.​
 
Your implementation would be evaluated based on(not limited to) the following criteria
 
1) Correctness of implementation.
2) Tests
3) Design
 
Please implement the way you would write production code.