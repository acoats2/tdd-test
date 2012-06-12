package ch.crisi.tdd.gameOfLife;

import java.awt.event.MouseListener;

public class CellFactory {
    private CellFactory() {}

    public static Cell createLivingCell(MouseListener listener) {
        Cell c = new Cell(Cell.ALIVE);
        c.addMouseListener(listener);
        return c;
    }

    public static Cell createDeadCell() {
        return new Cell(Cell.DEAD);
    }
}
