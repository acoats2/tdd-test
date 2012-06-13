package ch.crisi.tdd.gameOfLife;

public abstract class AbstractGridView {
    protected Grid grid;

    abstract void render();
    
    protected void setGrid(Grid grid) {
        this.grid = grid;
    }
}
