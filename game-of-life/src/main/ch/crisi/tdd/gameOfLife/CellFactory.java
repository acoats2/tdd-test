package ch.crisi.tdd.gameOfLife;

import java.awt.event.MouseListener;

public class CellFactory {
    private CellFactory() {}

    public static Cell_ createLivingCell(MouseListener listener) {
        Cell_ c = new Cell_(Cell_.ALIVE);
        c.addMouseListener(listener);
        return c;
    }

    public static Cell_ createDeadCell() {
        return new Cell_(Cell_.DEAD);
    }
}
