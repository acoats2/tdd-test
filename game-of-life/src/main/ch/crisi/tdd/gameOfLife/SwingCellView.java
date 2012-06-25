package ch.crisi.tdd.gameOfLife;

import javax.swing.*;
import java.awt.*;

public class SwingCellView extends JLabel {

    public static final int DEAD = 0; //white
    public static final int ALIVE = 1; //black

    private int state;

    private SwingCellView() {
        super();

        this.setOpaque(true);
        this.setPreferredSize(new Dimension(12, 12));
        this.setBorder(BorderFactory.createLineBorder(Color.WHITE));
    }

    public SwingCellView(int state) {
        this();

        this.state = state;
        setBackgroundColor();

    }

    private void setBackgroundColor() {

        if (state == DEAD) {
            this.setBackground(Color.WHITE);
        } else {
            this.setBackground(Color.BLACK);
        }
    }

}
