package ch.crisi.tdd.gameOfLife;

import javax.swing.*;
import java.awt.*;

public class Cell_ extends JLabel {

    public static final int DEAD = 0; //white
    public static final int ALIVE = 1; //black

    private int state;

    private Cell_() {
        super();

        this.setOpaque(true);
        this.setPreferredSize(new Dimension(12, 12));
        this.setBorder(BorderFactory.createLineBorder(Color.WHITE));
    }

    public Cell_(int state) {
        this();

        this.state = state;
        updateCell();

    }

    public void setState(int state) {
        this.state = state;

        updateCell();
    }

    private void updateCell() {

        setBackgroundColor();
    }

    private void setBackgroundColor() {

        if (state == DEAD) {
            this.setBackground(Color.WHITE);
        } else {
            this.setBackground(Color.BLACK);
        }
    }

    public void toggle() {
        if (state == ALIVE) {
            state = DEAD;
        } else {
            state = ALIVE;
        }
        updateCell();
    }

}
