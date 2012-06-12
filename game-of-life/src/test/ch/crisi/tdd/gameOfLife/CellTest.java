package ch.crisi.tdd.gameOfLife;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class CellTest {

    @Test
    public void shouldCreateAliveCell() {
        Cell cell1 = new Cell();
        assertEquals(true, cell1.isAlive());

        Cell cell2 = new Cell(Cell.ALIVE);
        assertEquals(true, cell2.isAlive());
    }

    @Test
    public void shouldCreateDeadCell() {
        Cell cell = new Cell(Cell.DEAD);
        assertEquals(false, cell.isAlive());
    }

}
