package ch.crisi.tdd.gameOfLife;

/**
 * A new Cell is ALIVE by default
 */
public class Cell {

    public static final int DEAD = 0;
    public static final int ALIVE = 1;

    private int state;

    public Cell() {
        this(ALIVE);
    }

    public Cell(int state) {
        this.state = state;
    }

    public boolean isAlive() {
        return state == ALIVE ? true : false;
    }

    public boolean isDead() {
        return !isAlive();
    }
    
}
