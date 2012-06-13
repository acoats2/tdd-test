package ch.crisi.tdd.gameOfLife;

/**
 * A new Grid is filled with dead Cells by default
 */
public class Grid {
    private Cell[][] cells, cellsBuffer;

    public Grid(int size) {
        cells = new Cell[size][size];
        fillGridWithDeadCells();
    }

    public int getSize() {
        return cells.length;
    }

    public boolean isAlive(int x, int y) {
        return cells[x][y].isAlive();
    }


    public int countLivesAround(int x, int y) {
        int counter = 0;
        int xLowBound = x - 1 < 0 ? 0 : x - 1;
        int yLowBound = y - 1 < 0 ? 0 : y - 1;
        int xHighBound = x + 1 > cells.length - 1 ? cells.length - 1 : x + 1;
        int yHighBound = y + 1 > cells.length - 1 ? cells.length - 1 : y + 1;

        for (int i = xLowBound; i <= xHighBound; i++) {
            for (int j = yLowBound; j <= yHighBound; j++) {
                if (!(i == x && j == y)) { //if not the center cell
                    if (cells[i][j].isAlive()) {
                        counter++;
                    }
                }
            }
        }

        return counter;
    }

    public int countLives() {
        int counter = 0;

        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                if (cells[i][j].isAlive()) {
                    counter++;
                }
            }
        }

        return counter;
    }

    public void nextGeneration() {
        cellsBuffer = new Cell[cells.length][cells.length];
        fillBufferWithDeadCells();

        for (int x = 0; x < cells.length; x++) {
            for (int y = 0; y < cells[x].length; y++) {
                Cell c = cells[x][y];

                if (liveCellHasFewerThanTwoLiveNeighbours(c)) {
                    addDeadCellToBuffer(x, y);
                } else if (liveCellHasTwoOrThreeLiveNeighbours(c)) {
                    addLiveCellToBuffer(x, y);
                } else if (liveCellHasMoreThanThreeLiveNeighbours(c)) {
                    addDeadCellToBuffer(x, y);
                } else if (deadCellHasExactlyThreeLiveNeighbours(c)) {
                    addLiveCellToBuffer(x, y);
                }
            }
        }

        cells = cellsBuffer;
    }

    private void fillGridWithDeadCells() {
        for (int x = 0; x < cells.length; x++) {
            for (int y = 0; y < cells[x].length; y++) {
                addDeadCell(x, y);
            }
        }
    }

    private void fillBufferWithDeadCells() {
        for (int x = 0; x < cellsBuffer.length; x++) {
            for (int y = 0; y < cellsBuffer.length; y++) {
                addDeadCellToBuffer(x, y);
            }
        }
    }

    private boolean deadCellHasExactlyThreeLiveNeighbours(Cell c) {
        return c.isDead() && countLivesAround(c.getX(), c.getY()) == 3;
    }

    private boolean liveCellHasMoreThanThreeLiveNeighbours(Cell c) {
        return c.isAlive() && countLivesAround(c.getX(), c.getY()) > 3;
    }

    private boolean liveCellHasTwoOrThreeLiveNeighbours(Cell c) {
        return c.isAlive() && (countLivesAround(c.getX(), c.getY()) == 2 || countLivesAround(c.getX(), c.getY()) == 3);
    }

    private boolean liveCellHasFewerThanTwoLiveNeighbours(Cell c) {
        return c.isAlive() && countLivesAround(c.getX(), c.getY()) < 2;
    }

    public void fillGridWithLives() {
        for (int x = 0; x < cells.length; x++) {
            for (int y = 0; y < cells[x].length; y++) {
                addLiveCell(x, y);
            }
        }
    }

    public boolean isDead(int x, int y) {
        return cells[x][y].isDead();
    }

    public void addDeadCell(int x, int y) {
        cells[x][y] = new Cell(x, y, Cell.DEAD);
    }

    private void addDeadCellToBuffer(int x, int y) {
        cellsBuffer[x][y] = new Cell(x, y, Cell.DEAD);
    }

    public void addLiveCell(int x, int y) {
        cells[x][y] = new Cell(x, y, Cell.ALIVE);
    }

    private void addLiveCellToBuffer(int x, int y) {
        cellsBuffer[x][y] = new Cell(x, y, Cell.ALIVE);
    }

    public boolean hasLifes() {
        return countLives() > 0;
    }
}