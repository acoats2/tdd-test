package ch.crisi.tdd.berlinclock;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BerlinClockTest {

    private BerlinClock berlinClock;

    @Before
    public void setUp() {
        berlinClock = new BerlinClock();
    }


    @Test
    public void testEvenSeconds() {
        berlinClock.setSeconds(2);

        assertEquals("Y", berlinClock.getSecondsLamp().toString());
    }

    @Test
    public void testOddSeconds() {
        berlinClock.setSeconds(3);

        assertEquals("0", berlinClock.getSecondsLamp().toString());
    }

    @Test
    public void testFiveHoursRow() {
        berlinClock.setHours(15);

        assertEquals("R,R,R,0", berlinClock.getFiveHoursRow().toString());
    }

    @Test
    public void testOneHourRow() {
        berlinClock.setHours(2);

        assertEquals("R,R,0,0", berlinClock.getOneHourRow().toString());
    }

    @Test
    public void testFiveMinutesRow() {
        berlinClock.setMinutes(20);

        assertEquals("Y,Y,R,Y,0,0,0,0,0,0,0", berlinClock.getFiveMinutesRow().toString());
    }

    @Test
    public void testOneMinuteRow() {
        berlinClock.setMinutes(2);

        assertEquals("Y,Y,0,0", berlinClock.getOneMinuteRow().toString());
    }

    @Test
    public void testOneOclock() {
        berlinClock.setHours(1);

        assertEquals("R,0,0,0", berlinClock.getOneHourRow().toString());
    }

    @Test
    public void testThreeOclock() {
        berlinClock.setHours(3);

        assertEquals("R,R,R,0", berlinClock.getOneHourRow().toString());
    }

    @Test
    public void testFiveOclock() {
        berlinClock.setHours(5);

        assertEquals("R,0,0,0", berlinClock.getFiveHoursRow().toString());
    }

    @Test
    public void testSevenOclock() {
        berlinClock.setHours(7);

        assertEquals("R,0,0,0", berlinClock.getFiveHoursRow().toString());
        assertEquals("R,R,0,0", berlinClock.getOneHourRow().toString());
    }

    @Test
    public void testAQuarterPastNine() {
        berlinClock.setHours(9).setMinutes(15);

        assertEquals("R,0,0,0", berlinClock.getFiveHoursRow().toString());
        assertEquals("R,R,R,R", berlinClock.getOneHourRow().toString());
        assertEquals("Y,Y,R,0,0,0,0,0,0,0,0", berlinClock.getFiveMinutesRow().toString());
    }

    @Test
    public void testSeventeenPastEleven() {
        berlinClock.setHours(11).setMinutes(17);

        assertEquals("R,R,0,0", berlinClock.getFiveHoursRow().toString());
        assertEquals("R,0,0,0", berlinClock.getOneHourRow().toString());
        assertEquals("Y,Y,R,0,0,0,0,0,0,0,0", berlinClock.getFiveMinutesRow().toString());
        assertEquals("Y,Y,0,0", berlinClock.getOneMinuteRow().toString());
    }

    @Test
    public void testNewHour() {
        berlinClock.setHours(11).setMinutes(59);

        assertEquals("R,R,0,0", berlinClock.getFiveHoursRow().toString());
        assertEquals("R,0,0,0", berlinClock.getOneHourRow().toString());
        assertEquals("Y,Y,R,Y,Y,R,Y,Y,R,Y,Y", berlinClock.getFiveMinutesRow().toString());
        assertEquals("Y,Y,Y,Y", berlinClock.getOneMinuteRow().toString());

        berlinClock.setHours(12).setMinutes(0);
        assertEquals("R,R,0,0", berlinClock.getFiveHoursRow().toString());
        assertEquals("R,R,0,0", berlinClock.getOneHourRow().toString());
        assertEquals("0,0,0,0,0,0,0,0,0,0,0", berlinClock.getFiveMinutesRow().toString());
        assertEquals("0,0,0,0", berlinClock.getOneMinuteRow().toString());

    }

}

