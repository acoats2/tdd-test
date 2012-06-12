package ch.crisi.tdd.gameOfLife;

import java.awt.*;

/**
 * A new Cell is ALIVE by default
 */
public class Cell extends Point {

    public static final int DEAD = 0;
    public static final int ALIVE = 1;

    private int state;

    public Cell() {
        this.state = ALIVE;
    }

    public Cell(int state) {
        this.state = state;
    }

    public boolean isAlive() {
        return state == ALIVE ? true : false;
    }

}
