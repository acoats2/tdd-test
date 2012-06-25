package ch.crisi.tdd.gameOfLife;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class GridTest {

    private Grid grid;

    @Before
    public void setUp() throws Exception {
        grid = new Grid(3);

    }

    @Test
    public void shouldCreateNewGridWithSize() {
        grid.setSize(5);
        junit.framework.Assert.assertEquals(5, grid.getSize());
    }

    @Test
    public void shouldAddDeadCellAtPosition() {
        grid.addDeadCell(0, 0);

        assertEquals(true, grid.isDead(0, 0));
    }

    @Test
    public void shouldAddLiveCellAtPosition() {
        grid.addLiveCell(1, 1);

        assertEquals(true, grid.isAlive(1, 1));
    }

    @Test
    public void shouldReturnTrueOnDeadCell() {
        grid.addDeadCell(1, 1);

        assertEquals(true, grid.isDead(1, 1));
    }

    @Test
    public void shouldReturnTrueOnLivingCell() {
        grid.addLiveCell(1, 1);

        assertEquals(true, grid.isAlive(1, 1));
    }

    @Test
    public void shouldCountLives() {
        assertEquals(0, grid.countLives());

        grid.addLiveCell(0, 0);
        assertEquals(1, grid.countLives());
    }

    @Test
    public void shouldFillGridWithLives() {
        grid.fillGridWithLives();

        assertEquals(9, grid.countLives());
    }

    @Test
    public void shouldCountLivesAroundCell() {
        grid.fillGridWithLives();

        assertEquals(8, grid.countLivesAround(1, 1));
    }

    @Test
    public void shouldCountLivesAroundBorderCell() {
        grid.fillGridWithLives();

        assertEquals(3, grid.countLivesAround(0, 0));
        assertEquals(3, grid.countLivesAround(0, 2));
        assertEquals(3, grid.countLivesAround(2, 0));
        assertEquals(3, grid.countLivesAround(2, 2));
    }

    @Test
    public void ruleAnyLiveCellWithFewerThanTwoLiveNeighboursDies() {
        grid.addLiveCell(0, 0);
        grid.addLiveCell(1, 1);
        grid.nextGeneration();

        assertEquals(0, grid.countLives());
    }

    @Test
    public void ruleAnyLiveCellWithTwoLiveNeighboursLivesOn() {
        grid.addLiveCell(1, 1); //center
        grid.addLiveCell(0, 0); //neighbours
        grid.addLiveCell(2, 2);
        grid.nextGeneration();

        assertEquals(true, grid.isAlive(1, 1));
    }

    @Test
    public void ruleAnyLiveCellWithThreeLiveNeighboursLivesOn() {
        grid.addLiveCell(1, 1); //center
        grid.addLiveCell(0, 0); //neighbours
        grid.addLiveCell(2, 0);
        grid.addLiveCell(2, 2);
        grid.nextGeneration();

        assertEquals(true, grid.isAlive(1, 1));
    }

    @Test
    public void ruleAnyLiveCellWithMoreThanThreeLiveNeighboursDies() {
        grid.fillGridWithLives();
        grid.nextGeneration();

        assertEquals(false, grid.isAlive(1, 1));
    }

    @Test
    public void ruleAnyDeadCellWithExactlyThreeLiveNeighboursBecomesALiveCell() {
        grid.addLiveCell(0, 0); //neighbours
        grid.addLiveCell(0, 1);
        grid.addLiveCell(2, 2);
        grid.nextGeneration();

        assertEquals(true, grid.isAlive(1, 1));
    }

    @Test
    public void shouldReturnFalseIfNoLifes() {
        assertEquals(false, grid.hasLifes());
    }
    
}