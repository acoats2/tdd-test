package ch.crisi.tdd.gameOfLife;

public abstract class AbstractGridView {
    private Grid grid;
    private long timeout;


    public AbstractGridView(Grid grid) {
        this.grid = grid;
        this.timeout = 0;
    }

    protected void startRenderLoop() {
        while (grid.hasLifes()) {
            renderGrid();
            timeout();
            nextGeneration();
        }
        renderGrid(); //renderGrid the dead state
    }

    private void timeout() {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void nextGeneration() {
        grid.nextGeneration();
        onNextGeneration();
    }

    protected void setTimeout(long ms) {
        this.timeout = ms;
    }

    protected void renderGrid() {
        for (int x = 0; x < grid.getSize(); x++) {
            for (int y = 0; y < grid.getSize(); y++) {
                if (grid.isAlive(x, y)) {
                    renderLiveCell(x, y);
                } else {
                    renderDeadCell(x, y);
                }

                if(y == grid.getSize() - 1) {
                    onNewLine();
                }

                repaint();
            }
        }
    }

    protected abstract void repaint();

    protected abstract void onNewLine();
    
    protected abstract void onNextGeneration();

    protected abstract void renderDeadCell(int x, int y);

    protected abstract void renderLiveCell(int x, int y);
}
