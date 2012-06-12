package ch.crisi.tdd.gameOfLife;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class CellTest {

    @Test
    public void shouldCreateLiveCellAtPosition() {
        Cell cell = new Cell(0, 0, Cell.ALIVE);

        assertEquals(true, cell.isAlive());
        assertEquals(0, cell.getX());
        assertEquals(0, cell.getY());
    }

    @Test
    public void shouldCreateDeadCellAtPosition() {
        Cell cell = new Cell(0, 0, Cell.DEAD);

        assertEquals(false, cell.isAlive());
        assertEquals(0, cell.getX());
        assertEquals(0, cell.getY());
    }

}
