package ch.crisi.tdd.gameOfLife;

import javax.swing.*;

public class SwingGridView extends AbstractGridView {

    public SwingGridView() {
        JFrame frame = new JFrame("Game of Life");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setVisible(true);
    }

    @Override
    void draw() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

}
