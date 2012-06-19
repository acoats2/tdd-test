package ch.crisi.tdd.gameOfLife;

import javax.swing.*;
import java.awt.*;

public class SwingGridView extends AbstractGridView {

    private Container contentPane;
    private JFrame frame;

    public SwingGridView(Grid grid) {
        super(grid);

        frame = new JFrame("Game of Life");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setVisible(true);

        frame.setLayout(new BorderLayout());

        frame.setLayout(new GridLayout(grid.getSize(), grid.getSize()));
    }

    @Override
    protected void repaint() {
//        contentPane.repaint();
    }

    @Override
    protected void onNextGeneration() {
        frame.removeAll();
    }

    @Override
    protected void onNewLine() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    protected void renderDeadCell(int x, int y) {
        frame.add(new JLabel("DEAD"));
    }

    @Override
    protected void renderLiveCell(int x, int y) {
        frame.add(new JLabel("LIVE"));
    }

}
