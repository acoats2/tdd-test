package ch.crisi.tdd.berlinclock;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RowTest {

    @Test
    public void testNoLamps() {
        final Row row = new Row(4, Color.YELLOW);

        assertEquals("0,0,0,0", row.toString());
    }

    @Test
    public void testThreeYellowLamps() {
        final Row row = new Row(4, Color.YELLOW);
        row.turnOn(3);

        assertEquals("Y,Y,Y,0", row.toString());
    }

    @Test
    public void testThreeRedLamps() {
        final Row row = new Row(4, Color.RED);
        row.turnOn(3);

        assertEquals("R,R,R,0", row.toString());
    }

    @Test
    public void testLampOverflow() {
        final Row row = new Row(4, Color.YELLOW);
        row.turnOn(4);

        assertEquals("Y,Y,Y,Y", row.toString());

        row.turnOn(1);

        assertEquals("Y,0,0,0", row.toString());
    }

    @Test
    public void testChangeColor() {
        final Row row = new Row(4, Color.YELLOW);
        row.turnOn(3);
        row.changeColor(Color.RED, 1,2);

        assertEquals("R,R,Y,0", row.toString());
    }

}
