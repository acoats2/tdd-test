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
    public void testFirstHoursRow() {
        berlinClock.setHour(5);
        assertEquals(berlinClock.getFirstHoursRow().toString(), "1,0,0,0");
    }

    @Test
    public void testSecondHoursRow() {
        berlinClock.setHour(1);
        assertEquals(berlinClock.getSecondHoursRow().toString(), "1,0,0,0");

        berlinClock.setHour(2);
        assertEquals(berlinClock.getSecondHoursRow().toString(), "1,1,0,0");

        berlinClock.setHour(3);
        assertEquals(berlinClock.getSecondHoursRow().toString(), "1,1,1,0");

        berlinClock.setHour(4);
        assertEquals(berlinClock.getSecondHoursRow().toString(), "1,1,1,1");
    }

    @Test
    public void testFirstAndSecondHoursRow() {
        berlinClock.setHour(6);
        assertEquals(berlinClock.getFirstHoursRow().toString(), "1,0,0,0");
        assertEquals(berlinClock.getSecondHoursRow().toString(), "1,0,0,0");
    }

}

