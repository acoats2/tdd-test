package ch.crisi.tdd.gameOfLife;

import ch.crisi.tdd.gameOfLife.rules.AliveCellWithFewerThanTwoAliveNeighboursDies;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class GridTest {

    @Test
    public void shouldCreateNewGridWithSize() {
        Grid grid = new Grid(5);
        junit.framework.Assert.assertEquals(5, grid.getSize());
    }

    @Test
    public void shouldPlaceCellOnGrid() {
        Grid grid = new Grid(5);
        grid.put(new Cell(), 0, 0);

        assertEquals(true, grid.isAlive(0, 0));
    }

    @Test
    public void shouldCountLives() {
        Grid grid = new Grid(3);
        assertEquals(0, grid.countLives());

        grid.put(new Cell(), 0, 0);
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

/*    @Test
    public void shouldKillCell() {
        Grid grid = new Grid(3);
        grid.fillAll();
        grid.kill(1, 1); 

        assertEquals(false, grid.isAlive(1, 1));
        assertEquals(8, grid.countLives());
    }*/

/*    @Test
    public void cellWithFewerThan2LivingNeighboursShouldDie() {
        Grid grid = new Grid(3);
        grid.put(new Cell(0, 0));
        grid.put(new Cell(1, 1));
        grid.killCellsWithFewerThan2LivingNeighbours();
        grid.nextGeneration();

        assertEquals(false, grid.isAlive(1, 1));
    }*/

    @Test
    public void shouldCreateNextGeneration() {
        Grid grid = new Grid(3);
        grid.put(new Cell(), 0, 0);
        grid.put(new Cell(), 1, 1);
        grid.nextGeneration();

        assertEquals(0, grid.countLives());
    }


/*    Any live cell with fewer than two live neighbours dies, as if caused by under-population.
Any live cell with two or three live neighbours lives on to the next generation.
Any live cell with more than three live neighbours dies, as if by overcrowding.
Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.*/

}
    