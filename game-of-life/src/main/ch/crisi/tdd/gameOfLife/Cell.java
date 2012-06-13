package ch.crisi.tdd.gameOfLife;

public class Cell {

    public static final int DEAD = 0;
    public static final int ALIVE = 1;

    private int state;
    private int x, y;

    private Cell() {
    }

    public Cell(int x, int y, int state) {
        this.x = x;
        this.y = y;
        this.state = state;
    }

    public boolean isAlive() {
        return state == ALIVE;
    }

    public boolean isDead() {
        return !isAlive();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
