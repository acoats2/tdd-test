package ch.crisi.tdd.gameOfLife.rules;

import ch.crisi.tdd.gameOfLife.Cell;
import ch.crisi.tdd.gameOfLife.Grid;
import org.junit.Test;

public class AliveCellWithFewerThanTwoAliveNeighboursDiesTest {


    @Test
    public void shouldApplyRule() {
        Grid grid = new Grid(3);
        grid.put(new Cell(0, 0));
        grid.put(new Cell(1, 1));

        Grid actual = new AliveCellWithFewerThanTwoAliveNeighboursDies(grid);
    }
}
