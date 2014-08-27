package ch.crisi.tdd.berlinclock;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ColorTest {

    @Test
    public void testRed() {
        assertEquals("R", Color.RED.toString());
    }

    @Test
    public void testYellow() {
        assertEquals("Y", Color.YELLOW.toString());
    }

}
