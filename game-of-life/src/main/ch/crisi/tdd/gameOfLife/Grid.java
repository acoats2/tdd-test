package ch.crisi.tdd.gameOfLife;

import org.apache.commons.lang3.ArrayUtils;

/**
 * A new Grid is filled with dead Cells by default
 */
public class Grid {
    private Cell[][] cells;

    public Grid(int size) {
        cells = new Cell[size][size];
        for (int x = 0; x < cells.length; x++) {
            for (int y = 0; y < cells[x].length; y++) {
                cells[x][y] = new Cell(Cell.DEAD);
            }
        }
    }

    public int getSize() {
        return cells.length;
    }

    public void put(Cell cell, int x, int y) {
        cells[x][y] = cell;
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

    public Cell[][] getCells() {
        return cells;
    }

/*    public void kill(int x, int y) {
        Cell c = getCell(x, y);
        kill(c);
    }*/

/*    private List<Cell> kill(Cell c) {
        if (isAlive(c)) {
            cellsBuffer.remove(c);
            return cellsBuffer;
        }

        return cells;
    }*/

/*    private Cell getCell(int x, int y) {
        for (Cell cell : cells) {
            if (cell.getXPos() == x && cell.getYPos() == y) {
                return cell;
            }
        }

        return new Cell(-1, -1);
    }*/


    /*    Any live cell with fewer than two live neighbours dies, as if caused by under-population.
Any live cell with two or three live neighbours lives on to the next generation.
Any live cell with more than three live neighbours dies, as if by overcrowding.
Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.*/

    public void nextGeneration() {
        Cell[][] cellsCopy = ArrayUtils.clone(cells);

        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                Cell c = cells[i][j];

                //Any live cell with fewer than two live neighbours dies, as if caused by under-population.
                if (c.isAlive() && countLivesAround(i, j) < 2) {
                    cellsCopy[i][j] = new Cell(Cell.DEAD);
                }
            }
        }

        cells = cellsCopy;
    }

    public void fillGridWithLives() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j] = new Cell();
            }
        }
    }


}
