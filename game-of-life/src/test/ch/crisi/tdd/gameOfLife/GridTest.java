package ch.crisi.tdd.gameOfLife;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class GridTest {

    @Test
    public void shouldCreateNewGridWithSize() {
        Grid grid = new Grid(5);
        junit.framework.Assert.assertEquals(5, grid.getSize());
    }

    @Test
    public void shouldAddDeadCellAtPosition() {
        Grid grid = new Grid(5);
        grid.addDeadCell(0, 0);

        assertEquals(false, grid.isAlive(0, 0));
    }

    @Test
    public void shouldAddLiveCellAtPosition() {
        Grid grid = new Grid(3);
        grid.addLiveCell(1, 1);

        assertEquals(true, grid.isAlive(1, 1));
    }

    @Test
    public void shouldReturnTrueOnDeadCell() {
        Grid grid = new Grid(3);
        grid.addDeadCell(1, 1);

        assertEquals(true, grid.isDead(1, 1));
    }

    @Test
    public void shouldReturnTrueOnLivingCell() {
        Grid grid = new Grid(3);
        grid.addLiveCell(1, 1);

        assertEquals(true, grid.isAlive(1, 1));
    }

    @Test
    public void shouldCountLives() {
        Grid grid = new Grid(3);
        assertEquals(0, grid.countLives());

        grid.addLiveCell(0, 0);
        assertEquals(1, grid.countLives());
    }

    @Test
    public void shouldFillGridWithLives() {
        Grid grid = new Grid(3);
        grid.fillGridWithLives();

        assertEquals(9, grid.countLives());
    }

    @Test
    public void shouldCountLivesAroundCell() {
        Grid grid = new Grid(3);
        grid.fillGridWithLives();

        assertEquals(8, grid.countLivesAround(1, 1));
    }

    @Test
    public void shouldCountLivesAroundBorderCell() {
        Grid grid = new Grid(3);
        grid.fillGridWithLives();

        assertEquals(3, grid.countLivesAround(0, 0));
        assertEquals(3, grid.countLivesAround(0, 2));
        assertEquals(3, grid.countLivesAround(2, 0));
        assertEquals(3, grid.countLivesAround(2, 2));
    }

    @Test
    public void ruleAnyLiveCellWithFewerThanTwoLiveNeighboursDies() {
        //Any live cell with fewer than two live neighbours dies, as if caused by under-population.
        Grid grid = new Grid(3);
        grid.addLiveCell(0, 0);
        grid.addLiveCell(1, 1);
        grid.nextGeneration();

        assertEquals(0, grid.countLives());
    }

    @Test
    public void ruleAnyLiveCellWithTwoLiveNeighboursLivesOn() {
        //Any live cell with two live neighbours lives on to the next generation.
        Grid grid = new Grid(3);
        grid.addLiveCell(1, 1); //center
        grid.addLiveCell(0, 0); //neighbours
        grid.addLiveCell(2, 2);
        grid.nextGeneration();

        assertEquals(true, grid.isAlive(1, 1));
    }

    @Test
    public void ruleAnyLiveCellWithThreeLiveNeighboursLivesOn() {
        //Any live cell with three live neighbours lives on to the next generation.
        Grid grid = new Grid(3);
        grid.addLiveCell(1, 1); //center
        grid.addLiveCell(0, 0); //neighbours
        grid.addLiveCell(2, 0);
        grid.addLiveCell(2, 2);
        grid.nextGeneration();

        assertEquals(true, grid.isAlive(1, 1));
    }

    @Test
    public void ruleAnyLiveCellWithMoreThanThreeLiveNeighboursDies() {
        //Any live cell with more than three live neighbours dies, as if by overcrowding.
        Grid grid = new Grid(3);
        grid.fillGridWithLives();
        grid.nextGeneration();

        assertEquals(false, grid.isAlive(1, 1));
    }

    @Test
    public void ruleAnyDeadCellWithExactlyThreeLiveNeighboursBecomesALiveCell() {
        //Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
        Grid grid = new Grid(3);
        grid.addLiveCell(0, 0); //neighbours
        grid.addLiveCell(0, 1);
        grid.addLiveCell(2, 2);
        grid.nextGeneration();

        assertEquals(true, grid.isAlive(1, 1));
    }

    @Test
    public void shouldReturnFalseIfNoLifes() {
        Grid grid = new Grid(3);

        assertEquals(false, grid.hasLifes());
    }
    
}
    