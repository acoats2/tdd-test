package ch.crisi.tdd.gameOfLife;

import java.awt.event.MouseListener;

public class CellFactory {
    private CellFactory() {}

    public static SwingCellView createLivingCell(MouseListener listener) {
        SwingCellView c = new SwingCellView(SwingCellView.ALIVE);
        c.addMouseListener(listener);
        return c;
    }

    public static SwingCellView createDeadCell() {
        return new SwingCellView(SwingCellView.DEAD);
    }
}
