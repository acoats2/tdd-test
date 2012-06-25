package ch.crisi.tdd.gameOfLife;

import javax.swing.*;
import java.awt.*;

public class SwingGridView extends AbstractGridView {

    private JPanel panel;

    public SwingGridView(Grid grid) {
        super(grid);

        JFrame frame = new JFrame("Game of Life");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(grid.getSize() * 5, grid.getSize() * 5);
        frame.setVisible(true);

        panel = new JPanel(new GridLayout(grid.getSize(), grid.getSize()), true);
        frame.add(panel);
    }

    @Override
    protected void repaint() {
        panel.updateUI();
    }

    @Override
    protected void onNextGeneration() {
        panel.removeAll();
    }

    @Override
    protected void onNewLine() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    protected void renderDeadCell(int x, int y) {
        panel.add(new SwingCellView(SwingCellView.DEAD));
    }

    @Override
    protected void renderLiveCell(int x, int y) {
        panel.add(new SwingCellView(SwingCellView.ALIVE));
    }

}
