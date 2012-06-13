package ch.crisi.tdd.gameOfLife;

public abstract class AbstractGridView {
    protected Grid grid;

    protected void startRenderLoop() {
        while (grid.hasLifes()) {
            draw();
            grid.nextGeneration();
        }
        draw(); //draw the dead state
    }

    protected void setGrid(Grid grid) {
        this.grid = grid;
    }

    abstract void draw();
}
